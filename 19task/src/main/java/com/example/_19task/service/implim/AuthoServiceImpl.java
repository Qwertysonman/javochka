package com.example._19task.service.implim;

import com.example._19task.model.Autho;
import com.example._19task.repository.AuthoRepository;
import com.example._19task.service.AuthoService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Primary
public class AuthoServiceImpl implements AuthoService {

    private final AuthoRepository repository;

    @Override
    public List<Autho> findAllAutho() {
        return repository.findAll();
    }

    @Override
    public Autho saveAutho(Autho autho) {
        return repository.save(autho);
    }

    @Override
    public List<Autho> findbybrand(String brandName) {
        return repository.findByBrandName(brandName);
    }
    @Override
    public List<Autho> findbynameuser(String nameUser) {
        return repository.findByNameUser(nameUser);
    }
    @Override
    public List<Autho> findbyyearproduction(Integer yearProduction) {
        return repository.findByYearProduction(yearProduction);
    }

    @Override
    public List<Autho> findbydateaccounting(LocalDate dateAccounting) {
        return repository.findByDateAccounting(dateAccounting);
    }

    @Override
    public List<Autho> sortauthosbydate(List<Autho> autholist) {
            return autholist.stream()
                    .sorted((a1, a2) -> a1.getDateAccounting().compareTo(a2.getDateAccounting()))
                    .collect(Collectors.toList());
    }

    @Override
    public Autho updateautho(Autho autho) {
        return repository.save(autho);
    }

    @Override
    @Transactional
    public void deleteautho(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Autho> findallsortedbyyear() {
        return repository.findAllByOrderByDateAccounting();
    }


}
