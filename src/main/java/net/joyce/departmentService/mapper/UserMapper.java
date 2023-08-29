package net.joyce.departmentService.mapper;


import net.joyce.departmentService.dto.UserDTO;
import net.joyce.departmentService.entity.User;

public class UserMapper {
    public static UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
        return userDTO;
    }

    public static User mapToUser(UserDTO dto) {
        User user = new User(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
        return user;
    }
}
