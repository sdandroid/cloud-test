package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients(clients = TestClient.class)
public class HelloApplication {

	@Autowired
	private TestClient testClient;


	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}



	@RestController
	class TestController {
		@GetMapping("/index")
		public String test() {
			System.out.println("########");

			return testClient.test();
		}
	}

}
