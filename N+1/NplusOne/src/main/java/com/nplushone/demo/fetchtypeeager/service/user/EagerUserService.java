package com.nplushone.demo.fetchtypeeager.service.user;

import com.nplushone.demo.fetchtypeeager.eagerdomain.EagerPost;
import com.nplushone.demo.fetchtypeeager.eagerdomain.EagerUser;
import com.nplushone.demo.fetchtypelazy.lazyDomain.Post;
import com.nplushone.demo.fetchtypelazy.lazyDomain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EagerUserService {
    private final EagerUserRepository eagerUserRepository;

    public void getUser() {
        EagerUser user = eagerUserRepository.findById(1L).orElseThrow(NullPointerException::new);
        List<EagerPost> posts = user.getEagerPosts();
        for (EagerPost post : posts) {
            System.out.println(post.getTitle());
        }
    }

    public void getUsers() {
        List<EagerUser> all = eagerUserRepository.findAll();
        for (EagerUser user : all) {
            List<EagerPost> posts = user.getEagerPosts();
            for (EagerPost post : posts) {
                System.out.println(post.getTitle());
            }
        }
    }

}
