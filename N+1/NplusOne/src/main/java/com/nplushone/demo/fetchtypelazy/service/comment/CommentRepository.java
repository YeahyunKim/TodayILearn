package com.nplushone.demo.fetchtypelazy.service.comment;


import com.nplushone.demo.fetchtypelazy.lazyDomain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
