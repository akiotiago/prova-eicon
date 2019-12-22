package br.com.eicon.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import br.com.eicon.model.Pedido;

@Projection(name = "pedidoProjection", types = { Pedido.class })
public interface PedidoProjection {

	Long getId();
	
	Date getDataDoPedido();
	
	BigDecimal getValorTotalDoPedido();
	
}
