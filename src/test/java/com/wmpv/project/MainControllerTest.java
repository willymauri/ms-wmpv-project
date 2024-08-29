package com.wmpv.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wmpv.project.controller.MainController;
import com.wmpv.project.dto.ClienteDto;
import com.wmpv.project.entity.ClienteEntity;
import com.wmpv.project.service.ClienteEntityService;
import com.wmpv.project.service.CuentaEntityService;
import com.wmpv.project.service.MovimientoEntityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(MainController.class)
class MainControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClienteEntityService clienteEntityService;

	@MockBean
	private CuentaEntityService cuentaEntityService;

	@MockBean
	private MovimientoEntityService movimientoEntityService;

	@Test
	void postCreateClientsTest() throws Exception {

		var entity = new ClienteEntity();
		entity.setIdCliente(1);
		entity.setNombre("William");
		entity.setIdentificacion("1716277870");
		entity.setDireccion("Los Pinos");
		entity.setEstado("A");

		var dto = new ClienteDto();
		dto.setCode(1);
		dto.setName("William");
		dto.setId("1716277874");
		dto.setAddress("Los Pinos");
		dto.setStatus("A");

		Mockito.doNothing().when(clienteEntityService).saveOrUpdate(entity);

		this.mockMvc.perform(MockMvcRequestBuilders.post("/api/clientes")
						.content(new ObjectMapper().writeValueAsString(dto))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON)
				).andExpect(MockMvcResultMatchers.content().json("{\"code\":\"OK\",\"message\":\"Registro exitoso de cliente!\"}"));

		Mockito.verify(clienteEntityService, Mockito.times(1)).saveOrUpdate(entity);
	}

	@Test
	void deleteClientsTest() throws Exception {

		var entity = new ClienteEntity();
		entity.setIdCliente(1);
		entity.setNombre("William");
		entity.setIdentificacion("1716277870");
		entity.setDireccion("Los Pinos");
		entity.setEstado("I");

		var dto = new ClienteDto();
		dto.setCode(1);
		dto.setName("William");
		dto.setId("1716277874");
		dto.setAddress("Los Pinos");
		dto.setStatus("I");

		Mockito.doNothing().when(clienteEntityService).saveOrUpdate(entity);

		this.mockMvc.perform(MockMvcRequestBuilders.delete("/api/clientes")
				.content(new ObjectMapper().writeValueAsString(dto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		).andExpect(MockMvcResultMatchers.content().json("{\"code\":\"OK\",\"message\":\"Eliminado exitoso de cliente!\"}"));

		Mockito.verify(clienteEntityService, Mockito.times(1)).saveOrUpdate(entity);
	}
}
