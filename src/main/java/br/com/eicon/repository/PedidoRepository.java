package br.com.eicon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.eicon.model.Pedido;

public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long>{

}
