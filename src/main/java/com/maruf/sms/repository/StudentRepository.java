package com.maruf.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.maruf.sms.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
}
