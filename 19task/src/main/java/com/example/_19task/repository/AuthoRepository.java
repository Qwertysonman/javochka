package com.example._19task.repository;

import com.example._19task.model.Autho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface AuthoRepository extends JpaRepository<Autho, Long> {
    void deleteById(Long id);
    List<Autho> findByBrandName(String brandName);
    List<Autho> findByNameUser(String nameUser);
    List<Autho> findByYearProduction(Integer yearProduction);
    List<Autho> findByDateAccounting(LocalDate dateAccounting);
    List<Autho> findAllByOrderByDateAccounting();

}
