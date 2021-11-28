package com.example.springBootMVC.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/*
@Document: Applied at the class level to indicate this class is a candidate for mapping to the database.
You can specify the name of the collection where the data will be stored.
*/
@Data
@Document(collection = "student")
public class Student {

    /*
    @Id: Applied at the field level to mark the field used for identity purpose.
    */
    @Id
    private String id;
    private String name;
    @Field(name = "mail")
    private String email;
    private Department department;
    private List<Subject> subjects;

    /*
    @Transient: By default, all fields are mapped to the document. This annotation excludes the field where it is applied from being stored in the database.
    Transient properties cannot be used within a persistence constructor as the converter cannot materialize a value for the constructor argument.
    */
    @Transient
    private double percentage;

    public double getPercentage() {
        if (subjects != null && subjects.size() > 0) {
            double total = 0.0;
            for (Subject subject: subjects) {
                total += Double.parseDouble(subject.getMarksObtained());
            }
            return total/subjects.size();
        }
        return 0.0;
    }
}

/*
https://github.com/spring-projects/spring-data-mongodb/blob/main/src/main/asciidoc/reference/mapping.adoc
*/
