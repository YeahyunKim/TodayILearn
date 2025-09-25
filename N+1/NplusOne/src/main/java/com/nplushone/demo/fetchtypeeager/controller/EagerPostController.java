package com.nplushone.demo.fetchtypeeager.controller;

import com.nplushone.demo.fetchtypelazy.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/eager/posts")
public class EagerPostController {
    private final PostService postService;

    @GetMapping("/{postId}")
    public void getPost(
            @PathVariable Long postId
    ) {
        postService.getPost(postId);
    }

    @GetMapping
    public void getPosts(
    ) {
        postService.getPosts();
    }
}
