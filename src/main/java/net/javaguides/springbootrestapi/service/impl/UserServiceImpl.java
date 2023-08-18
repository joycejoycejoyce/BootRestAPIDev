package net.javaguides.springbootrestapi.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestapi.entity.User;
import net.javaguides.springbootrestapi.repository.UserRepository;
import net.javaguides.springbootrestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
* 所有的 service 都需要 @Service annotation
* */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> all = userRepository.findAll();
        return all;
    }

    @Override
    public User updateUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
