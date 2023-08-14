package com.crudoperations;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crudoperations.entity.Student;
import com.crudoperations.repository.StudentRepository;

@SpringBootTest
class CrudDemoApplicationTests {


	
	@Autowired
	private StudentRepository studentRepository;
	
	
	//Save records 
	@Test
	void saveOneStudent() {
		Student student=new Student();
		
		student.setName("Boni");
		student.setCourse("History");
		student.setFee(7777);
		
		studentRepository.save(student);
		
	}
	
	
	//Delete a records
	@Test
	void deleteByStudent() {
		studentRepository.deleteById(6L);
		System.out.println("Deleted Successfully");
	}
	
	
	//Get Record by id
	@Test
	void getOneStudentById() {
		Optional<Student> findById = studentRepository.findById(1L); // optional object
		Student student = findById.get(); // get()- converting optional object to student object
		
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
		
		System.out.println("Record get successfully");
		
		
	}
	
	
	//Get record by Name
	@Test
	void getOneStudentByName() {
		Student student = studentRepository.findByName("Mithu");
		
		System.out.println(student.getId());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
		
		System.out.println("Record get successfully");
	}
	
	
	
	//Get record by Course
	@Test
	void getStudentByCourse() {
		Student student = studentRepository.findByCourse("Arts");
		
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getFee());
		
		System.out.println("Record get successfully");
	}
	
	
	//Get Record by fee
	@Test
	void getStudentByFee() {
		Student student = studentRepository.findByFee(7777);
		
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		
		System.out.println("Record get successfully");
	}
	
	
	//Get All Records
	@Test
	void getAllStudents() {
		Iterable<Student> findAll = studentRepository.findAll();
		System.out.println(findAll);
		
		for(Student student : findAll) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
		}
	}
	
	
	
	//Update record 
	@Test
	void updateStudent() {
		Optional<Student> findById = studentRepository.findById(1L);
		Student student = findById.get();
		
		student.setFee(9999);
		
		studentRepository.save(student);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
