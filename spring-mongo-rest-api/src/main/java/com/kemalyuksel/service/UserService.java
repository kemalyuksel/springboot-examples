package com.kemalyuksel.service;

import com.kemalyuksel.entity.User;
import com.kemalyuksel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User CreateUser(User user){
        return userRepository.save(user);
    }

    public User GetUserById(String id){
        return userRepository.findById(id).get();
    }

    public List<User> GetAllUsers(){
        return userRepository.findAll();
    }
}
