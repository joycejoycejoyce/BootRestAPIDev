package net.javaguides.springbootrestapi.dto;
// 用来在 client <-> server 之间传递信息

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
    private String firstName;
    private String lastName;
    private String email;


}
