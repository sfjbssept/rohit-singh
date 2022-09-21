package com.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value= "getSchoolDetails/{schoolName}")
	public String getStudent(@PathVariable String schoolName) {
		System.out.println("Gettig School Detail for"+schoolName);
	
		HttpHeaders httpHeader= new HttpHeaders();
		String response=restTemplate.exchange("http://student-service/getStudentDetailForSchool/{schoolName}",
				HttpMethod.GET,null,new ParameterizedTypeReference<String>() {
				},schoolName).getBody();

		System.out.println("Response Recieved as:"+response);
		return "school Name -"+schoolName+"\n Student Details :"+response;
}
}
