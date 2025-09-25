package com.nplushone.demo.fetchtypelazy.service.post;

import com.nplushone.demo.fetchtypelazy.lazyDomain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUserId(Long id);
}
