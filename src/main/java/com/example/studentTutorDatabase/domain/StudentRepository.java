package com.example.studentTutorDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student, Long> {

   //Fetch by lastName
	List<Student> findBylastName(@Param("lastName") String lastName);
	

	 //Fetch by firstName
	List<Student> findByfirstName(@Param("firstName") String firstName);
	
	
    
}