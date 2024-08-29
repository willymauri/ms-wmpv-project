package com.wmpv.project;

import com.wmpv.project.controller.MainController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class WmpvProjectApplicationTests {

	@Autowired
	private MainController mainController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		Assertions.assertThat(mainController).isNotNull();
	}

}
