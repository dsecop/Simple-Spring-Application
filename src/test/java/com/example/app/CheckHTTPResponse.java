package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CheckHTTPResponse {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldReturnHelloWorldMessage() {
        // Test the root endpoint
        String url = "http://localhost:" + port + "/";
        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode(), "HTTP Status should be 200 OK");
        assertEquals("Hello World from Spring Boot", response.getBody(), "Response body should match expected message");
    }

    @Test
    public void shouldReturnGoodbyeMessage() {
        // Test the goodbye endpoint
        String url = "http://localhost:" + port + "/goodbye";
        ResponseEntity<String> response = testRestTemplate.getForEntity(url, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode(), "HTTP Status should be 200 OK");
        assertEquals("Goodbye from Spring Boot", response.getBody(), "Response body should match expected message");
    }
}
