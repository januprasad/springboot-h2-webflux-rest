package com.restapi.webflux.controller;

import com.restapi.webflux.model.Employee;
import com.restapi.webflux.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping
    public Mono<Employee> createEmployee(@RequestBody Employee employee){
       return employeeRepo.save(employee);
    }

    @GetMapping
    public Flux<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    @GetMapping("/{code}")
    public Mono<Employee> search(@PathVariable String code){
        return employeeRepo.findByCode(code.toUpperCase());
    }

}
