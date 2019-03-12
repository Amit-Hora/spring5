package com.ash.boottest;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.web.server.LocalServerPort;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootIntegrationtestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRetrieveStudentCourse() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/students/Ranga"),
				HttpMethod.GET, entity, String.class);

		String expected = "[{\"id\":10002,\"name\":\"Ranga\",\"passportNumber\":\"E1234567\"}]";

		JSONAssert.assertNotEquals(expected, response.getBody(), false);
/*		expected = "[{\"id\":10002,\"name\":\"Ranga\",\"passportNumber\":\"E1234567\"}]";

		JSONAssert.assertNotEquals(expected, response.getBody(), false);
		expected = "[{\"id\":10003,\"name\":\"Ranga\",\"passportNumber\":\"E1234567\"}]";

		JSONAssert.assertEquals(expected, response.getBody(), false);*/
	}

	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}

