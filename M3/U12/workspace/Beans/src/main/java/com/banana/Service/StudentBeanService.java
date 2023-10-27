package com.banana.Service;

import com.banana.model.Student;

public class StudentBeanService {
	public String getStudentsData() {

		Student s = new Student();// object is created

		s.setFirstName("Arjun");// setting value to the object

		return s.getFirstName();

	}
}
