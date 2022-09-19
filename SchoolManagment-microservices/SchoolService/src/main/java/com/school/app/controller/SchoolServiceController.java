package com.school.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/schoolDetail")
public class SchoolServiceController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value= "/{schoolName}")
	public String getStudent(@PathVariable String schoolName) {
		System.out.println("Gettig School Detail for"+schoolName);
		String requestUrl="http://localhost:9091/getStudentDetailForSchool/"+schoolName;
		HttpHeaders httpHeader= new HttpHeaders();
		HttpEntity<String> httpEntity=new HttpEntity<String>(httpHeader);
		
		ResponseEntity<String> response=restTemplate.exchange(requestUrl, HttpMethod.GET,httpEntity,String.class);
		String student=response.getBody();
		
		System.out.println("Response recieved as "+student);

		return "School Name: "+ schoolName+"\n Student Details "+student ;
		
	}
}
