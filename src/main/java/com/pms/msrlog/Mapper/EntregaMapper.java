package com.pms.msrlog.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pms.msrlog.DTO.EntregaDTO;
import com.pms.msrlog.DTO.input.EntregaInput;
import com.pms.msrlog.model.Entrega;

@Component
public class EntregaMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EntregaDTO toModel(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	}
	
	public List<EntregaDTO> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelMapper.map(entregaInput, Entrega.class);
	}
	
	
}
