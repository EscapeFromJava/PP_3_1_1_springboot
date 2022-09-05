package com.example.pp_3_1_1_springboot.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    private String model;
    @NotNull
    private String brand;
    @NotNull
    @Positive
    private Double price;

    public Car(String model, String brand, Double price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }
}