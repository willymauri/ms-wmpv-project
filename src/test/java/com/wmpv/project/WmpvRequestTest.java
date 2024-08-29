package com.wmpv.project;

import com.wmpv.project.controller.MainController;
import com.wmpv.project.enums.EnumResponse;
import com.wmpv.project.model.ResponseModel;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WmpvRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void testGetFunction() {

		Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/testdocker", JSONObject.class))
				.isNotNull();
	}

}
