package br.com.eicon.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.eicon.model.Pedido;

public interface CustomPedidoRepository<T> {
	
	<T> List<T> filtroDePedidos(Pedido pedido, Pageable pageable, Class<T> projectionClass);
	
}
