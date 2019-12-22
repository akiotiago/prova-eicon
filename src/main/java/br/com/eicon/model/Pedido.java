package br.com.eicon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Getter @Setter @EqualsAndHashCode 
@Builder(toBuilder = true)
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 7670922852808938393L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Identificador do pedido")
	private Long id;
	
	@NotNull
	@Column(name = "id_cliente")
	private Long idCliente;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_do_pedido")
	private Date dataDoPedido;
	
	@DecimalMin(value = "0.01")
	@Digits(integer=12, fraction=2)
	@Column(name = "valor_total_do_pedido")
	private BigDecimal valorTotalDoPedido;
	
	@JsonBackReference(value = "pedido-cliente")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", referencedColumnName = "id", insertable = false, updatable = false)
	private Cliente cliente;
	
	@JsonManagedReference(value = "pedido-itens")
	@OneToMany(mappedBy = "pedido")
	private List<PedidoItem> listaPedidoItens;
	
	public boolean isCliente() {
		return Objects.nonNull(this.cliente);
	}
	
	public boolean isListaPedidoItens() {
		return (this.listaPedidoItens != null && !this.listaPedidoItens.isEmpty());
	}

	public Optional<Long> getIdOptional() {
		return Optional.ofNullable(id);
	}

	public Optional<Long> getIdClienteOptional() {
		return Optional.ofNullable(idCliente);
	}

	public Optional<Date> getDataDoPedidoOptional() {
		return Optional.ofNullable(dataDoPedido);
	}

	public Optional<BigDecimal> getValorTotalDoPedidoOptional() {
		return Optional.ofNullable(valorTotalDoPedido);
	}

	
	
	
}
