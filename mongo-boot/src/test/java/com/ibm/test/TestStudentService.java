package com.ibm.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.model.Student;
import com.ibm.service.StudentService;

@ExtendWith(SpringExtension.class)
public class TestStudentService {

	@Autowired
	private StudentService service;
	
	@Test
	public void testSave() {
		Student s1 = new Student();
		s1.setRollNo(1234);
		s1.setName("Polo");
		s1.setSchool("PHS");
		
		service.save(s1);
	}
	
	@Test
	public void testFetch() {
		Student s1 = service.fetch(1234);
		assertNotNull(s1);
	}
	
	@Test
	public void testInvalidFetch() {
		Student s1 = service.fetch(123);
		assertNull(s1);
	}
	
	@Test
	public void testFetchAll() {
		List<Student> students = service.fetchAll();
		assertNotNull(students);
	}
}
