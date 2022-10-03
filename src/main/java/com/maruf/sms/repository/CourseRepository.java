package com.maruf.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maruf.sms.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
}
