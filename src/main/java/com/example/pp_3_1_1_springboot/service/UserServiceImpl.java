package com.example.pp_3_1_1_springboot.service;

import com.example.pp_3_1_1_springboot.model.User;
import com.example.pp_3_1_1_springboot.repository.UserRepository;
import com.example.pp_3_1_1_springboot.util.UserGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public void addRandomUsers() {
        userRepository.saveAll(UserGenerator.generateUsers());
    }
}
