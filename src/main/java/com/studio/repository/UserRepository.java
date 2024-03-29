package com.studio.repository;

import com.studio.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(final String email);
    User findByEmailAndPassword(final String email,final String password);
    User findByEmail(final String email);
}
