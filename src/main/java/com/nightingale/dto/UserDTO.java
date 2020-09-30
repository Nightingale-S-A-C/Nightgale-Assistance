package com.nightingale.dto;


import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    @Length(min = 2, max = 50, message = "El nombre debe contener entre 2 y 50 caracteres" )
    private String name;
    @Email(message = "Email invalido")
    private String email;
    @NotNull(message = "Ingrese un rol de acceso")
    private String role;
}