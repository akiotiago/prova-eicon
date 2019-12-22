package br.com.eicon.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.eicon.model.Cliente;


public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{

	<T> List<T> findClienteByNomeClienteStartingWithIgnoreCase(String nomeCliente, Class<T> projectionClass);
	
}
