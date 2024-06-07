package com.example.demoForJPA.controller;

import com.example.demoForJPA.entity.Student;
import com.example.demoForJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class studentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/api/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/api/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student stud){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
           student.get().setStudentName(stud.getStudentName());
           student.get().setStudentAddress(stud.getStudentAddress());
           student.get().setStudentEmail(stud.getStudentEmail());
            return new ResponseEntity<>(studentRepository.save(student.get()), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(studentRepository.save(student.get()), HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/api/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id){
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
