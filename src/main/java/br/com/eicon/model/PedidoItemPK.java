package br.com.eicon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode
@Builder(toBuilder = true)
public class PedidoItemPK implements Serializable {

	private static final long serialVersionUID = -6128438875051748347L;
	
	@NotNull
	@Column(name = "id_pedido")
	private Long idPedido;
	
	@NotNull
	@Column(name = "id_produto")
	private Long idProduto;

}
