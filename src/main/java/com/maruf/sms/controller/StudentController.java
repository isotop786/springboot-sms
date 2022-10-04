package com.maruf.sms.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maruf.sms.entity.Course;
import com.maruf.sms.entity.Student;
import com.maruf.sms.service.CourseService;
import com.maruf.sms.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("")
	public String listStudent(Model model)
	{
		List<Student> students = this.studentService.getAllStudents();
		model.addAttribute("students", students);
		return "students/all-students";
	}
	
	@GetMapping("new")
	public String displayAddForm(Model model)
	{
		
		List<Course> courses = courseService.getAllCourse();
		
		model.addAttribute("student",new Student());
		model.addAttribute("courses",courses);
		
		return "students/new";
	}
	
	@PostMapping(value="save")
	public String saveStudentData(@Valid Student student, BindingResult result, Model model)
	{
		if(result.hasErrors())
		{
			System.out.println(result);
			return "students/new";
		}
		
		studentService.saveStudentData(student);
		
		return "redirect:";
	}
	
	@GetMapping("edit/{id}")
	public String displayEditForm(@PathVariable Long id, Model model)
	{
		List<Course> courses = courseService.getAllCourse();
		Student student =  studentService.getStudentById(id);

		model.addAttribute("student",student);
		model.addAttribute("courses",courses);
		
		return"students/edit-student";
	}
	
	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable Long id,@Valid Student student, BindingResult result, Model model)
	{
		//System.out.println("id is:"+id);
		
		Student existingStudent = studentService.getStudentById(id);
		
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setCourse(student.getCourse());
		
		studentService.saveStudentData(existingStudent);
		
		return "redirect:/students/";
	}
	
	@PostMapping("delete/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		System.out.println("Deleting student:"+id);
		studentService.deleteStudent(id);
		
		return "redirect:/students/";
	}
	
	
	 
}
