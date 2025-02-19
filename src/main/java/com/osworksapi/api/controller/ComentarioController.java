package com.osworksapi.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.osworksapi.api.model.ComentarioInput;
import com.osworksapi.api.model.ComentarioModel;
import com.osworksapi.domain.exception.EntidadeNaoEncontradaException;
import com.osworksapi.domain.model.Comentario;
import com.osworksapi.domain.model.OrdemServico;
import com.osworksapi.domain.repository.OrdemServicoRepository;
import com.osworksapi.domain.service.GestaoOrdemServicoService;

@RestController 
@RequestMapping("/ordens-servico/{ordemServicoId}/comentarios")
public class ComentarioController {

	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServicoService;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<ComentarioModel> listar(@PathVariable Long ordemServicoId) {
		OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de servico nao encontrada."));
		
		return toCollection(ordemServico.getComentarios());
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ComentarioModel adicionar(@PathVariable Long ordemServicoId, 
			@Valid @RequestBody ComentarioInput comentarioInput) {
		Comentario comentario = gestaoOrdemServicoService.adicionarComentario(ordemServicoId, 
				comentarioInput.getDescricao());
		
		return toModel(comentario);
		
	}
	
	private ComentarioModel toModel(Comentario comentario) {
		return modelMapper.map(comentario, ComentarioModel.class);
	}
	
	private List<ComentarioModel> toCollection (List<Comentario> comentarios){
		return comentarios.stream().map(comentario -> toModel(comentario))
				.collect(Collectors.toList());
	}
	
}
























