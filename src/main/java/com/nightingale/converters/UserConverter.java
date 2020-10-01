package com.nightingale.converters;

import com.nightingale.dto.ProductDTO;
import com.nightingale.dto.UserDTO;
import com.nightingale.entity.Product;
import com.nightingale.entity.User;
import com.nightingale.utils.enumRole;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserConverter extends AbstractConverter<User, UserDTO>{

    @Override
    public UserDTO fromEntity(User entity){
        if(entity == null) return null;

        return UserDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .role(entity.getRole().toString())
                .build();
    }

    @Override
    public User fromDTO(UserDTO dto) {
        if(dto == null) return null;
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .role(enumRole.valueOf(dto.getRole()))//Value of para conseguir el enum en base a un string
                .build();
    }
}
