package com.maruf.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maruf.sms.entity.Course;
import com.maruf.sms.entity.Student;
import com.maruf.sms.service.CourseService;
import com.maruf.sms.service.StudentService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("")
	public String displayAllCourse(Model model)
	{
		List<Course> courses = courseService.getAllCourse();
		model.addAttribute("courses",courses);
		return "course/all_courses";
	}
	
	@GetMapping("new")
	public String displayAddCourseForm(Model model)
	{
		List<Student> students = studentService.getAllStudents();
		model.addAttribute("course",new Course());
		model.addAttribute("allStudents",students);
		
		return "course/create_course_form";
	}
	
	@PostMapping("save")
	public String saveCourse(Course course, Model model)
	{
		System.out.println(course.getTitle());
		courseService.saveCourseData(course);
		
		
		return "redirect:";
	}
	
	
}
