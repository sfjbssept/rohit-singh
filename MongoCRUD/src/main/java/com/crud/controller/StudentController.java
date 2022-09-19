package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Student;
import com.crud.repo.IStudentRepository;

@RestController
public class StudentController {

	@Autowired
	private IStudentRepository studentRepository;
	

	@PostMapping("/addstudent")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
	 Student save =this.studentRepository.save(student);
	 return ResponseEntity.ok(save);
	}
	
	@GetMapping("/getstudents")
	public ResponseEntity<?> getStundents(){
		return ResponseEntity.ok(this.studentRepository.findAll());
	}
	@GetMapping("/getstudent/{id}")
	public ResponseEntity<?> getStundent(@PathVariable Integer id){
		return ResponseEntity.ok(this.studentRepository.findById(id));
	}
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Integer id,@RequestBody Student student){
		Student existingStudent=this.studentRepository.findById(id).get();
		existingStudent.setName(student.getName());
		existingStudent.setCity(student.getCity());
		existingStudent.setCollege(student.getCollege());
		
		return ResponseEntity.ok(this.studentRepository.save(existingStudent));
	}
}
