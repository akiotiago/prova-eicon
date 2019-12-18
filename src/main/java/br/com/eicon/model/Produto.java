package br.com.eicon.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 7973487456145791818L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduto;
	
	@NotBlank
	private String descricao;
	
	@DecimalMin(value = "0.01")
	@Digits(integer=3, fraction=2)
	private BigDecimal valorProduto;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "produto")
	private List<PedidoItem> listaDePedidoItens;
	
}
