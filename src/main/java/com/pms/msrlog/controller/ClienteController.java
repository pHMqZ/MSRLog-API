package com.pms.msrlog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.msrlog.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar(){
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Phillip");
		cliente1.setTelefone("11 99999-1234");
		cliente1.setEmail("phillip@phillip.com");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Alceu");
		cliente2.setTelefone("11 99999-1235");
		cliente2.setEmail("alceu@alceu.com");
		
		return Arrays.asList(cliente1, cliente2);
	}

}
