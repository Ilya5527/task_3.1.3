package com.example.springproject3_1_3.service;

import com.example.springproject3_1_3.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {


    void addUser(User user);

    void deleteUser(long id);

    List<User> getAllUsers();

    User getUserById(long id);

    void updateUser(User changedUser);
}
