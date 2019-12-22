package br.com.eicon.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.eicon.dto.PedidoItemProjection;
import br.com.eicon.model.PedidoItem;
import br.com.eicon.model.PedidoItemPK;

@Repository
public interface PedidoItemProjectionRepository extends org.springframework.data.repository.Repository<PedidoItem, PedidoItemPK>{

	public Page<PedidoItemProjection> findAll(Pageable pageable);
	
	@Query("select pi from PedidoItem pi where pi.pedidoItemPK.idPedido = ?1 and pi.pedidoItemPK.idProduto = ?2")
	public Optional<PedidoItemProjection> findById(PedidoItemPK pedidoItemPK);
	
}
