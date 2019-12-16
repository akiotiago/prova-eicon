package br.com.eicon.dto;

import java.math.BigDecimal;

import org.springframework.data.rest.core.config.Projection;

import br.com.eicon.model.PedidoItem;

@Projection(name = "pedidoItemProjection", types = { PedidoItem.class } )
public interface PedidoItemProjection {
	
	Double getQuantidade();
	
	BigDecimal getValorTotalItensDoPedido();

}
