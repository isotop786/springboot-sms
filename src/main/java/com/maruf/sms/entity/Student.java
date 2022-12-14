package com.maruf.sms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;
	
	@Column(name="first_name", nullable = false)
	@NotEmpty(message = "First name can not be emtpy")
	@Size(min=3,message = "First name must be at least 3 characters")
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	@NotEmpty(message = "Last name can not be empty")
	@Size(min=3, message = "Last name must be at least 3 characters")
	private String lastName;
	
	@Column(name="email", nullable = false, unique = true)
	@NotEmpty(message ="Email can not be empty")
	@Email(message = "Must be a valid email address")
	private String email;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			fetch = FetchType.LAZY
			)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Course course;
	 
	public String getFirstName() {
		return firstName;
	}
	
	
	
	public Student() {
	}



	public Student( String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getStudentId() {
		return studentId;
	}
	
	public String toString()
	{
		return String.format("%s %s", firstName, lastName);
	}
	

}
