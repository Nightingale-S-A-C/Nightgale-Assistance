package com.nightingale.dto;

import com.nightingale.utils.enumRole;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDTO {

    private String name;
    private String password;
    private String email;
    private enumRole role;
}
