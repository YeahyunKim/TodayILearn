package com.nplushone.demo.dummy.fetchtypelazy;

import com.nplushone.demo.fetchtypelazy.lazyDomain.Comment;
import com.nplushone.demo.fetchtypelazy.lazyDomain.Post;
import com.nplushone.demo.fetchtypelazy.lazyDomain.User;
import com.nplushone.demo.fetchtypelazy.service.comment.CommentRepository;
import com.nplushone.demo.fetchtypelazy.service.post.PostRepository;
import com.nplushone.demo.fetchtypelazy.service.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(false) // false로 두면 실제 DB에 데이터 남김
public class CreateDummyData {

    @Autowired UserRepository userRepo;
    @Autowired PostRepository postRepo;
    @Autowired CommentRepository commentRepo;

    /**
     * 1단계: 유저 3명 생성
     */
    @Test
    @Transactional
    @Rollback(value = false)
    void createUsers() {
        for (int u = 1; u <= 3; u++) {
            User user = new User("유저" + u, "user" + u + "@mail.com");
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
        User user1 = userRepo.findById(1L).orElseThrow();
        User user2 = userRepo.findById(2L).orElseThrow();
        User user3 = userRepo.findById(3L).orElseThrow();

        for (int p = 1; p <= 3; p++) {
            Post post = new Post(user1, "포스트" + p);
            postRepo.save(post);
        }

        for (int p = 4; p <= 6; p++) {
            Post post = new Post(user2, "포스트" + p);
            postRepo.save(post);
        }

        for (int p = 7; p <= 9; p++) {
            Post post = new Post(user3, "포스트" + p);
            postRepo.save(post);
        }
    }

    /**
     * 3단계: 특정 게시글에 댓글 3개 생성
     */
    @Test
    @Transactional
    @Rollback(value = false)
    void createCommentsForPost1() {
        Post post1 = postRepo.findById(1L).orElseThrow();

        for (int c = 1; c <= 3; c++) {
            Comment comment = new Comment();
            comment.setPost(post1);
            comment.setComment("글1의 댓글" + c);
            commentRepo.save(comment);
        }
    }
}
