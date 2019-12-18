package br.com.eicon.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eicon.dto.ProdutoProjection;
import br.com.eicon.model.Produto;

public interface ProdutoService {

	public Page<ProdutoProjection> findAll(Pageable pageable);
	
	public Optional<ProdutoProjection> findById(Long id);
	
	public Produto save(Produto produto);
	
	public void delete(Produto produto);
	
	public void deleteById(Long idProduto);		
	
}
