package com.example.springBootMVC.repositoryMongoDB;

import com.example.springBootMVC.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
MongoRepository<T,ID>
T: Name of DB collection class (Student Class in this case)
ID: Datatype of @Id in DB collection class (String id from Student Class in this case)
*/

/*
Spring Boot @Repository: https://zetcode.com/springboot/repository/
*/
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    //Method Proxy
    List<Student> findByName(String name);

    List<Student> findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);

    List<Student> findByDepartmentDepartmentName(String departmentName);

    List<Student> findBySubjectsSubjectName(String subjectName);

    List<Student> findByEmailLike(String emailLike);

    List<Student> findByNameStartsWith(String name);

    //Writing a Native MongoDB Query
    @Query("{ \"name\" : \"?0\" }")
    List<Student> getStudentByNameNativeQuery(String name);
}

/*
Spring Boot MongoDB CRUD Example: https://javatechonline.com/spring-boot-mongodb-crud-example/
Spring Boot MongoDB @Query Examples: https://javatechonline.com/spring-boot-mongodb-query-examples/
Spring Boot MongoDB Using MongoTemplate Examples: https://javatechonline.com/spring-boot-mongodb-using-mongotemplate-examples/
*/