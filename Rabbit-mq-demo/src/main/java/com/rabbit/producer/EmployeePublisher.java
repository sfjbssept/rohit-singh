package com.rabbit.producer;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.rabbit.config.MessagingConfig;
import com.rabbit.entity.Employee;
import com.rabbit.entity.EmployeeStatus;

@RestController
@RequestMapping("/Employee")
public class EmployeePublisher {
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@PostMapping("/{companyName}")
	public String saveEmployee(@RequestBody Employee employee, @PathVariable String companyName) {
		employee.setEmpId(UUID.randomUUID().toString());
		EmployeeStatus empStatus = new EmployeeStatus(employee , "Joined","has recently joined company");
		rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE_NAME,MessagingConfig.ROUTING_KEY,empStatus);
		return "success";
	}

}
