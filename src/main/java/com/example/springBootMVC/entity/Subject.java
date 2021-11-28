package com.example.springBootMVC.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

/*
@data annotation: https://projectlombok.org/features/Data
*/
@Data
public class Subject {
    // In mongo DB table the field name is: "subject_name" (in code we are addressing as "subjectName")
    @Field(name = "subject_name")
    private String subjectName;

    @Field(name = "marks_obtained")
    private String marksObtained;
}
