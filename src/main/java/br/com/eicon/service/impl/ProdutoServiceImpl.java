package br.com.eicon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eicon.dto.ProdutoProjection;
import br.com.eicon.model.Produto;
import br.com.eicon.repository.ProdutoProjectionRepository;
import br.com.eicon.repository.ProdutoRepository;
import br.com.eicon.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ProdutoProjectionRepository produtoProjectionRepository;
	
	public Page<ProdutoProjection> findAll(Pageable pageable) {
		return produtoProjectionRepository.findAll(pageable);
	}
	
	public Optional<ProdutoProjection> findById(Long id) {
		return produtoProjectionRepository.findById(id);
	}
	
	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void delete(Produto produto) {
		produtoRepository.delete(produto);
	}
	
	public void deleteById(Long idProduto) {
		produtoRepository.deleteById(idProduto);
	}
}
