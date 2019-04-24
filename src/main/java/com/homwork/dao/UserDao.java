package com.homwork.dao;

import com.homwork.entity.User;

import java.util.List;

public interface UserDao {
    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();
}
