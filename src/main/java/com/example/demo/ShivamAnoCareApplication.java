package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ShivamAnoCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShivamAnoCareApplication.class, args);
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		Triangle triangle = (Triangle)context.getBean("triangle");
//		triangle.draw();
	}

}
