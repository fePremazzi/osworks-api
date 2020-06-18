package com.osworksapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osworksapi.domain.exception.NegocioException;
import com.osworksapi.domain.model.Cliente;
import com.osworksapi.domain.repository.ClienteRepository;

@Service
public class CadastroClienteService {
	//Aqui vai todos as regras de negocio pertinente a Cadastro de clientes 
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar (Cliente cliente) {		
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		
		if(clienteExistente!= null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}

}



















