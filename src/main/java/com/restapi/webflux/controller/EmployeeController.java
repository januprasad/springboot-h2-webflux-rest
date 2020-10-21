package com.restapi.webflux.controller;

import com.restapi.webflux.model.Employee;
import com.restapi.webflux.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping
    public Mono<Employee> create(@RequestBody Employee employee){
       return employeeRepo.save(employee);
    }

    @GetMapping
    public Flux<Employee> get(){
        return employeeRepo.findAll();
    }

    @GetMapping("/{code}")
    public Mono<Employee> search(@PathVariable String code){
        return employeeRepo.findByCode(code.toUpperCase());
    }

    @PutMapping("/{id}")
    public Mono<Employee> update(@PathVariable Integer id, @RequestBody Employee employee){
        return employeeRepo.findById(id).map(
                employee1 ->  {
                    employee1.rebuild(employee);
                    return employee1;
                }
        ).flatMap(
                employee1 -> employeeRepo.save(employee1)
        );
    }

}
