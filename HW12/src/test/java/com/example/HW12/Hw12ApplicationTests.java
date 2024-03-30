package com.example.HW12;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Hw12ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	private int port; // Переменная для хранения порта

	@Test
	public void testHealthEndpoint() {
		// Переменная port будет инициализирована автоматически
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/actuator/health", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).contains("UP");
	}

	@Test
	public void testMainPageAccess() {
		// Переменная port будет инициализирована автоматически
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).contains("Welcome to the Main Page");
	}
}