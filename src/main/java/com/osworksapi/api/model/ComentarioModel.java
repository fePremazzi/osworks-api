package com.osworksapi.api.model;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class ComentarioModel {
	
	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;
	

}
