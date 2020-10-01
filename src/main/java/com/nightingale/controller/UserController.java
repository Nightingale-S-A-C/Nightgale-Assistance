package com.nightingale.controller;


import com.nightingale.entity.User;
import com.nightingale.repository.UserRepository;
import com.nightingale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/Users")
//    public Page<User> getUser(Pageable pageable){
//        //return UserRepository.find
//    }
}
