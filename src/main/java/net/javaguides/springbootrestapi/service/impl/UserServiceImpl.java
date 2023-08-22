package net.javaguides.springbootrestapi.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springbootrestapi.dto.UserDTO;
import net.javaguides.springbootrestapi.entity.User;
import net.javaguides.springbootrestapi.exception.EmailAlreadyExistsException;
import net.javaguides.springbootrestapi.exception.ResourceNotFoundException;
import net.javaguides.springbootrestapi.mapper.UserMapper;
import net.javaguides.springbootrestapi.repository.UserRepository;
import net.javaguides.springbootrestapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
* 所有的 service 都需要 @Service annotation
* */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO dto) {
        // 检查这个 email 是不是已经存在了
        Optional<User> optionalUser = userRepository.findByEmail(dto.getEmail());
        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already Exists for User");
        }
        // convert UserDTO into User JPA entity
        User user = modelMapper.map(dto, User.class);
        // 把 user 存到 db
        User saved = userRepository.save(user);

        // 这个返回来的 saved user object 有 primary key
        UserDTO res = modelMapper.map(saved, UserDTO.class);
        return res;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> {
                    return new ResourceNotFoundException("User", "id", id);
                }
        );

        UserDTO dto = modelMapper.map(user, UserDTO.class);
        return dto;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map((user) -> {
            return modelMapper.map(user, UserDTO.class);
        }).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO dto) {
        // 首先确认这个user 存在在 db 里面
        User user = userRepository.findById(dto.getId()).orElseThrow(() ->{
            return new ResourceNotFoundException("User", "id", dto.getId());
        });

        User save = userRepository.save(UserMapper.mapToUser(dto));
        return modelMapper.map(save, UserDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        // 首先确认这个user 存在在 db 里面
        User user = userRepository.findById(id).orElseThrow(() ->{
            return new ResourceNotFoundException("User", "id", id);
        });
        userRepository.deleteById(id);
    }
}
