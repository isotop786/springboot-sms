package com.maruf.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.maruf.sms.entity.Course;
import com.maruf.sms.repository.CourseRepository;
import com.maruf.sms.service.CourseService;

import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	CourseRepository courseRepo;

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseRepo.findAll(Sort.by(Sort.Direction.DESC,"courseId"));
	}

	@Override
	public Course getCourseById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course saveCourseData(Course course) {
		// TODO Auto-generated method stub
		return courseRepo.save(course);
	}

	@Override
	public Course updateCourseData(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCourse(Long id) {
		// TODO Auto-generated method stub
		
	}

}
