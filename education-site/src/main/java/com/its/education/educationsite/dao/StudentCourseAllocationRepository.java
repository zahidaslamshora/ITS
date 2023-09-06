package com.its.education.educationsite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.its.education.educationsite.entity.Allocate;
@Repository
public interface StudentCourseAllocationRepository extends JpaRepository<Allocate, Integer>{

}
