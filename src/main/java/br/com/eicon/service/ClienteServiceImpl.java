package br.com.eicon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eicon.model.Cliente;
import br.com.eicon.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public <T> List<T> findClienteByNomeCLienteStartingWithIgnoreCase(String nomeCliente, Class<T> projectionClass) {
		return this.clienteRepository.findClienteByNomeCLienteStartingWithIgnoreCase(nomeCliente, projectionClass);
	}
	
	@Override
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}
	
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
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
