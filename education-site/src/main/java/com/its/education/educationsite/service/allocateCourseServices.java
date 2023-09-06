package com.its.education.educationsite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.its.education.educationsite.dao.CoursesRepository;
import com.its.education.educationsite.dao.StudentCourseAllocationRepository;
import com.its.education.educationsite.dao.StudentRepository;
import com.its.education.educationsite.entity.Allocate;
import com.its.education.educationsite.entity.Courses;
import com.its.education.educationsite.entity.Student;
import com.its.education.educationsite.exception.StudentsNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class allocateCourseServices {
	
	 @Autowired
	    private StudentCourseAllocationRepository allocationRepository;
	 @Autowired
		private StudentRepository studentsRepo;

	    public Allocate allocateStudentToCourse(Student student, Courses course) {
	        Allocate allocation = new Allocate();
	        allocation.setStudent(student);
	        allocation.setCourse(course);
	        return allocationRepository.save(allocation);
	    }
	    
	    public List<Student> getAllStudentsWithSelectedCourses() {
	    	 try {
	             List<Student> students = new ArrayList<>();
	             Student student;
	             List<Allocate> allocateList = allocationRepository.findAll();

	             for (Allocate allocate : allocateList) {
	                 student = allocate.getStudent();
	                 students.add(student);
	             }

	             if (students.isEmpty()) {
	                 throw new StudentsNotFoundException("No students with selected courses found.");
	             }

	             return students;
	         } catch (Exception e) {
	      
	             throw new StudentsNotFoundException("An error occurred while fetching students with selected courses.");
	         }
	     }
	  
}
