package br.com.eicon.repository.impl;

import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import br.com.eicon.model.Pedido;
import br.com.eicon.model.PedidoItem;

public class FiltroPedidoJpql {

	public String montarFiltroDePedidoJpql(Pedido pedido) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select ped ")
			.append(" from Pedido ped ")
			.append(" left join fetch ped.cliente cli ")
			.append(" left join fetch ped.listaPedidoItens lpi ")
			.append(" left join fetch lpi.produto prod ")
			.append(" where 	1 = 1 ");
		jpql.append(montarClausulasDePedidoJpql(pedido));
		return jpql.toString();
	}
	
	public String montarClausulasDePedidoJpql(Pedido pedido) {
		if(pedido != null) {
			StringBuilder clausulas = new StringBuilder();
			if(pedido.getIdOptional().isPresent()) clausulas.append(" and ped.id = :pedidoId ");
			if(pedido.getIdClienteOptional().isPresent()) clausulas.append(" and ped.idCliente = :pedidoIdCliente ");
			if(pedido.getValorTotalDoPedidoOptional().isPresent()) clausulas.append(" and ped.valorTotalDoPedido = :pedidoValorTotalDoPedido ");
			if(pedido.getDataDoPedidoOptional().isPresent()) clausulas.append(" and ped.dataDoPedido = :pedidoDataDoPedido ");

			if(pedido.isCliente()) {
				if(pedido.getCliente().getIdOptional().isPresent()) clausulas.append(" and cli.id = :clienteId ");
				if(pedido.getCliente().getNomeClienteOptional().isPresent()) clausulas.append(" and cli.nomeCliente like :clienteNome%");
				if(pedido.getCliente().getEmailOptional().isPresent()) clausulas.append(" and cli.email like :clienteEmail% ");
				if(pedido.getCliente().getCpfOptional().isPresent()) clausulas.append(" and cli.cpf like :clienteCpf% ");
			}
			if(pedido.isListaPedidoItens()) {
				for (PedidoItem pedidoItem : pedido.getListaPedidoItens()) {
					if(pedidoItem.isPedidoItemPKIdPedido()) clausulas.append(" and lpi.pedidoItemPK.idPedido = :lpiIdPedido ");
					if(pedidoItem.isPedidoItemPKIdProduto()) clausulas.append(" and lpi.pedidoItemPK.idProduto = :lpiIdProduto ");
					if(pedidoItem.getQuantidadeOptional().isPresent()) clausulas.append(" and lpi.quantidade = :lpiQuantidade ");
					if(pedidoItem.getValorTotalItensDoPedidoOptional().isPresent()) clausulas.append(" and lpi.valorTotalItensDoPedido = :lpiValorTotalItensDoPedido ");
					if(pedidoItem.isProduto()) {
						if(pedidoItem.getProduto().getIdOptional().isPresent()) clausulas.append(" and prod.id = :produtoId ");
						if(pedidoItem.getProduto().getDescricaoOptional().isPresent()) clausulas.append(" and prod.descricao like :produtoDescricao ");
						if(pedidoItem.getProduto().getValorProdutoOptional().isPresent()) clausulas.append(" and prod.valorProduto = :produtoValor ");
					}
				}
			}
			return clausulas.toString();
		} return null;
	}
	
	public TypedQuery<?> carregarParametrosNasClausulasDoPedidoJpql(Pedido pedido, TypedQuery<?> typedQuery) {
		if(pedido.getIdOptional().isPresent()) typedQuery.setParameter("pedidoId", pedido.getId());
		if(pedido.getIdClienteOptional().isPresent()) typedQuery.setParameter("pedidoIdCliente", pedido.getIdCliente());
		if(pedido.getValorTotalDoPedidoOptional().isPresent()) typedQuery.setParameter("pedidoValorTotalDoPedido", pedido.getValorTotalDoPedido());
		if(pedido.getDataDoPedidoOptional().isPresent()) typedQuery.setParameter("pedidoDataDoPedido", pedido.getDataDoPedido(), TemporalType.DATE);

		if(pedido.isCliente()) {
			if(pedido.getCliente().getIdOptional().isPresent()) typedQuery.setParameter("clienteId", pedido.getCliente().getId());
			if(pedido.getCliente().getNomeClienteOptional().isPresent()) typedQuery.setParameter("clienteNome", pedido.getCliente().getNomeCliente()+"%");
			if(pedido.getCliente().getEmailOptional().isPresent()) typedQuery.setParameter("clienteEmail", pedido.getCliente().getEmail()+"%"); 
			if(pedido.getCliente().getCpfOptional().isPresent()) typedQuery.setParameter("clienteCpf", pedido.getCliente().getCpf()+"%"); 
		}
		if(pedido.isListaPedidoItens()) {
			for (PedidoItem pedidoItem : pedido.getListaPedidoItens()) {
				if(pedidoItem.isPedidoItemPKIdPedido()) typedQuery.setParameter("lpiIdPedido", pedidoItem.getPedidoItemPK().getIdPedido()); 
				if(pedidoItem.isPedidoItemPKIdProduto()) typedQuery.setParameter("lpiIdProduto", pedidoItem.getPedidoItemPK().getIdProduto()); 
				if(pedidoItem.getQuantidadeOptional().isPresent()) typedQuery.setParameter("lpiQuantidade", pedidoItem.getQuantidade()); 
				if(pedidoItem.getValorTotalItensDoPedidoOptional().isPresent()) typedQuery.setParameter("lpiValorTotalItensDoPedido", pedidoItem.getValorTotalItensDoPedido());
				if(pedidoItem.isProduto()) {
					if(pedidoItem.getProduto().getIdOptional().isPresent()) typedQuery.setParameter("produtoId", pedidoItem.getProduto().getId()); 
					if(pedidoItem.getProduto().getDescricaoOptional().isPresent()) typedQuery.setParameter("produtoDescricao", pedidoItem.getProduto().getDescricao()+"%");
					if(pedidoItem.getProduto().getValorProdutoOptional().isPresent()) typedQuery.setParameter("produtoValor", pedidoItem.getProduto().getValorProduto()); 
				}
			}
		}
		return typedQuery;
	}


}
