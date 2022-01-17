package com.pms.msrlog.DTO;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OcorrenciaDTO {

	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
	
}
