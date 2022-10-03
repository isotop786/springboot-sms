package com.maruf.sms.service;

import java.util.List;

import com.maruf.sms.entity.Course;

public interface CourseService {
	
	public List<Course> getAllCourse();
	
	public Course getCourseById(Long id);
	
	public Course saveCourseData(Course course);
	
	public Course updateCourseData(Course course);
	
	public void deleteCourse(Long id);

}
