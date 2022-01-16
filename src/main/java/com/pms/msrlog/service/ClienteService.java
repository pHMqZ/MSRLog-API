package com.pms.msrlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pms.msrlog.exception.ClienteException;
import com.pms.msrlog.model.Cliente;
import com.pms.msrlog.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long clienteId) {
		return clienteRepository.findById(clienteId)
				.orElseThrow(() -> new ClienteException("Cliente não encontrado"));
	}

	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream().anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailEmUso) {
			throw new ClienteException("Já existe um cliente cadastrado com esse e-mail");
		}
		return clienteRepository.save(cliente);
	}

	@Transactional
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

	@Transactional
	public List<Cliente> findAll() {
		List<Cliente> lista = clienteRepository.findAll();
		return lista;
	}

	@Transactional
	public ResponseEntity<Cliente> findById(Long id) {
		ResponseEntity<Cliente> clienteFindId = clienteRepository.findById(id).map(cliente -> ResponseEntity.ok(cliente))
				.orElse(ResponseEntity.notFound().build());
		return clienteFindId;
	}
	
	
}
