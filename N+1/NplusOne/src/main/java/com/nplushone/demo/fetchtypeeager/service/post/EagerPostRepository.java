package com.nplushone.demo.fetchtypeeager.service.post;

import com.nplushone.demo.fetchtypeeager.eagerdomain.EagerPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EagerPostRepository extends JpaRepository<EagerPost, Long> {
    List<EagerPost> findAllByEagerUserId(Long id);
}
