package br.com.eicon.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 9049686602408225632L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "nome_cliente")
	private String nomeCliente;
	
//	@CPF
	@Column(length = 14)
	private String cpf;
	
	@Email
	private String email;
	
	@JsonManagedReference(value = "pedido-cliente")
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> listaDePedidos;
	
	@JsonIgnore
	public boolean isIdNotNull() {
		return Objects.nonNull(this.id);
	}

	@JsonIgnore
	public boolean isListaDePedidos() {
		return (this.listaDePedidos != null && !this.listaDePedidos.isEmpty());
	}

	@JsonIgnore
	public Optional<Long> getIdOptional() {
		return Optional.ofNullable(this.id);
	}

	@JsonIgnore
	public Optional<String> getNomeClienteOptional() {
		return Optional.ofNullable(nomeCliente);
	}

	@JsonIgnore
	public Optional<String> getCpfOptional() {
		return Optional.ofNullable(cpf);
	}

	@JsonIgnore
	public Optional<String> getEmailOptional() {
		return Optional.ofNullable(email);
	}


}
