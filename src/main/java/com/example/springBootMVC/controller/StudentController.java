package com.example.springBootMVC.controller;

import com.example.springBootMVC.entity.Student;
import com.example.springBootMVC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@Controller Vs @RestController Annotations
https://www.baeldung.com/spring-controller-vs-restcontroller
https://stackoverflow.com/questions/25242321/difference-between-spring-controller-and-restcontroller-annotation
*/

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public String homePage() {
        return "Hello, welcome to student portal :)";
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable String id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/studentsByName/{name}")
    public List<Student> getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/studentsByNameAndMail")
    public List<Student> getStudentsByNameAndMail(@RequestParam String name, @RequestParam String email) {
        return studentService.getStudentsByNameAndMail(name, email);
    }

    @GetMapping("/studentsByNameOrMail")
    public List<Student> getStudentsByNameOrMail(@RequestParam String name, @RequestParam String email) {
        return studentService.getStudentsByNameOrMail(name, email);
    }

    @GetMapping("/getAllWithPagination")
    public List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
        return studentService.getAllWithPagination(pageNo, pageSize);
    }

    @GetMapping("/getAllSortedBy/{field}")
    public List<Student> getAllWithSorting(@PathVariable String field) {
        return studentService.getAllWithSorting(field);
    }

    //Get Document by Sub-Document fields
    @GetMapping("/getByDepartmentName")
    public List<Student> getByDepartmentName(@RequestParam String departmentName) {
        return studentService.getByDepartmentName(departmentName);
    }

    //Get Document by Array Value :
    @GetMapping("/getBySubjectName")
    public List<Student> getBySubjectName(@RequestParam String subjectName) {
        return studentService.getBySubjectName(subjectName);
    }

    //Like Query : { "mail" : /yahoo/ }
    @GetMapping("/getAllEmailLike")
    public List<Student> getAllEmailLike(@RequestParam String emailLike) {
        return studentService.getAllEmailLike(emailLike);
    }

    //Starts with Query: { "name" : /^s/ }
    @GetMapping("/getAllNameStartWith")
    public List<Student> getAllNameStartWith(@RequestParam String name) {
        return studentService.getAllNameStartWith(name);
    }

    //Get using Native MongoDB Query
    @GetMapping("/getStudentByNameNativeQuery/{name}")
    public List<Student> getStudentByNameNativeQuery(@PathVariable String name) {
        return studentService.getStudentByNameNativeQuery(name);
    }
}
