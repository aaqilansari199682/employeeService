package com.micro.services.feignclient;

import com.micro.services.model.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "address-service",url = "http://localhost:8091")
public interface AddressClient {
    @GetMapping("/getaddress{id}")
    public ResponseEntity<AddressResponse>
    getAddressByEmployeeId(@PathVariable("id") int id);
}
