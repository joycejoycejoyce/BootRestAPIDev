package net.javaguides.springbootrestapi.repository;


import net.javaguides.springbootrestapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
* JPARepository<Entity type, primary key type>

* 这里什么也不需要写， JPA 会提供 UserRepository interface 的 CRUD Implementation
* */
/* 我们这个 userrepository 不需要再加 anntation 因为：
* SimpleJpaRespotory 已经被 annotate 了 @Repository + @Transactional
* */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
