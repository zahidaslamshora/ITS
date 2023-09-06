package com.its.education.educationsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.its.education.educationsite.dao.CoursesRepository;
import com.its.education.educationsite.dao.StudentRepository;
import com.its.education.educationsite.entity.Courses;
import com.its.education.educationsite.entity.Student;

@Service
public class StudentServices {
	
	@Autowired
	private StudentRepository studentsRepo;
	//This service method saves one course to DB
	public Student createStudent(Student student) {	
		return studentsRepo.save(student);	
	}
	
//	public List<Courses> createCourses(List<Courses> courses) {	
//		return coursesRepo.saveAll(courses);	
//	}
	// This method gets All the course from DB 
	public List<Student> findAllstudents() {	
		return studentsRepo.findAll();	
	}
	
	//This method updates courses as per course name
	public Student updateStudent(Student student) {	
		      Student students=null;
				Optional<Student>	studentToupdate=studentsRepo.findById(student.getId());
				if(studentToupdate.isPresent()) {
					students=studentToupdate.get();
					student.setName(students.getName());
					student.setEmailAddress(students.getArabicName());
					student.setAddress(students.getAddress());
					student.setEmailAddress(students.getEmailAddress());
					student.setTelNo(students.getTelNo());
					studentsRepo.save(student);
				}
				else {
				return new Student();
				}
				return student;
	}
	@Transactional
	public String deleteStudentbyName(String name) {	
		List<Student> stdLst= studentsRepo.findByName(name);
		if(stdLst.isEmpty()) {
			return "Student Not Present";
		}
		else {
			studentsRepo.deleteUserByName(name);
		 return "User Deleted";
		}
	}

	public Student getStudentById(int studentId) {
		Student student=null;
		Optional<Student> s=studentsRepo.findById(studentId);
		if(s.isPresent()) {
			student=s.get();
			return student;
		}
			else {
				return new Student();
			}
	}
		
	
	
	

	
	
}
