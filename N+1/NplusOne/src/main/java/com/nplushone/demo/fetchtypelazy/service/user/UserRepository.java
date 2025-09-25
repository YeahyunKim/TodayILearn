package com.nplushone.demo.fetchtypelazy.service.user;

import com.nplushone.demo.fetchtypelazy.lazyDomain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
