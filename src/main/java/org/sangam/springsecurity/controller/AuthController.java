package org.sangam.springsecurity.controller;

import org.sangam.springsecurity.dto.UserSignupRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    @PostMapping("/signup/user")
    ResponseEntity<?> signUp(@RequestBody UserSignupRequestDTO userSignupRequestDTO) {

        return null;
    }

}
