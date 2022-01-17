package com.pms.msrlog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.msrlog.model.Entrega;
import com.pms.msrlog.model.Ocorrencia;

@Service
public class OcorrenciaService {
	
	@Autowired
	private EntregaService entregaService;

	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = entregaService.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	}
	
}
