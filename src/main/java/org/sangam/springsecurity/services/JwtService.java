package org.sangam.springsecurity.services;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService  implements CommandLineRunner{

    @Value("${jwt.expiry}")
    private int expiry;
    @Value("${jwt.secret}")
    private  String secret;

    private SecretKey key;

//    now create the token
//    based on the payload
    private String createToken(Map<String, Object> payload,String username) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiry*1000L);
        key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        return Jwts.builder()
                .claims(payload)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiryDate)
                .subject(username)
                .signWith(key)
                .compact();

    }

    private Claims extractAllPayloads(String token){
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
    }

//    need to look at this method
    private <T> T extractClaims(String token, Function<Claims,T> claimResolver){
        final Claims claims = extractAllPayloads(token);
        return claimResolver.apply(claims);
    }







    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);

    }

    private Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
    }

    private String extractUsername(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    private Boolean validateToken(String token,String email) {

        final String userEmailFetchedFromToken = extractUsername(token);
        return (email.equals(userEmailFetchedFromToken) && !isTokenExpired(token));

    }


    @Override
    public void run(String... args) throws Exception {
            Map<String,Object> payload = new HashMap<>();
            payload.put("username","sangam");
            payload.put("phone","3343434343");
        System.out.println(createToken(payload,"sangam"));

    }
}
