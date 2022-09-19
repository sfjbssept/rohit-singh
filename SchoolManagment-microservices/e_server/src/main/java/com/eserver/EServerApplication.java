package com.eserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@EnableEurekaServer
@SpringBootApplication
public class EServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EServerApplication.class, args);
	}

}
