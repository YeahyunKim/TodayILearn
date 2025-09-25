package com.nplushone.demo.fetchtypelazy.service.post.dto;

import com.nplushone.demo.fetchtypelazy.lazyDomain.Post;

import java.util.List;
import java.util.Objects;

public class UserWithPostListResponseDto<T> {
    private String userName;
    private List<T> posts;


    public UserWithPostListResponseDto(String name, List<T> posts) {
        this.userName = name;
        this.posts = posts;
    }
}
