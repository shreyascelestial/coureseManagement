package com.example.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentmanagement.domain.Course;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long>{
	
}
