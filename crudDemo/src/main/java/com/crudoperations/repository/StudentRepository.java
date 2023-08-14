package com.crudoperations.repository;

import org.springframework.data.repository.CrudRepository;

import com.crudoperations.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	
	Student findByName(String name);
	
	Student findByCourse(String course);
	
	Student findByFee(int fee);

}
