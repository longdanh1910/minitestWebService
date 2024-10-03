package com.codegym.minitestwebservice.repository;

import com.codegym.minitestwebservice.model.Student;
import com.codegym.minitestwebservice.model.StudentClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
    Iterable<Student> findAllByStudentClass(StudentClass studentClass);
    Page<Student> findAll(Pageable pageable);
    Page<Student> findAllByFirstNameContaining(Pageable pageable, String name);

}
