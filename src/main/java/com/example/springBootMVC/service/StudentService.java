package com.example.springBootMVC.service;

import com.example.springBootMVC.entity.Student;

import java.util.List;

public interface StudentService {
    public Student createStudent(Student student);

    public Student getStudentById(String id);

    public List<Student> getAllStudent();

    public Student updateStudent(Student student);

    public String deleteStudentById(String id);

    public List<Student> getStudentByName(String name);

    public List<Student> getStudentsByNameAndMail(String name, String email);

    public List<Student> getStudentsByNameOrMail(String name, String email);

    public List<Student> getAllWithPagination(int pageNo, int pageSize);

    public List<Student> getAllWithSorting(String field);

    public List<Student> getByDepartmentName(String departmentName);

    public List<Student> getBySubjectName(String subjectName);

    public List<Student> getAllEmailLike(String emailLike);

    public List<Student> getAllNameStartWith(String name);

    public List<Student> getStudentByNameNativeQuery(String name);
}
