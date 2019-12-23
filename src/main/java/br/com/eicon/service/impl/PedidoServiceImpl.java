package br.com.eicon.service.impl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.eicon.model.Pedido;
import br.com.eicon.repository.PedidoRepository;
import br.com.eicon.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public <T> List<T> filtroDePedidos(Pedido pedido, Pageable pageable, Class<T> projectionClass) {
		return pedidoRepository.filtroDePedidos(pedido, pageable, projectionClass);
	}
	
	public Page<Pedido> findAll(Pageable pageable) {
		return pedidoRepository.findAll(pageable);
	}

	public List<Pedido> findAll(Specification<Pedido> specificationPedido) {
		return pedidoRepository.findAll(specificationPedido);
	}

	public Page<Pedido> findAll(Specification<Pedido> specificationPedido, Pageable pageable) {
		return pedidoRepository.findAll(specificationPedido, pageable);
	}

	public Optional<Pedido> findById(Long id) {
		return pedidoRepository.findById(id);
	}
	
	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public void delete(Pedido pedido) {
		pedidoRepository.delete(pedido);
	}
	
	public void deleteById(Long idPedido) {
		pedidoRepository.deleteById(idPedido);
	}

}
