package com.its.education.educationsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.its.education.educationsite.entity.Courses;

@RestController
public class ConsumeCourseWebService {
	
	private final String coursesServiceUrl ="http://localhost:8080/course/get-Courses";
	@Autowired
	 RestTemplate restTemplate;
	
	 
	  public List<Courses> getAllCourses() {
	        ResponseEntity<List<Courses>> response = restTemplate.exchange(
	            coursesServiceUrl,
	            HttpMethod.GET,
	            null,
	            new ParameterizedTypeReference<List<Courses>>() {}
	        );

	        if (response.getStatusCode() == HttpStatus.OK) {
	            return response.getBody();
	        } else {
	            throw new RuntimeException("Failed to fetch courses from the Courses Web service");
	        }
	    }
	

}
