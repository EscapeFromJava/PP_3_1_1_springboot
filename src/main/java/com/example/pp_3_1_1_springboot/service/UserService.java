package com.example.pp_3_1_1_springboot.service;

import com.example.pp_3_1_1_springboot.model.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    void addRandomUsers();

}
