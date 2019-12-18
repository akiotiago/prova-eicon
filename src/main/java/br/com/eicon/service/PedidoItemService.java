package br.com.eicon.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eicon.dto.PedidoItemProjection;
import br.com.eicon.model.PedidoItem;
import br.com.eicon.model.PedidoItemPK;

public interface PedidoItemService {
	
	public Page<PedidoItemProjection> findAll(Pageable pageable);
	
	public Optional<PedidoItemProjection> findById(PedidoItemPK pedidoItemPK);
	
	public PedidoItem save(PedidoItem pedidoItem);
	
	public void delete(PedidoItem pedidoItem);
	
	public void deleteById(PedidoItemPK pedidoItemPK);		
	
}
