package br.com.eicon.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor @Getter @EqualsAndHashCode
@Builder(toBuilder = true)
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 9049686602408225632L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nomeCLiente;
	
	@CPF
	private String cpf;
	
	@Email
	private String email;
	
	@JsonManagedReference(value = "pedido-cliente")
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> listaDePedidos;

}
