package net.javaguides.springbootrestapi.service;


import net.javaguides.springbootrestapi.dto.UserDTO;
import net.javaguides.springbootrestapi.entity.User;

import java.util.List;

/*
* 在这里 define 所有的 services
* */
public interface UserService {
    UserDTO createUser(UserDTO user);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long id);
}
