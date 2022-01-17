package com.pms.msrlog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pms.msrlog.DTO.EntregaDTO;
import com.pms.msrlog.DTO.input.EntregaInput;
import com.pms.msrlog.Mapper.EntregaMapper;
import com.pms.msrlog.model.Entrega;
import com.pms.msrlog.repository.EntregaRepository;
import com.pms.msrlog.service.EntregaService;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

	@Autowired
	private EntregaRepository entregaRepository;

	@Autowired
	private EntregaService entregaService;
	
	@Autowired
	private EntregaMapper entregaMapper;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaMapper.toEntity(entregaInput);
		Entrega entregaSolicitada = entregaService.solicitar(novaEntrega);
		
		return entregaMapper.toModel(entregaSolicitada);
	}

	@GetMapping
	public List<EntregaDTO> listar() {
		return entregaMapper.toCollectionModel(entregaRepository.findAll());
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaDTO> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(entrega -> ResponseEntity.ok(entregaMapper.toModel(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{entregaId}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long entregaId) {
		entregaService.finalizar(entregaId);
	}
}
