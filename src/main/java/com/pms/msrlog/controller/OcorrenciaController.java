package com.pms.msrlog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pms.msrlog.DTO.OcorrenciaDTO;
import com.pms.msrlog.DTO.input.OcorrenciaInput;
import com.pms.msrlog.Mapper.OcorrenciaMapper;
import com.pms.msrlog.model.Entrega;
import com.pms.msrlog.model.Ocorrencia;
import com.pms.msrlog.service.EntregaService;
import com.pms.msrlog.service.OcorrenciaService;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	@Autowired
	private EntregaService entregaService;
	
	@Autowired
	private OcorrenciaService ocorrenciaService;
	
	@Autowired
	private OcorrenciaMapper ocorrenciaMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO registrar(@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		
		Ocorrencia ocorrenciaRegistrada = ocorrenciaService
				.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaMapper.toModel(ocorrenciaRegistrada);
		
	}
	
	@GetMapping
	public List<OcorrenciaDTO> listar(@PathVariable Long entregaId) {
		Entrega entrega = entregaService.buscar(entregaId);
		
		return ocorrenciaMapper.toCollectionModel(entrega.getOcorrencias());
	}
	
}
