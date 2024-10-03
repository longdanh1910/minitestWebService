package com.codegym.minitestwebservice.service.impl;

import com.codegym.minitestwebservice.model.Student;
import com.codegym.minitestwebservice.model.StudentClass;
import com.codegym.minitestwebservice.repository.IStudentRepository;
import com.codegym.minitestwebservice.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Iterable<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        iStudentRepository.deleteById(id);
    }
    @Override
    public Optional<Student> findById(Long id){
        return iStudentRepository.findById(id);
    }
    @Override
    public Iterable<Student> findAllByClass(StudentClass studentClass){
        return iStudentRepository.findAllByStudentClass(studentClass);
    }

    @Override
    public Page<Student> findAll(Pageable pageable){
        return iStudentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findAllByFirstNameContaining(Pageable pageable, String name){
        return iStudentRepository.findAllByFirstNameContaining(pageable, name);
    }




}