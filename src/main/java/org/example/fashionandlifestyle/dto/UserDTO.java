package org.example.fashionandlifestyle.dto;

import lombok.*;
import org.example.fashionandlifestyle.entity.Enum.Role;
import org.example.fashionandlifestyle.entity.Enum.UserStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String userName;
    private String fullName;
    private String avatar;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private Role role = Role.CUSTOMER;
    private UserStatus status = UserStatus.ACTIVE;
    private LocalDateTime createAt;

}
