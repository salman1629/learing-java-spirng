package com.example.kafka.hellokafka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloKafka {

	@GetMapping("/")
	public String GetHelloKafka() {
		return "Hello Kafka";
	}
}
