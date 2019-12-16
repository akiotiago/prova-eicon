package br.com.eicon.dto;

import java.math.BigDecimal;

import org.springframework.data.rest.core.config.Projection;

import br.com.eicon.model.Produto;

@Projection(name = "produtoProjection", types = { Produto.class })
public interface ProdutoProjection {
	
	Long getIdProduto();
	
	String getDescricao();
	
	BigDecimal getValorProduto();

}
