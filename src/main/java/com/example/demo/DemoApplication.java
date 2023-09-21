package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public String PORT = System.getenv("PORT");

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
	/*para correr esta app
		en visual studio code abrir la terminal y poner:
		mvn.cmd spring-boot:run

	*/