package com.micro.services.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponse {

        private int id;
        private String street;
        private String landMark;
        private String city;
        private int zip;
        private String country;


}
