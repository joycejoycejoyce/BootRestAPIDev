package net.joyce.departmentService.dto;
// 用来在 client <-> server 之间传递信息

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    // 不要把 sensitive info 放在这里面
    private Long id;
    // REST API validation, user first name 不能是 null or empty
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;

    @NotEmpty(message = "User email should not be null or empty")
    // validate 这是一个 valid email address
    @Email(message = "Email address should be valid")
    private String email;


}
