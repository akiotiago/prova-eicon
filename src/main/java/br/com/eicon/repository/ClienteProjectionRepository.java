package br.com.eicon.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.eicon.dto.ClienteProjection;
import br.com.eicon.model.Cliente;

@Repository
public interface ClienteProjectionRepository extends org.springframework.data.repository.Repository<Cliente, Long> {

	@Query("select c from Cliente c")
	public Page<ClienteProjection> findAll(Pageable pageable);
	
	@Query("select c from Cliente c where c.id = ?1")
	public Optional<ClienteProjection> findById(Long id);

}