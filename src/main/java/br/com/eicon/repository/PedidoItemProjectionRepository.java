package br.com.eicon.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.eicon.dto.PedidoItemProjection;
import br.com.eicon.model.PedidoItemPK;

public interface PedidoItemProjectionRepository extends PagingAndSortingRepository<PedidoItemProjection, PedidoItemPK>{

	public Page<PedidoItemProjection> findAll(Pageable pageable);
	
	public Optional<PedidoItemProjection> findById(PedidoItemPK pedidoItemPK);
	
}
