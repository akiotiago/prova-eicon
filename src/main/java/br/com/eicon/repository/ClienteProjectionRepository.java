package br.com.eicon.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.eicon.dto.ClienteProjection;

public interface ClienteProjectionRepository extends PagingAndSortingRepository<ClienteProjection, Long>{

	public Page<ClienteProjection> findAll(Pageable pageable);
	
	public Optional<ClienteProjection> findById(Long id);

}