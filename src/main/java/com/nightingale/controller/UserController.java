package com.nightingale.controller;


import com.nightingale.converters.UserConverter;
import com.nightingale.dto.LoginRequestDTO;
import com.nightingale.dto.LoginResponseDTO;
import com.nightingale.dto.SignupRequestDTO;
import com.nightingale.dto.UserDTO;
import com.nightingale.entity.User;
import com.nightingale.exceptions.ResourceNotFoundException;
import com.nightingale.repository.UserRepository;
import com.nightingale.service.UserService;
import com.nightingale.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @PostMapping("/signup")
    public ResponseEntity<WrapperResponse<UserDTO>> signup(@RequestBody SignupRequestDTO request){
        User user=userService.createUser(userConverter.signup(request));
        return new WrapperResponse<>(true,"success",userConverter.fromEntity(user))
                .createResponse();
    }

    @PostMapping("/login")
    public ResponseEntity<WrapperResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO request){
        LoginResponseDTO response=userService.login(request);
        return new WrapperResponse<>(true,"success",response)
                .createResponse();
    }


}
