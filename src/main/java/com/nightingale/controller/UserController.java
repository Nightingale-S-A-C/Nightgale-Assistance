package com.nightingale.controller;


import com.nightingale.converters.UserConverter;
import com.nightingale.entity.User;
import com.nightingale.exceptions.ResourceNotFoundException;
import com.nightingale.repository.UserRepository;
import com.nightingale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserConverter convert;

    @GetMapping("/users")
    public Page<User> getUser(Pageable pageable){
        return userRepo.findAll(pageable);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PutMapping("/users/{userId}")
    public User UpdateUser( @PathVariable Long userId,
                            @RequestBody User userRequest) {
        return userRepo.findById(userId).map(user -> {
            user.setName(userRequest.getName());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());

            return userRepo.save(user);
        }).orElseThrow(()->new ResourceNotFoundException("User not found with id = "+userId));
    }
}
