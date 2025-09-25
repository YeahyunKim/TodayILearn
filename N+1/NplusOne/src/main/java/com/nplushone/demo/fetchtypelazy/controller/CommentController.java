package com.nplushone.demo.fetchtypelazy.controller;

import com.nplushone.demo.fetchtypelazy.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

//    @GetMapping
//    private void getComment() {
//        userService.getUser();
//    }
}
