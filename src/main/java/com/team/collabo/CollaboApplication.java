package com.team.collabo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CollaboApplication {

	public static void main(String... args) {
		SpringApplication.run(CollaboApplication.class, args);
	}

	@GetMapping("api/hello")
	public String hello() {
		return "hello! Team Collabo!";
	}

	@GetMapping("api/hello/{name}")
	public String greeting(@PathVariable("name") final String name) {
		return String.format("hello! %s", name);
	}
}