package com.nightingale.controller;


import com.nightingale.converters.UserConverter;
import com.nightingale.dto.UserDTO;
import com.nightingale.entity.User;
import com.nightingale.service.UserService;
import com.nightingale.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){


        List<User> users = userService.findAll();
        List<UserDTO> dtoUsers = userConverter.fromEntity(users);

        return new WrapperResponse(true, "success", dtoUsers)
                .createResponse(HttpStatus.OK);
    }
}
