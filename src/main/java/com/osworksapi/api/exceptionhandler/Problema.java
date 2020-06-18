package com.osworksapi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class Problema {
	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	@Data
	@AllArgsConstructor
	public static class Campo{
		private String nome;
		private String mensagem;
	}
	

}
