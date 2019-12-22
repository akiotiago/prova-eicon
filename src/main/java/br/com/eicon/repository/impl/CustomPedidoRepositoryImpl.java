package br.com.eicon.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.eicon.model.Pedido;
import br.com.eicon.repository.CustomPedidoRepository;

public class CustomPedidoRepositoryImpl implements CustomPedidoRepository {

	@Autowired
	private EntityManager entityManager;
	 
	public String montarFiltroDePedidoJpql() {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select ped ") 
			.append(" from Pedido ped ")
			.append(" join fetch ped.cliente cli ") 
			.append(" join fetch ped.listaPedidoItens lpi ") 
			.append(" join fetch lpi.produto prod ")
			.append(" where 	1 = 1 ");
		return jpql.toString();
	}
	
	public void montarClausulasDePedidoJpql(Pedido pedido) {
		if(pedido != null) {
			
		}
	}
	
	@Override
	public <T> Page<T> filtroDePedidos(Pedido pedido, Pageable pageable, Class<T> projectionClass) {
		TypedQuery<T> tq = entityManager.createQuery(montarFiltroDePedidoJpql(), projectionClass);
		
		tq.getResultList();
		
		return null;
	}

}
