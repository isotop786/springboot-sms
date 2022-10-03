package com.maruf.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.maruf.sms.entity.Student;
import com.maruf.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public void run(String...args)
	{
//		Student stu1 = new Student("Jhon","deo","j@d.com");
//		studentRepo.save(stu1);
//		
//		Student stu2 = new Student("Smith","Kaleey","s@j.com");
//		studentRepo.save(stu2);
//		
//		Student stu3 = new Student("Jenny","Deo","jenny@deo.com");
//		studentRepo.save(stu3);
		
	}

}
