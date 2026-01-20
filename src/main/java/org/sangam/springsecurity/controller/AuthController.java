package org.sangam.springsecurity.controller;

import org.sangam.springsecurity.dto.UserDTO;
import org.sangam.springsecurity.dto.UserSignupRequestDTO;
import org.sangam.springsecurity.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")

public class AuthController {

    private final  AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/signup/user")
    ResponseEntity<?> signUp(@RequestBody UserSignupRequestDTO userSignupRequestDTO) {
        UserDTO userresponse = authService.signupUser(userSignupRequestDTO);

        return new ResponseEntity<>(userresponse, HttpStatus.OK);

    }

    @PostMapping("/signin/user")
    ResponseEntity<?> signIn(){
        return new ResponseEntity<>(10,HttpStatus.OK);
    }
}
