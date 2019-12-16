package br.com.eicon.model;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
public class PedidoItemPK implements Serializable {

	private static final long serialVersionUID = -6128438875051748347L;

	private Long idPedido;
	
	private Long idProduto;
	
	
}
