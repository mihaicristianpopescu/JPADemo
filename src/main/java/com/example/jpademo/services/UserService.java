package com.example.jpademo.services;

import com.example.jpademo.entities.User;
import com.example.jpademo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(final Long id) {
        return userRepository.findById(id).get();
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }
}
