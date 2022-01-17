package com.pms.msrlog.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pms.msrlog.DTO.OcorrenciaDTO;
import com.pms.msrlog.model.Ocorrencia;

@Component
public class OcorrenciaMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	public OcorrenciaDTO toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDTO.class);
	}

	public List<OcorrenciaDTO> toCollectionModel(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}

}
