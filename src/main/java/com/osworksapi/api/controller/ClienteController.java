package com.osworksapi.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osworksapi.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Fellipe");
		cliente1.setEmail("fe@hotmail.com");
		cliente1.setTelefone("1111-2222");
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("lary");
		cliente2.setEmail("la@hotmail.com");
		cliente2.setTelefone("1111-2222");
		return Arrays.asList(cliente1, cliente2);
	}

}
