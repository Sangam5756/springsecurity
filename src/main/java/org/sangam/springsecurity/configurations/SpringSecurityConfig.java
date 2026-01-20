package org.sangam.springsecurity.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig  {

        @Bean
        public SecurityFilterChain  filterationCretria (HttpSecurity http) throws Exception {

    return   http
            .csrf(csrf -> csrf.disable())

            // disable the session
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

            .authorizeHttpRequests(request->{
           //   allowed the all authentication api public
                request.requestMatchers("/api/v1/auth/signup/*").permitAll();
                request.requestMatchers("/api/v1/auth/signin/*").permitAll();
                request.requestMatchers("/orders/*").permitAll();
            }).build();
        }

    @Bean
    public BCryptPasswordEncoder bcrypasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
