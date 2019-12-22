package br.com.eicon.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eicon.model.Pedido;

public interface CustomPedidoRepository {
	
	<T> Page<T> filtroDePedidos(Pedido pedido, Pageable pageable, Class<T> projectionClass);
	
}
