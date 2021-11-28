package com.example.springBootMVC.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class Department {
    // In mongo DB table the field name is: "department_name" (in code we are addressing as "departmentName")
    @Field(name = "department_name")
    private String departmentName;

    private String location;
}
