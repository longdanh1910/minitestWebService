package com.codegym.minitestwebservice.service.impl;

import com.codegym.minitestwebservice.model.StudentClass;
import com.codegym.minitestwebservice.repository.IStudentClassRepository;
import com.codegym.minitestwebservice.service.IStudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentClassService implements IStudentClassService {


    @Autowired
    private IStudentClassRepository iStudentClassRepository;

    @Override
    public Iterable<StudentClass> findAll(){
        return iStudentClassRepository.findAll();
    }

    @Override
    public void save(StudentClass studentClass){
        iStudentClassRepository.save(studentClass);
    }

    @Override
    public void remove(Long id) {
       iStudentClassRepository.deleteById(id);
    }


    @Override
    public Optional<StudentClass> findById(Long id){
        return iStudentClassRepository.findById(id);
    }


    @Override
    public void delete(Long id) {

    }
}

