package com.nplushone.demo.fetchtypeeager.controller;

import com.nplushone.demo.fetchtypeeager.service.user.EagerUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/eager/users")
public class EagerUserController {
    private final EagerUserService eagerUserService;

    @GetMapping
    private void getUser() {
        eagerUserService.getUser();
    }

    @GetMapping("/all")
    private void getUsers() {
        eagerUserService.getUsers();
    }
}
