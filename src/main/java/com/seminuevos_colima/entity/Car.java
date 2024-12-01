package com.seminuevos_colima.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "vehiculos")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long id;

    @Column(name = "marca")
    private String brand;

    @Column(name = "modelo")
    private String model;

    @Column(name = "anio")
    private Integer year;

    @Column(name = "ciudad")
    private String city;

    @Column(name = "kilometraje")
    private Integer mileage;

    @Column(name = "es_negociable")
    private Boolean isNegotiable;

    @Column(name = "precio")
    private BigDecimal price;

    @Column(name = "tipo")
    private String type;

    @Column(name = "tiene_aire_acondicionado")
    private Boolean hasAirConditioning;

    @Column(name = "traccion")
    private String traction;

    @Column(name = "color")
    private String color;

    @Column(name = "tipo_de_ventanas")
    private String typeOfWindows;

    @Column(name = "sistema_de_direccion")
    private String steeringSystem;

    @Column(name = "tipo_de_transmicion")
    private String transmissionType;

    @Column(name = "tapiceria")
    private String upholsteryType;

    @Column(name = "combustible")
    private String fuelType;

    @Column(name = "esta_disponible")
    private Boolean isAvailable;

    @ManyToOne
    private User owner;

    @ManyToMany(mappedBy = "wishlist")
    private List<User> usersWishlist;

}
