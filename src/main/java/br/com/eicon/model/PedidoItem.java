package br.com.eicon.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_PEDIDO_ITEM")
@IdClass(PedidoItemPK.class)
public class PedidoItem implements Serializable {
	
	private static final long serialVersionUID = -5949682808794565409L;

	@Id
	@NotNull
	private Long idPedido;
	
	@Id
	@NotNull
	private Long idProduto;
	
	@NotNull
	private Double quantidade;
	
	@DecimalMin(value = "0.01")
	private BigDecimal valorTotalItensDoPedido;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPedido", referencedColumnName = "idPedido", insertable = false, updatable = false)
	private Pedido pedido;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduto", referencedColumnName = "idProduto", insertable = false, updatable = false)
	private Produto produto;
	
}
