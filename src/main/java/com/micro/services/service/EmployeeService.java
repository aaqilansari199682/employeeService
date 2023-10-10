package com.micro.services.service;

import com.micro.services.entity.Employee;
import com.micro.services.model.AddressResponse;
import com.micro.services.model.EmployeeRequest;
import com.micro.services.model.EmployeeResponse;
import com.micro.services.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public EmployeeRequest register(Employee employee) {

        employeeRepo.save(employee);
        System.out.println(employee.getRole());
        return EmployeeRequest.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .age(employee.getAge())
                .role(employee.getRole())
                .bloodGroup(employee.getBloodGroup())
                .build();
    }

    public List<EmployeeResponse> getAllEmployee(List<Employee> list1) {

        List<EmployeeResponse> list = new ArrayList<>();
        for (Employee e : list1) {
            list.add(EmployeeResponse.builder()
                    .firstName(e.getFirstName())
                    .lastName(e.getLastName())
                    .age(e.getAge())
                    .bloodGroup(e.getBloodGroup())
                    .role(e.getRole())
                    .build());
        }
        return list;
    }

    public EmployeeResponse getEmployeeById(Employee e, AddressResponse list1) {

        return EmployeeResponse.builder()
                .firstName(e.getFirstName())
                .lastName(e.getLastName())
                .age(e.getAge())
                .bloodGroup(e.getBloodGroup())
                .role(e.getRole())
                .addressResponse(AddressResponse.builder()
                        .id(list1.getId())
                        .street(list1.getStreet())
                        .landMark(list1.getLandMark())
                        .zip(list1.getZip())
                        .city(list1.getCity())
                        .country(list1.getCountry())
                        .build())
                .build();
    }
}
