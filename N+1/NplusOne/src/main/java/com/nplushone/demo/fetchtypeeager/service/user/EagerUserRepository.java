package com.nplushone.demo.fetchtypeeager.service.user;

import com.nplushone.demo.fetchtypeeager.eagerdomain.EagerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EagerUserRepository extends JpaRepository<EagerUser, Long> {
}
