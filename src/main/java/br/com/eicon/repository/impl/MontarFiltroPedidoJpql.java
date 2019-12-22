package br.com.eicon.repository.impl;

import java.util.ArrayList;
import java.util.Optional;

import br.com.eicon.model.Cliente;
import br.com.eicon.model.Pedido;

public class MontarFiltroPedidoJpql {

	public static void main(String[] args) {
		
		Cliente c = new Cliente();
		c.getIdOptional().isPresent();
		
		Pedido pedido = new Pedido();
		pedido.setCliente(new Cliente());
		pedido.setListaPedidoItens(new ArrayList<>());
		
		pedido.getIdOptional().isPresent();
		
		System.out.println(Optional.ofNullable(pedido.getId()).isPresent());
		System.out.println(Optional.ofNullable(pedido.getDataDoPedido()).isPresent());
		System.out.println(Optional.ofNullable(pedido.getCliente()).isPresent());
		System.out.println(Optional.ofNullable(pedido.getListaPedidoItens()).isPresent());
		if(pedido.getId() != null){
			
		}
	}

}
