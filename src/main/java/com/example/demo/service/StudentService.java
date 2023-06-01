package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Student;

public interface StudentService {
	String addStudent(Student s);
	Student getStudent(String kodId);
	List<Student> getAllStudents();
	String updateStudent(Student s);
	String deleteStudent(String kodId);

}
