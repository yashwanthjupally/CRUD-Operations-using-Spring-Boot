package com.example.demoForJPA.repository;

import com.example.demoForJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
