package com.example.springBootMVC.service.impl;

import com.example.springBootMVC.entity.Student;
import com.example.springBootMVC.repositoryMongoDB.StudentRepository;
import com.example.springBootMVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/*
@Service: We mark beans with @Service to indicate that they're holding the business logic.
Besides being used in the service layer, there isn't any other special use for this annotation.

https://www.baeldung.com/spring-component-repository-service
https://www.journaldev.com/21435/spring-service-annotation
*/
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    /*********************************** MongoDB CRUD fn()s Start *********************************************/

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    /************************************ MongoDB CRUD fn()s End **********************************************/

    @Override
    public String deleteStudentById(String id) {
        studentRepository.deleteById(id);
        return "Student Has Been Deleted";
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> getStudentsByNameAndMail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    @Override
    public List<Student> getStudentsByNameOrMail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    @Override
    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        // Internal Calculation : (pageNo -1) * PageSize -> Skip
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> getAllWithSorting(String field) {
        // Sorting is possible on many files like:
        // Sort sort = Sort.by(Sort.Direction.ASC, "name", "email", "...");
        Sort sort = Sort.by(Sort.Direction.ASC, field);
        return studentRepository.findAll(sort);
    }

    @Override
    public List<Student> getByDepartmentName(String departmentName) {
        return studentRepository.findByDepartmentDepartmentName(departmentName);
    }

    @Override
    public List<Student> getBySubjectName(String subjectName) {
        return studentRepository.findBySubjectsSubjectName(subjectName);
    }

    @Override
    public List<Student> getAllEmailLike(String emailLike) {
        return studentRepository.findByEmailLike(emailLike);
    }

    @Override
    public List<Student> getAllNameStartWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    @Override
    public List<Student> getStudentByNameNativeQuery(String name) {
        return studentRepository.getStudentByNameNativeQuery(name);
    }
}
