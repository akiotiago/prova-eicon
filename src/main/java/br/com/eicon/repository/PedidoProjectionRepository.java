package br.com.eicon.repository;

import org.springframework.stereotype.Repository;

import br.com.eicon.model.Pedido;

@Repository
public interface PedidoProjectionRepository extends org.springframework.data.repository.Repository<Pedido, Long> {

}
