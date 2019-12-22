package br.com.eicon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "tb_produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 7973487456145791818L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String descricao;
	
	@DecimalMin(value = "0.01")
	@Digits(integer=12, fraction=2)
	@Column(name = "valor_produto")
	private BigDecimal valorProduto;

	@JsonBackReference(value = "pedido-item-produto")
	@OneToOne(mappedBy = "produto", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private PedidoItem pedidoItem;

	public boolean isId() {
		return Objects.nonNull(this.id);
	}
	
	public boolean isPedidoItem() {
		return Objects.nonNull(this.pedidoItem);
	}

	public Optional<Long> getIdOptional() {
		return Optional.ofNullable(id);
	}

	public Optional<String> getDescricaoOptional() {
		return Optional.ofNullable(descricao);
	}

	public Optional<BigDecimal> getValorProdutoOptional() {
		return Optional.ofNullable(valorProduto);
	}


	
}
