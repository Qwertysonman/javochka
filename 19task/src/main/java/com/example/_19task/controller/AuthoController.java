package com.example._19task.controller;

import com.example._19task.model.Autho;
import com.example._19task.service.AuthoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/19task")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthoController {
    private final AuthoService service;
    @GetMapping
    public List<Autho> findAllAutho(){
        return service.findAllAutho();
    }
    @PostMapping("save_autho")
    public String saveAutho(@RequestBody Autho autho){
        service.saveAutho(autho);
        return "all good";}
    @GetMapping("filterBrand/{brandName}")
    public List<Autho> findbybrand(@PathVariable String brandName){
        return service.findbybrand(brandName);
    }
    @GetMapping("filterName/{name_user}")
    public List<Autho> findbynameuser(@PathVariable String name_user){
        return service.findbynameuser(name_user);}
    @GetMapping("filterYear/{year_production}")
    public List<Autho> findbyyearproduction(@PathVariable String year_production){
        return service.findbyyearproduction(Integer.valueOf(year_production));}
    @GetMapping("filterDate/{date_accounting}")
    public List<Autho> findbydateaccounting(@PathVariable LocalDate date_accounting){
        return service.findbydateaccounting(date_accounting);}
    @PutMapping("update")
    public Autho updateautho(@RequestBody Autho autho){
        return service.updateautho(autho);
    }
    @GetMapping("sort")
    public List<Autho> findallsortedbyYear(){ return service.findallsortedbyyear();}
    @PostMapping("/sorting")
    public List<Autho> sortingAuthos(@RequestBody List<Autho> autho) {return service.sortauthosbydate(autho);}
    @DeleteMapping("/delete/{id}")
    public String deleteautho(@PathVariable Long id){
        service.deleteautho(id);
        return "all good";
    }
}
