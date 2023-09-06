package com.its.education.educationsite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.its.education.educationsite.entity.Courses;
import com.its.education.educationsite.exception.ResourceNotFoundException;
import com.its.education.educationsite.service.ConsumeCourseWebService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="student")
public class ConsumeCourseWebServiceController
{
	@Autowired
	ConsumeCourseWebService consumeCourseWebService;
	 @GetMapping("/get-courses-student")
	 @Operation(summary = "This Api Consumes Courses Web service to get List of Courses using Rest Template"
	 		+ "and  view the List of Courses ")
	    public ResponseEntity<List<String>> getAllCourses() {
	        List<Courses> courses = consumeCourseWebService.getAllCourses();
	        if(courses.isEmpty()) {
	        	throw new ResourceNotFoundException("Resource not found");
	        }
	        	
	        ArrayList<String> coursesLst =new ArrayList<>();
	        for(Courses c:courses) {
	        coursesLst.add(c.getCourseName());
	        }
	        return new ResponseEntity<>(coursesLst, HttpStatus.OK);
	    }
	 
	

}
