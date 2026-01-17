package org.sangam.springsecurity.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignupRequestDTO {

    String email;
    String password;
    String phoneNumber;
    String name;
}
