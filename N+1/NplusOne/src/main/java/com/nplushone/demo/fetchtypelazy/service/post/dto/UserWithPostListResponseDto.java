package com.nplushone.demo.fetchtypelazy.service.post.dto;

import com.nplushone.demo.fetchtypelazy.lazyDomain.Post;

import java.util.List;

public class UserWithPostListResponseDto {
    private String userName;
    private List<Post> posts;


    public UserWithPostListResponseDto(String name, List<Post> posts) {
        this.userName = name;
        this.posts = posts;
    }
}
