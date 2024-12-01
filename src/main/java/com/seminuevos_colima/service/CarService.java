package com.seminuevos_colima.service;

import com.seminuevos_colima.entity.Car;
import com.seminuevos_colima.entity.User;

public interface CarService {

    Car createCar(Car car);
    Car editCar(Long id, Car car);
    void deleteCar(Long id);

}
