package com.codegym.minitestwebservice.repository;

import com.codegym.minitestwebservice.model.StudentClass;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentClassRepository  extends JpaRepository<StudentClass,Long> {
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "call deleteClassStudentById(:id)")
    void deleteClassStudent (@Param("id") Long id);


}
