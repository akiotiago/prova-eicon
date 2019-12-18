package br.com.eicon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.eicon.model.PedidoItem;
import br.com.eicon.model.PedidoItemPK;

public interface PedidoItemRepository extends PagingAndSortingRepository<PedidoItem, PedidoItemPK>{

}
