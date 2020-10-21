package com.restapi.webflux.repo;

import com.restapi.webflux.model.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface EmployeeRepo extends ReactiveCrudRepository<Employee, Integer> {
    @Query("SELECT e.* FROM employee e WHERE e.code = :code")
    Mono<Employee> findByCode(String code);
}
