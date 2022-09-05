package com.example.pp_3_1_1_springboot.dao;

import com.example.pp_3_1_1_springboot.model.Car;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final EntityManager entityManager;

    public CarDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Car> getAllCars() {
        return entityManager.createQuery("SELECT c FROM Car c", Car.class).getResultList();
    }
}
