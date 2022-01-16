package com.pms.msrlog.service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.msrlog.exception.ClienteException;
import com.pms.msrlog.model.Cliente;
import com.pms.msrlog.model.Entrega;
import com.pms.msrlog.model.StatusEntrega;
import com.pms.msrlog.repository.ClienteRepository;
import com.pms.msrlog.repository.EntregaRepository;

@Service
public class EntregaService {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EntregaRepository entregaRepository;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PEDENTE);
		entrega.setDataPedido(OffsetDateTime.now());
				
		return entregaRepository.save(entrega);
	}
	
}
