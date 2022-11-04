package com.student.ust.controller;

import com.student.ust.entity.Student;
import com.student.ust.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> get(@PathVariable Integer id){
        try{
            Student student = studentService.getStudentById(id);
            return  new ResponseEntity<Student>(student, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }


    }

    @PostMapping("/student")
    public void add(@RequestBody Student student){

        studentService.saveStudent(student);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> get(){
        try{
            List<Student> studentAllList = studentService.getStudentAll();
            return  new ResponseEntity<List<Student>>(studentAllList, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<List<Student>>(HttpStatus.NOT_FOUND);
        }


    }

    @DeleteMapping("/student/{id}")
    public void delete(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/student")
    public ResponseEntity<Student> update(@RequestBody Student student){
        try{
            Student student1 = studentService.updateStudent(student);
            return  new ResponseEntity<Student>(student1, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return  new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
    }
}
