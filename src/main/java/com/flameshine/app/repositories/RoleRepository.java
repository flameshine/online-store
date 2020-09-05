package com.flameshine.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import com.flameshine.app.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(@Param(value = "roleName") String roleName);
}