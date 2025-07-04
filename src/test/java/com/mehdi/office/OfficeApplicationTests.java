package com.mehdi.office;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OfficeApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;
	@Test
	void shouldReturnEmployeeWhenDataIsSaved(){
		ResponseEntity<String> response=restTemplate.getForEntity("/office/1",String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		DocumentContext documentContext= JsonPath.parse(response.getBody());

		Number id=documentContext.read("$.id");
		assertThat(id).isEqualTo(1);
		String nom=documentContext.read("$.name");
		assertThat(nom).isEqualTo("Michael Scott");
		String department=documentContext.read("$.department");
		assertThat(Dept.valueOf(department)).isEqualTo(Dept.MANAGEMENT);
	}
	@Test
	void shouldNOtReturnAnEmployeeWithAnUnknownId(){
		ResponseEntity<String> response=restTemplate.getForEntity("/office/20",String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isBlank();
	}


}
