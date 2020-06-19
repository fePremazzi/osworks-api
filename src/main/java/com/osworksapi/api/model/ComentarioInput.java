package com.osworksapi.api.model;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ComentarioInput {
	
	@NotBlank
	private String descricao;
 
}
