package net.joyce.departmentService.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import net.joyce.departmentService.dto.UserDTO;
import net.joyce.departmentService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
// define 一个 base url
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    /*@Valid annotation 表明了要 enable validation 对这个 UserDTO */
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
        UserDTO saved = userService.createUser(user);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        UserDTO dto = userService.getUserById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    // http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,
                                              @Valid @RequestBody UserDTO user) {
        user.setId(id);
        UserDTO updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    // http://localhost:8080/api/users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }



    /*
    * 怎么写 specific exceptions with respect to the controller
    * */
    // @ExceptionHandler annotation 就是用来 handle specific exception 然后把 custom responses 发给 client
/*    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorDetails details = new ErrorDetails(LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND");

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }*/
}
