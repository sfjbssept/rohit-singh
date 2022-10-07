package com.active.producer;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

	@Autowired
	public JmsTemplate jmsTemplate;
	
	@Autowired
	public Queue queue;
	
	@GetMapping("/{msg}")
	public String publish(@PathVariable final String msg) {
		
		jmsTemplate.convertAndSend(queue, msg);
		return "Published Successfully "+msg;
		
	}
}
