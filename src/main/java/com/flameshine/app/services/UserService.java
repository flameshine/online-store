package com.flameshine.app.services;

import java.util.Optional;
import com.flameshine.app.entities.User;

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(User user);
}