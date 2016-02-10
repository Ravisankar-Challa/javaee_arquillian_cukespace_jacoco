package com.example.util;

import com.example.model.Student;

public class StudentBuilder {
	private Student student = new Student();
	
	public static StudentBuilder newStudent() {
		return new StudentBuilder();
	}
	
	public StudentBuilder firstName(String firstName) {
		this.student.setFirstName(firstName);
		return this;
	}
	
	public StudentBuilder lastName(String lastName) {
		this.student.setLastName(lastName);
		return this;
	}
	
	public Student build() {
		return this.student;
	}
}
