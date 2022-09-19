package com.student.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.app.entity.Student;

@RestController
public class StudentServiceController {

	
	private static Map<String, List<Student>> schoolDB= new HashMap<String,List<Student>>();
	
	static {
		schoolDB =new HashMap<String,List<Student>>();
		
		List lst= new ArrayList<Student>();
		Student std= new Student ("Nishant","class12");
		lst.add(std);
		Student std1= new Student("Vinay", "Class11");
		lst.add(std1);
		
		schoolDB.put("school1", lst);
		
		List lst1= new ArrayList<Student>();
		Student std2= new Student ("Peter","class12");
		lst1.add(std2);
		Student std3= new Student("John", "Class11");
		lst1.add(std3);
		
		schoolDB.put("school2", lst1);
	}
	
	
	@RequestMapping(value = "/getStudentDetailForSchool/{schoolName}",method = RequestMethod.GET)
	public List<Student> getStudents(@PathVariable String schoolName){
	List<Student> studentList = schoolDB.get(schoolName);
	if(studentList==null) {
		studentList =new ArrayList<Student>();
		studentList.add(new Student("No Result Found!!", "NA"));
		
	}
	return studentList;
	}
}
