package org.sangam.springsecurity.dto;

import lombok.*;
import org.sangam.springsecurity.models.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    private String email;
    private String name;
    private String password;
    private String phoneNumber;

    public static UserDTO from(User u){
return       UserDTO.builder()
                .id(u.getId())
                .email(u.getEmail())
                .name(u.getName())
                .password(u.getPassword())
                .phoneNumber(u.getPhoneNumber())
                .build();
    }

}
