package com.flameshine.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import com.flameshine.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(@Param(value = "username") String username);

    Optional<User> findByEmail(@Param(value = "email") String email);
}