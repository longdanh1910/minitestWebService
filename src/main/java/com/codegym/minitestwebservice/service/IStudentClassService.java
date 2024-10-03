package com.codegym.minitestwebservice.service;

import com.codegym.minitestwebservice.model.StudentClass;
import org.springframework.data.repository.query.Param;

public interface IStudentClassService extends IGenerateService<StudentClass>{


    void delete(Long id);
}
