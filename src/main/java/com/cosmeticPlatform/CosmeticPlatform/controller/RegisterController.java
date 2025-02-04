package com.cosmeticPlatform.CosmeticPlatform.controller;

import jakarta.validation.Valid;
import com.cosmeticPlatform.CosmeticPlatform.model.User;
import com.cosmeticPlatform.CosmeticPlatform.model.request.UserRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cosmeticPlatform.CosmeticPlatform.service.UserService;

@RestController
    @RequestMapping("/api")
    public class RegisterController {
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
            User user=new User();
            user.setUsername(userRequestDTO.getUsername());
            user.setEmail(userRequestDTO.getEmail());
            user.setPassword(userRequestDTO.getPassword());
            user.setUserType(userRequestDTO.getUserType());
            return userService.addUser(user);

    }
}

