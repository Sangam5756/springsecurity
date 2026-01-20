package org.sangam.springsecurity.services;

import lombok.AllArgsConstructor;
import org.sangam.springsecurity.dto.UserDTO;
import org.sangam.springsecurity.dto.UserSignupRequestDTO;
import org.sangam.springsecurity.models.User;
import org.sangam.springsecurity.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final  UserRepository userRepository;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;


    public UserDTO signupUser(UserSignupRequestDTO userSignupRequestDTO){
        User user = User.builder()
                .email(userSignupRequestDTO.getEmail())
                .name(userSignupRequestDTO.getName())
                .password(bcryptPasswordEncoder.encode(userSignupRequestDTO.getPassword())) //encrypt password later
                .phoneNumber(userSignupRequestDTO.getPhoneNumber())
                .build();
        User saveUser = userRepository.save(user);



        return UserDTO.from(saveUser);
    }


}
