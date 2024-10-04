package com.example._19task.service;

import com.example._19task.model.Autho;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
public interface AuthoService {
    List<Autho> findAllAutho();
    Autho saveAutho(Autho autho);
    List<Autho> findbybrand(String brandName);
    List<Autho> findbynameuser(String nameUser);
    List<Autho> findbyyearproduction(Integer yearProduction);
    List<Autho> findbydateaccounting(LocalDate dateAccounting);
    List<Autho> sortauthosbydate(List <Autho> autholist);
    Autho updateautho(Autho autho);
    void deleteautho(Long id);
    List<Autho> findallsortedbyyear();
}
