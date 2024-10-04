package com.example._19task.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
@Entity
@Table(name = "Autho_park")
public class Autho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private Integer yearProduction;
    private LocalDate dateAccounting;
    private String nameUser;
    @Transient
    private int ageCar;

    public int getage_car(){
        return Period.between(dateAccounting, LocalDate.now()).getYears() + 1;
    }
}
