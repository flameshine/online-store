package com.flameshine.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.flameshine.app.entity.Role;

/**
 * @author Anton Pokhyla
 */

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(@Param(value = "roleName") String roleName);
}