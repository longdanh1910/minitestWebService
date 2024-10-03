package com.codegym.minitestwebservice.controller;

import com.codegym.minitestwebservice.model.Student;
import com.codegym.minitestwebservice.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(students);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Optional<Student> studentOptional = studentService.findById(id);
        if(!studentOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentOptional.get());
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent){
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        updatedStudent.setId(studentOptional.get().getId());
        studentService.save(updatedStudent);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        Optional<Student> studentOptional = studentService.findById(id);
        if (!studentOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        studentService.remove(id);
        return ResponseEntity.ok().build();
    }
}
