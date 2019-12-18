package br.com.eicon.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eicon.dto.ClienteProjection;
import br.com.eicon.model.Cliente;
import br.com.eicon.repository.ClienteProjectionRepository;
import br.com.eicon.repository.ClienteRepository;
import br.com.eicon.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteProjectionRepository clienteProjectionRepository;

	@Override
	public <T> List<T> findClienteByNomeCLienteStartingWithIgnoreCase(String nomeCliente, Class<T> projectionClass) {
		return this.clienteRepository.findClienteByNomeCLienteStartingWithIgnoreCase(nomeCliente, projectionClass);
	}
	
	@Override
	public Page<ClienteProjection> findAll(Pageable pageable) {
		return clienteProjectionRepository.findAll(pageable);
	}
	
	public Optional<ClienteProjection> findById(Long id) {
		return clienteProjectionRepository.findById(id);
	}
	
	public Cliente save(Cliente Cliente) {
		return clienteRepository.save(Cliente);
	}
	
	public void delete(Cliente Cliente) {
		clienteRepository.delete(Cliente);
	}
	
	public void deleteById(Long idCliente) {
		clienteRepository.deleteById(idCliente);
	}

}
