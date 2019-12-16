package br.com.eicon.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eicon.model.Pedido;

public interface PedidoService {

	public Page<Pedido> findAll(Pageable pageable);
	
	public Optional<Pedido> findById(Long id);
	
	public Pedido save(Pedido pedido);
	
	public void delete(Pedido pedido);
	
	public void deleteById(Long idPedido);	
	
}
