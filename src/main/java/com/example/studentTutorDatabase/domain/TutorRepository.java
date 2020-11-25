package com.example.studentTutorDatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TutorRepository extends CrudRepository<Tutor, Long> {

   //Fetch by lastName
	List<Tutor> findBylastName(@Param("lastName") String lastName);
	

	 //Fetch by firstName
	List<Tutor> findByfirstName(@Param("firstName") String firstName);
	
	
    
}