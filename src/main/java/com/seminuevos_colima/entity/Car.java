package com.seminuevos_colima.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "vehiculos")
public class Car {

    private Long id;
    private String brand;
    private String model;
    private Integer year;
    private String city;
    private Integer mileage;
    private Boolean isNegotiable;
    private BigDecimal price;
    private String type;
    private Boolean hasAirConditioning;
    private String traction;
    private String color;
    private String typeOfWindows;
    private String steeringSystem;
    private String transmissionType;
    private String upholsteryType;
    private String fuelType;
    private Boolean isAvailable;

}
