package br.com.eicon.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.eicon.model.Pedido;

@Repository
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long>, CustomPedidoRepository<Pedido> {

}
