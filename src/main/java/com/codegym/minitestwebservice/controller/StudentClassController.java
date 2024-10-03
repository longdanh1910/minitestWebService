package com.codegym.minitestwebservice.controller;

import com.codegym.minitestwebservice.model.Student;
import com.codegym.minitestwebservice.model.StudentClass;
import com.codegym.minitestwebservice.service.IStudentClassService;
import com.codegym.minitestwebservice.service.IStudentService;
import com.codegym.minitestwebservice.service.impl.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/studentclass")
public class StudentClassController {
    @Autowired
    private StudentClassService studentClassService;
    @Autowired
    private IStudentService studentService;
    @GetMapping
    public ResponseEntity<List<StudentClass>> getAllStudentClasses(){
        List<StudentClass> studentClasses = (List<StudentClass>) studentClassService.findAll();
        return new  ResponseEntity<>(studentClasses,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentClass> getStudentClassById(@PathVariable Long id){
        Optional<StudentClass> studentClassOptional = studentClassService.findById(id);
        if(!studentClassOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(studentClassOptional.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentClass> createStudentClass(@RequestBody StudentClass studentClass){
        studentClassService.save(studentClass);
        return new ResponseEntity<>(studentClass, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentClass> updateStudentClass(@PathVariable Long id, @RequestBody StudentClass studentClass){
        Optional<StudentClass> studentClassOptional = studentClassService.findById(id);
        if(!studentClassOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentClass.setId(studentClassOptional.get().getId());
        studentClassService.save(studentClass);
        return new ResponseEntity<>(studentClass, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentClass(@PathVariable Long id){
        Optional<StudentClass> studentClassOptional = studentClassService.findById(id);
        if(!studentClassOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentClassService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
