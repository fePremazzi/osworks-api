package com.osworksapi.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osworksapi.domain.exception.NegocioException;
import com.osworksapi.domain.model.Cliente;
import com.osworksapi.domain.model.OrdemServico;
import com.osworksapi.domain.model.StatusOrdemServico;
import com.osworksapi.domain.repository.ClienteRepository;
import com.osworksapi.domain.repository.OrdemServicoRepository;

@Service
public class GestaoOrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public OrdemServico criar (OrdemServico ordemServico) {
		
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() ->  new NegocioException("Cliente não encontrado."));
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
	}
	
}























