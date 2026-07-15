package com.devlaunch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devlaunch.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByName(String name);

    boolean existsByEmail(String email);
}