package com.nightingale.dto;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO {
    private String name;
    private String password;
}
