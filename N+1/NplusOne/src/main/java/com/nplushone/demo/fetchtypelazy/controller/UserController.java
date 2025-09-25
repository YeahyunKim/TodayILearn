package com.nplushone.demo.fetchtypelazy.controller;

import com.nplushone.demo.fetchtypelazy.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    private void getUser() {
        userService.getUser();
    }

    @GetMapping("/all")
    private void getUsers() {
        userService.getUsers();
    }
}
