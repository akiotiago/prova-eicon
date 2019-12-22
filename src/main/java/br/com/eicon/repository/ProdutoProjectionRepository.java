package br.com.eicon.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.eicon.dto.ProdutoProjection;
import br.com.eicon.model.Produto;

@Repository
public interface ProdutoProjectionRepository extends org.springframework.data.repository.Repository<Produto, Long>{

	@Query("select p.id as id, p.descricao as descricao from Produto p")
	public Page<ProdutoProjection> findAll(Pageable pageable);
	
	@Query("select p from Produto p where p.id = ?1")
	public Optional<ProdutoProjection> findById(Long id);
	
}
