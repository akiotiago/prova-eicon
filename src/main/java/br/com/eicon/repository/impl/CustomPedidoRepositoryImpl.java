package br.com.eicon.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.eicon.model.Pedido;
import br.com.eicon.repository.CustomPedidoRepository;

@Repository
public class CustomPedidoRepositoryImpl<T> implements CustomPedidoRepository<T> {

	@Autowired
	private EntityManager entityManager;

	@SuppressWarnings("hiding")
	@Override
	public <T> List<T> filtroDePedidos(Pedido pedido, Pageable pageable, Class<T> projectionClass) {
		FiltroPedidoJpql filtroPedidoJpql = new FiltroPedidoJpql();
		String query = filtroPedidoJpql.montarFiltroDePedidoJpql(pedido);
//		String query = montarFiltroDePedidoJpql(pedido).append(montarClausulasDePedidoJpql(pedido)).toString();
		TypedQuery<T> typedQuery = entityManager.createQuery(query, projectionClass);
		filtroPedidoJpql.carregarParametrosNasClausulasDoPedidoJpql(pedido, typedQuery);
		
		typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		typedQuery.setMaxResults(pageable.getPageSize());
		
		return typedQuery.getResultList();
	}
	
}
