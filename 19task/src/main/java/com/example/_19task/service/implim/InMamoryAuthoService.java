package com.example._19task.service.implim;

import com.example._19task.model.Autho;
import com.example._19task.repository.InMemoryAutho;
import com.example._19task.service.AuthoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InMamoryAuthoService implements AuthoService {

    private final InMemoryAutho repository;

    @Override
    public List<Autho> findAllAutho() {
        return repository.findAllAutho();
    }

    @Override
    public Autho saveAutho(Autho autho) {
        return repository.saveAutho(autho);
    }

    @Override
    public List<Autho> findbybrand(String brandName) {
        return repository.findbybrand(brandName);
    }

    @Override
    public List<Autho> findbynameuser(String nameUser) {
        return repository.findbynameuser(nameUser);
    }

    @Override
    public List<Autho> findbyyearproduction(Integer yearProduction) {
        return repository.findbyyearproduction(yearProduction);
    }

    @Override
    public List<Autho> findbydateaccounting(LocalDate dateAccounting) {
        return repository.findbydateaccounting(dateAccounting);
    }

    @Override
    public List<Autho> sortauthosbydate(List<Autho> autholist) {
        return autholist.stream()
                .sorted((a1, a2) -> a1.getDateAccounting().compareTo(a2.getDateAccounting()))
                .collect(Collectors.toList());
    }

    @Override
    public Autho updateautho(Autho autho) {
        return repository.updateautho(autho);
    }

    @Override
    public void deleteautho(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Autho> findallsortedbyyear() {
        return repository.findallsortedbydate();
    }
}
