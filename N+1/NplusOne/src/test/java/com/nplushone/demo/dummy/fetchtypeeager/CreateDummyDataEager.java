package com.nplushone.demo.dummy.fetchtypeeager;

import com.nplushone.demo.fetchtypeeager.eagerdomain.EagerPost;
import com.nplushone.demo.fetchtypeeager.eagerdomain.EagerUser;
import com.nplushone.demo.fetchtypeeager.service.post.EagerPostRepository;
import com.nplushone.demo.fetchtypeeager.service.user.EagerUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false) // false로 두면 실제 DB에 데이터 남김
public class CreateDummyDataEager {

    @Autowired
    EagerUserRepository userRepo;
    @Autowired
    EagerPostRepository postRepo;

    /**
     * 1단계: 유저 3명 생성
     */
    @Test
    @Transactional
    @Rollback(value = false)
    void createUsers() {
        for (int u = 1; u <= 3; u++) {
            EagerUser user = new EagerUser("유저" + u, "user" + u + "@mail.com");
            userRepo.save(user);
        }
    }

    /**
     * 2단계: 특정 유저에게 게시글 3개 생성
     */
    @Test
    @Transactional
    @Rollback(value = false)
    void createPostsForUser1() {
        EagerUser user1 = userRepo.findById(1L).orElseThrow();
        EagerUser user2 = userRepo.findById(2L).orElseThrow();
        EagerUser user3 = userRepo.findById(3L).orElseThrow();

        for (int p = 1; p <= 3; p++) {
            EagerPost post = new EagerPost(user1, "포스트" + p);
            postRepo.save(post);
        }

        for (int p = 4; p <= 6; p++) {
            EagerPost post = new EagerPost(user2, "포스트" + p);
            postRepo.save(post);
        }

        for (int p = 7; p <= 9; p++) {
            EagerPost post = new EagerPost(user3, "포스트" + p);
            postRepo.save(post);
        }
    }

}
