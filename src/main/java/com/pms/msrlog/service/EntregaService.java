package com.pms.msrlog.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.msrlog.model.Entrega;
import com.pms.msrlog.model.StatusEntrega;
import com.pms.msrlog.repository.EntregaRepository;

@Service
public class EntregaService {
	
	@Autowired
	private EntregaRepository entregaRepository;

	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		entrega.setStatus(StatusEntrega.PEDENTE);
		entrega.setDataPedido(LocalDateTime.now());
				
		return entregaRepository.save(entrega);
	}
	
}
