package com.nightingale.converters;

import com.nightingale.dto.SignupRequestDTO;
import com.nightingale.dto.UserDTO;
import com.nightingale.entity.User;

public class UserConverter extends AbstractConverter<User, UserDTO>{

    @Override
    public UserDTO fromEntity(User entity) {
        return UserDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public User fromDTO(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    public User signup(SignupRequestDTO dto){
        return User.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .role(dto.getRole())
                .build();
    }
}
