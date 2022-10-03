package com.maruf.sms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long courseId;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@OneToMany(mappedBy = "course")
	private List<Student> students;
	
	
	public Course() {
		
	}
	
	public Course(String title, List<Student> students) {
		super();
		this.title = title;
		this.students = students;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public long getCourseId() {
		return courseId;
	}
	
	public String toString()
	{
		return String.format(title);
	}
	
	

}
