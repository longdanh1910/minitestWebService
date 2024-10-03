package com.codegym.minitestwebservice.service;

import com.codegym.minitestwebservice.model.Student;
import com.codegym.minitestwebservice.model.StudentClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService extends IGenerateService<Student>{
    Iterable<Student> findAllByClass(StudentClass studentClass);
    Page<Student> findAll(Pageable pageable);
    Page<Student> findAllByFirstNameContaining(Pageable pageable, String name);
}
