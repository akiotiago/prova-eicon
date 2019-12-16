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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(value = "Identificador do Pedido")
	private Long idPedido;
	
	@NotNull
	@Column(name = "idCliente")
	private Long idCliente;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDoPedido;
	
	@DecimalMin(value = "0.01")
	private BigDecimal valorTotalDoPedido;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", insertable = false, updatable = false)
	private Cliente cliente;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pedido")
	private List<PedidoItem> listaPedidoItens;
	
}
