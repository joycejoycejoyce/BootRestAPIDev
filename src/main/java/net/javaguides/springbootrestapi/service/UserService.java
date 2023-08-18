package net.javaguides.springbootrestapi.service;


import net.javaguides.springbootrestapi.entity.User;

import java.util.List;

/*
* 在这里 define 所有的 services
* */
public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long id);
}
