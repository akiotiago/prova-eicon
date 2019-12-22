package br.com.eicon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eicon.dto.ClienteProjection;
import br.com.eicon.model.Cliente;

public interface ClienteService {

	public <T> List<T> findClienteByNomeClienteStartingWithIgnoreCase(String nomeCliente, Class<T> projectionClass);
	
	public Page<ClienteProjection> findAll(Pageable pageable);
	
	public Optional<ClienteProjection> findById(Long id);
	
	public Cliente save(Cliente Cliente);
	
	public void delete(Cliente Cliente);
	
	public void deleteById(Long idCliente);		
}
