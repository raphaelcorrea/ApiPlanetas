package br.com.api.apirest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApirestApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("Teste", "Teste", "Teste igual a Teste");
	}

}
