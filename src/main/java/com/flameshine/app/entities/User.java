package com.flameshine.app.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Collection;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "Please, enter a valid email.")
    @NotEmpty(message = "Please, provide an email.")
    private String email;

    @Column(name = "username", unique = true, nullable = false)
    @Length(min = 5, message = "Username must have at least 5 characters.")
    @NotEmpty(message = "This field is required.")
    private String username;

    @Column(name = "password", unique = true, nullable = false)
    @Length(min = 5, message = "Password must have at least 5 characters.")
    @NotEmpty(message = "This field is required.")
    @JsonIgnore
    private String password;

    @Column(name = "firstName", nullable = false)
    @NotEmpty(message = "This field is required.")
    private String firstName;

    @Column(name = "lastName", nullable = false)
    @NotEmpty(message = "This field is required.")
    private String lastName;

    @Column(name = "isActive", nullable = false)
    private int isActive;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;
}