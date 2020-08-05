package com.flameshine.app.entities;

import javax.persistence.*;
import java.util.Collection;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", nullable = false)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private Collection<User> users;
}