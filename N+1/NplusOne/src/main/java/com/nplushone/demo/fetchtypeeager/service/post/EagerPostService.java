package com.nplushone.demo.fetchtypeeager.service.post;

import com.nplushone.demo.fetchtypeeager.eagerdomain.EagerPost;
import com.nplushone.demo.fetchtypeeager.eagerdomain.EagerUser;
import com.nplushone.demo.fetchtypeeager.service.user.EagerUserRepository;
import com.nplushone.demo.fetchtypelazy.lazyDomain.Post;
import com.nplushone.demo.fetchtypelazy.lazyDomain.User;
import com.nplushone.demo.fetchtypelazy.service.post.PostRepository;
import com.nplushone.demo.fetchtypelazy.service.post.dto.UserWithPostListResponseDto;
import com.nplushone.demo.fetchtypelazy.service.user.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EagerPostService {
    private final EagerPostRepository eagerPostRepository;
    private final EagerUserRepository eagerUserRepository;


    //lazy일때 post에서 유저 이름 불러오기
    public void getPost(Long id) {
        //post를 id로 조회 쿼리 1회
        EagerPost post = eagerPostRepository.findById(id).orElseThrow(NullPointerException::new);

        //post에서 getUser()로 인해 User 프록시 객체에서 user 테이블 DB 조회 1회
        String name = post.getEagerUser().getName();

        //총 1+1 의 조회가 발생
        System.out.println(name);
    }

    //lazy일때 모든 post에서 유저 이름 불러오기
    public void getPosts() {
        //모든 포스트를 조회하는 쿼리 1회
        List<EagerPost> all = eagerPostRepository.findAll(); //9

        //9번 돌아감
        for (EagerPost post : all) {
            //포스트 별로 유저DB 탐색하는 N회 발생 -> 시발 안해
            String name = post.getEagerUser().getName();
            System.out.println(name);
        }
    }

    //lazy일때 모든 유저에서 가져오기
    public void getPostsWithUsers() {
        List<EagerUser> users = eagerUserRepository.findAll();
        ArrayList<UserWithPostListResponseDto> dtos = new ArrayList<>();

        for(EagerUser user : users) {

            List<EagerPost> posts = eagerPostRepository.findAllByEagerUserId(user.getId());

            UserWithPostListResponseDto dto = new UserWithPostListResponseDto(user.getName(), posts);

            dtos.add(dto);
        }
    }

}
