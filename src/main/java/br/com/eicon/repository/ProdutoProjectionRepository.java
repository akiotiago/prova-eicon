package br.com.eicon.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.eicon.dto.ProdutoProjection;

public interface ProdutoProjectionRepository extends PagingAndSortingRepository<ProdutoProjection, Long>{

	public Page<ProdutoProjection> findAll(Pageable pageable);
	
	public Optional<ProdutoProjection> findById(Long id);
	
}
