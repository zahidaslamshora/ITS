package com.its.education.educationsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.its.education.educationsite.dao.CoursesRepository;
import com.its.education.educationsite.entity.Courses;
import com.its.education.educationsite.entity.Student;

@Service
public class CoursesServices {
	
	@Autowired
	private CoursesRepository coursesRepo;
	//This service method saves one course to DB
	public Courses createCourse(Courses courses) {	
		return coursesRepo.save(courses);	
	}
	
//	public List<Courses> createCourses(List<Courses> courses) {	
//		return coursesRepo.saveAll(courses);	
//	}
	// This method gets All the course from DB 
	public List<Courses> findAllCourses() {	
		return coursesRepo.findAll();	
	}
	
	//This method updates courses as per course name
	public Courses updateCourses(Courses courses) {	
		      Courses course=null;
				Optional<Courses>	courseToupdate=coursesRepo.findById(courses.getCourseId());
				if(courseToupdate.isPresent()) {
					course=	courseToupdate.get();
					course.setCourseName(courses.getCourseName());
					coursesRepo.save(course);
				}
				else {
				return new Courses();
				}
				return course;
	}
	@Transactional
	public String deleteCoursesbyName(String courseName) {	
		        try {
		            List<Courses> courseToDelete = coursesRepo.findByCourseName(courseName);
		            if (courseToDelete.isEmpty()) {
		                return "Course Not Found";
		            } else {
		                coursesRepo.deleteUserByName(courseName);
		                return "Course Deleted";
		            }
		        } catch (Exception e) {
		            // Log the exception or perform any necessary error handling
		            return "An error occurred while deleting the course: " + e.getMessage();
		        }
		    }
		public Courses getCourseById(int courseId) {
			Courses course=null;
			Optional<Courses> s=coursesRepo.findById(courseId);
			if(s.isPresent()) {
				course=s.get();
				return course;
			}
				else {
					return new Courses();
				}
	}
	
	

	
	
}
