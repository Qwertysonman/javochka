package com.example._19task.repository;

import com.example._19task.model.Autho;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class InMemoryAutho {
    private final List<Autho> AUTHOS = new ArrayList<>();

    public List<Autho> findAllAutho() {
        return AUTHOS;
    }

    public Autho saveAutho(Autho autho) {
        AUTHOS.add(autho);
        return autho;
    }

    public List<Autho> findbybrand(String brandName) {
        return AUTHOS.stream()
                .filter(element -> element.getBrandName().equals(brandName))
                .collect(Collectors.toList());
    }
    public List<Autho> findbyid(Long id) {
        return AUTHOS.stream()
                .filter(element -> element.getId().equals(id))
                .collect(Collectors.toList());
    }
    public List<Autho> findbynameuser(String nameUser) {
        return AUTHOS.stream()
                .filter(element -> element.getNameUser().equals(nameUser))
                .collect(Collectors.toList());
    }
    public List<Autho> findbyyearproduction(Integer yearProduction) {
        return AUTHOS.stream()
                .filter(element -> element.getYearProduction().equals(yearProduction))
                .collect(Collectors.toList());
    }
    public List<Autho> findbydateaccounting(LocalDate dateAccounting) {
        return AUTHOS.stream()
                .filter(element -> element.getDateAccounting().equals(dateAccounting))
                .collect(Collectors.toList());
    }
    public Autho updateautho(Autho autho) {
        var authoIndex = IntStream.range(0, AUTHOS.size())
                .filter(index -> AUTHOS.get(index).getBrandName().equals(autho.getBrandName()))
                .findFirst()
                .orElse(-1);
        if (authoIndex > -1) {
            AUTHOS.set(authoIndex, autho);
            return autho;
        }
        return null;
    }

    public void deleteById(Long id) {
        var autho = findbyid(id);
        if (autho != null) {
            AUTHOS.remove(autho);
        }
    }
    public List<Autho> findallsortedbydate() {
        return AUTHOS.stream()
                .sorted((a1, a2) -> a1.getDateAccounting().compareTo(a2.getDateAccounting()))
                .collect(Collectors.toList());
    }

}
