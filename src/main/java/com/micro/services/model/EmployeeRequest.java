package com.micro.services.model;

import com.micro.services.entity.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class EmployeeRequest {

        private String firstName;
        private String lastName;
        private int age;
        private String bloodGroup;
        @Enumerated(EnumType.STRING)
        private Role role;
}
