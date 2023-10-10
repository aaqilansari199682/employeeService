package com.micro.services.repository;

import com.micro.services.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    Employee findById(int id);


    List<Employee> findAll();
}
