package com.its.education.educationsite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.its.education.educationsite.entity.Courses;
import com.its.education.educationsite.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Modifying
	@Query("delete from Student c where c.name=?1")
	void deleteUserByName(String name);

	public List<Student> findByName(String name);
	
	
	
	
}
