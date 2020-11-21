package com.flameshine.app.service;

import java.util.Optional;

import com.flameshine.app.entity.User;

/**
 * @author Anton Pokhyla
 */

public interface UserService {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    void save(User user);
}