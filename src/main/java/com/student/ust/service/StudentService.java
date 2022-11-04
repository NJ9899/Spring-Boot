package com.student.ust.service;

import com.student.ust.entity.Student;
import com.student.ust.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student getStudentById(Integer id) {

        return studentRepository.findById(id).orElse(null);
    }


    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudentAll() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    public  Student updateStudent(Student student) throws NoSuchElementException{

        Student updateStudent = studentRepository.findById(student.getStudentId()).orElseThrow(()-> new NoSuchElementException());;
        updateStudent.setAge(student.getAge());
        updateStudent.setRollNumber(student.getRollNumber());
        updateStudent.setName(student.getName());
        studentRepository.save(updateStudent);
        return updateStudent;
    }
}
