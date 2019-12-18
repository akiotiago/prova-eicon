package br.com.eicon.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.eicon.dto.PedidoItemProjection;
import br.com.eicon.model.PedidoItem;
import br.com.eicon.model.PedidoItemPK;
import br.com.eicon.repository.PedidoItemProjectionRepository;
import br.com.eicon.repository.PedidoItemRepository;
import br.com.eicon.service.PedidoItemService;

@Service
public class PedidoItemServiceImpl implements PedidoItemService {

	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	@Autowired
	private PedidoItemProjectionRepository pedidoItemProjectionRepository;
	
	public Page<PedidoItemProjection> findAll(Pageable pageable) {
		return pedidoItemProjectionRepository.findAll(pageable);
	}
	
	public Optional<PedidoItemProjection> findById(PedidoItemPK pedidoItemPK) {
		return pedidoItemProjectionRepository.findById(pedidoItemPK);
	}
	
	public PedidoItem save(PedidoItem pedidoItem) {
		return pedidoItemRepository.save(pedidoItem);
	}
	
	public void delete(PedidoItem pedidoItem) {
		pedidoItemRepository.delete(pedidoItem);
	}
	
	public void deleteById(PedidoItemPK pedidoItemPK) {
		pedidoItemRepository.deleteById(pedidoItemPK);
	}
}
