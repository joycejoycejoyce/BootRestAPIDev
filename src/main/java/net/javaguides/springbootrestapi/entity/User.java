package net.javaguides.springbootrestapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter // create getter methods
@Setter // create setter methods
@NoArgsConstructor // create constructor with no args
@AllArgsConstructor // use all fields when creating an instance

@Entity // sepcifies that the class is a JPA entity
@Table(name = "users") // 如果不 Specify name 的话，JPA 会创造一个和 class name 相同的 table
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;


}
