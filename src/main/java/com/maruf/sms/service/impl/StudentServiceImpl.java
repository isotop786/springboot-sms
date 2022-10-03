package com.maruf.sms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.maruf.sms.entity.Student;
import com.maruf.sms.repository.StudentRepository;
import com.maruf.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepo;
//	@Autowired
//	StudentRepository studentRepo;
	
	public StudentServiceImpl(StudentRepository studentRepo)
	{
		super();
		this.studentRepo = studentRepo;
	}
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll(Sort.by(Sort.Direction.DESC,"studentId"));
	}

	@Override
	public Student saveStudentData(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Long studentId) {
		// TODO Auto-generated method stub
		return studentRepo.findById(studentId).get();
	}
	
	@Override
	public Student updateStudent(Student student)
	{
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
	}
	
	
}
