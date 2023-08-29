package net.joyce.departmentService.entity;

import jakarta.persistence.*;
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
    @Id
    // IDENTITY: 会有 auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)

    private String lastName;
    // 这个 email 必须是一个 unique value
    @Column(nullable = false, unique = true)
    private String email;


}
