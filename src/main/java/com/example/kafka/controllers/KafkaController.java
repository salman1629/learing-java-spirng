package com.example.kafka.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.services.KafkaProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	private final KafkaProducerService producerService;
	
	public KafkaController(KafkaProducerService producerService) {
		this.producerService = producerService;
	}
	
	@PostMapping("/publish")
	public String sendMessage(@RequestParam String message) {
		producerService.sendMessage("test-topic", message);
		return "message sent successfully";
	}
}
