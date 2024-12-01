package com.seminuevos_colima.service.impl;

import com.seminuevos_colima.entity.Car;
import com.seminuevos_colima.repository.CarRepository;
import com.seminuevos_colima.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car editCar(Long id, Car car) {
        Car existingCar = carRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Car not found"));

        existingCar.setBrand(car.getBrand());
        existingCar.setModel(car.getModel());
        existingCar.setYear(car.getYear());
        existingCar.setCity(car.getCity());
        existingCar.setMileage(car.getMileage());
        existingCar.setIsNegotiable(car.getIsNegotiable());
        existingCar.setPrice(car.getPrice());
        existingCar.setType(car.getType());
        existingCar.setHasAirConditioning(car.getHasAirConditioning());
        existingCar.setTraction(car.getTraction());
        existingCar.setColor(car.getColor());
        existingCar.setTypeOfWindows(car.getTypeOfWindows());
        existingCar.setSteeringSystem(car.getSteeringSystem());
        existingCar.setTransmissionType(car.getTransmissionType());
        existingCar.setUpholsteryType(car.getUpholsteryType());
        existingCar.setFuelType(car.getFuelType());
        existingCar.setIsAvailable(car.getIsAvailable());
        existingCar.setOwner(car.getOwner());

        return carRepository.save(existingCar);
    }

    @Override
    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found");
        }
        carRepository.deleteById(id);
    }
}

