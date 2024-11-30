package com.seminuevos_colima.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "usuarios")
@AllArgsConstructor @NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;

}
