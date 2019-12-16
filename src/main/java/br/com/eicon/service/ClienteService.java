package br.com.eicon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eicon.model.Cliente;

public interface ClienteService {

	public <T> List<T> findClienteByNomeCLienteStartingWithIgnoreCase(String nomeCliente, Class<T> projectionClass);
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Optional<Cliente> findById(Long id);
	
	public Cliente save(Cliente Cliente);
	
	public void delete(Cliente Cliente);
	
	public void deleteById(Long idCliente);		
}
