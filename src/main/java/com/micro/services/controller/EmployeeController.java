package com.micro.services.controller;

import com.micro.services.entity.Employee;
import com.micro.services.feignclient.AddressClient;
import com.micro.services.model.AddressResponse;
import com.micro.services.model.EmployeeRequest;
import com.micro.services.model.EmployeeResponse;
import com.micro.services.repository.EmployeeRepo;
import com.micro.services.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.SeBootstrap;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class EmployeeController {
//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    WebClient webClient;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepo employeeRepo;
//    @Autowired
//    private AddressClient addressClient;

    @PostMapping("/register")
    public ResponseEntity<EmployeeRequest> registerEmp(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.register(employee));
    }

    @GetMapping("/getEmployees")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee() {
        List<Employee> list = employeeRepo.findAll();


        return ResponseEntity.ok(employeeService.getAllEmployee(list));
    }

    @GetMapping("/getEmployee/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id, HttpServletRequest httpServletRequest) {
        Employee emp = employeeRepo.findById(id);
//        List<ServiceInstance> li=discoveryClient.getInstances("ADDRESS-SERVICE");
//        ServiceInstance serviceInstance=li.get(0);
//        String uri=serviceInstance.getUri().toString();
//        System.out.println(uri);
//        AddressResponse list1=restTemplate.getForObject(uri+"/getaddress{id}",
//                AddressResponse.class,id);
        List<ServiceInstance> list = discoveryClient.getInstances("ADDRESS-SERVICE");
        ServiceInstance serviceInstance = list.get(0);
        String uri = serviceInstance.getUri().toString();
        AddressResponse list1 = webClient
                .get()
                .uri(uri + "/getaddress" + id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();


//
//        AddressResponse list1= addressClient.getAddressByEmployeeId(id).getBody();

        return ResponseEntity.ok(employeeService.getEmployeeById(emp, list1));
    }
}
//edited by nazir

//edited by aaqil
