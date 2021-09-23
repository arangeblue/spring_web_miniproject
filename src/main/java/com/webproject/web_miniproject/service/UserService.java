package com.webproject.web_miniproject.service;

import com.webproject.web_miniproject.domain.User;
import com.webproject.web_miniproject.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    

    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User join(User user) {
        return userRepository.save(user);
    }
}
