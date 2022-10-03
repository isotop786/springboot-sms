package com.maruf.sms.service;

import java.util.List;
import java.util.Optional;

import com.maruf.sms.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudentData(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	public void deleteStudent(Long id);

	
}
