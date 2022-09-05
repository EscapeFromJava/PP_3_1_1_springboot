package com.example.pp_3_1_1_springboot.service;

import com.example.pp_3_1_1_springboot.dao.CarDao;
import com.example.pp_3_1_1_springboot.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }
}
