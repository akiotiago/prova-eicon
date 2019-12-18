package br.com.eicon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.eicon.model.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Long>{

	
}
