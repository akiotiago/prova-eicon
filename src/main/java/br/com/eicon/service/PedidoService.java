package br.com.eicon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import br.com.eicon.model.Pedido;

public interface PedidoService {

	public <T> List<T> filtroDePedidos(Pedido pedido, Pageable pageable, Class<T> projectionClass);
	
	public List<Pedido> findAll(Specification<Pedido> specificationPedido);

	public Page<Pedido> findAll(Specification<Pedido> specificationPedido, Pageable pageable);

	public Page<Pedido> findAll(Pageable pageable);
	
	public Optional<Pedido> findById(Long id);
	
	public Pedido save(Pedido pedido);
	
	public void delete(Pedido pedido);
	
	public void deleteById(Long idPedido);	
	
}
