package br.com.eicon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "tb_pedido_item")
public class PedidoItem implements Serializable {
	
	private static final long serialVersionUID = -5949682808794565409L;

	@EmbeddedId
	private PedidoItemPK pedidoItemPK;
	
	@NotNull
	private Double quantidade;
	
	@DecimalMin(value = "0.01")
	@Digits(integer=3, fraction=2)
	@Column(name = "valor_total_itens_do_pedido")
	private BigDecimal valorTotalItensDoPedido;
	
	@JsonBackReference(value = "pedido-itens")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pedido", referencedColumnName = "id", insertable = false, updatable = false)
	private Pedido pedido;
	
	@JsonManagedReference(value = "pedido-item-produto")
	@MapsId("idProduto")
	@OneToOne()
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private Produto produto;

	@JsonIgnore
	public boolean isPedidoItemPK(){
		return Objects.nonNull(this.pedidoItemPK);
	}

	@JsonIgnore
	public boolean isPedidoItemPKIdPedido(){
		return (isPedidoItemPK() && Objects.nonNull(this.pedidoItemPK.getIdPedido()));
	}

	@JsonIgnore
	public boolean isPedidoItemPKIdProduto(){
		return (isPedidoItemPK() && Objects.nonNull(this.pedidoItemPK.getIdProduto()));
	}

	@JsonIgnore
	public boolean isPedido() {
		return Objects.nonNull(this.pedido);
	}
	
	@JsonIgnore
	public boolean isProduto() {
		return Objects.nonNull(this.produto);
	}

	@JsonIgnore
	public Optional<Double> getQuantidadeOptional() {
		return Optional.ofNullable(quantidade);
	}

	@JsonIgnore
	public Optional<BigDecimal> getValorTotalItensDoPedidoOptional() {
		return Optional.ofNullable(valorTotalItensDoPedido);
	}

	
}
