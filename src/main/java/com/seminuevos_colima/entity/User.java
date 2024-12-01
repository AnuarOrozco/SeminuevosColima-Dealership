package com.seminuevos_colima.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Email(message = "El email debe ser válido")
    @NotEmpty(message = "El email no puede estar vacío")
    @Column(name = "email")
    private String email;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @NotEmpty(message = "La contraseña no puede estar vacía")
    @Column(name = "contrasenia")
    private String password;

    @Column(name = "rol")
    private Role role;

    @OneToMany(mappedBy = "owner")
    private List<Car> publishedCars;

    @ManyToMany
    @JoinTable(
            name = "usuario_lista_deseados",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_vehiculo")
    )
    private List<Car> wishlist;

}
