package com.nplushone.demo.fetchtypelazy.service.user;

import com.nplushone.demo.fetchtypelazy.lazyDomain.Post;
import com.nplushone.demo.fetchtypelazy.lazyDomain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public void getUser() {
        User user = userRepo.findById(1L).orElseThrow(NullPointerException::new);
        List<Post> posts = user.getPosts();
        for (Post post : posts) {
            System.out.println(post.getTitle());
        }
    }

    public void getUsers() {
        List<User> all = userRepo.findAll();
        for (User user : all) {
            List<Post> posts = user.getPosts();
            for (Post post : posts) {
                System.out.println(post.getTitle());
            }
        }
    }

}
