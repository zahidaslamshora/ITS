package com.its.education.educationsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.its.education.educationsite.entity.Courses;
import com.its.education.educationsite.service.CoursesServices;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="course")
public class Coursescontroller {
	
	@Autowired
	private CoursesServices coursesService;
	
	@PostMapping("/add-Course")
	 @Operation(summary = "This Api Creates Courses")
	public Courses addCourses(@RequestBody Courses courses) {
		return coursesService.createCourse(courses);
	}

	@GetMapping("/get-Courses")
	@Operation(summary = "This Api gives the list of created courses")
	public List<Courses> getCourses() {
		return coursesService.findAllCourses();
	}
	@PutMapping("/update-Course")
	@Operation(summary = "This Api updates the Courses, you have to provide Json object containing courseId and courseName")
	public Courses updateCourse(@RequestBody Courses courses) {
		return coursesService.updateCourses(courses);
	}
	
	@DeleteMapping("/delete-Course/{courseName}")
	@Operation(summary = "This Api Deletes Courses, you have to give course name as input")
	public String deleteCourse(@PathVariable("courseName") String courseName) {
		return coursesService.deleteCoursesbyName(courseName);
	}
	

}
