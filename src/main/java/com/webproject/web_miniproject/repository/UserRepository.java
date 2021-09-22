package com.webproject.web_miniproject.repository;

import com.webproject.web_miniproject.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
