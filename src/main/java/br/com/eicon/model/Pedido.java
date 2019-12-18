package br.com.eicon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_PEDIDO")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 7670922852808938393L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador do pedido")
	private Long idPedido;
	
	@NotNull
	@Column(name = "idCliente")
	private Long idCliente;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDoPedido;
	
	@DecimalMin(value = "0.01")
	@Digits(integer=3, fraction=2)
	private BigDecimal valorTotalDoPedido;
	
	@JsonBackReference(value = "pedido-cliente")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", insertable = false, updatable = false)
	private Cliente cliente;
	
	@JsonManagedReference(value = "pedido-itens")
	@OneToMany(mappedBy = "pedido")
	private List<PedidoItem> listaPedidoItens;
	
}
