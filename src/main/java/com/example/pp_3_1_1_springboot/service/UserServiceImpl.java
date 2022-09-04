package com.example.pp_3_1_1_springboot.service;

import com.example.pp_3_1_1_springboot.dao.UserDao;
import com.example.pp_3_1_1_springboot.model.User;
import com.example.pp_3_1_1_springboot.util.UserGenerator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void addRandomUsers() {
        UserGenerator.generateUsers().forEach(userDao::saveUser);
    }
}
