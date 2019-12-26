package br.com.eicon.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.eicon.model.Cliente;
import br.com.eicon.repository.ClienteRepository;

@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class TesteClienteService {

	@Autowired
	private ClienteRepository clienteService;
	@Rule
	public ExpectedException expException = ExpectedException.none();
	
	@Autowired
	private TestEntityManager entityManager;

	@SuppressWarnings("static-access")
	public Cliente criarUmNovoCliente() {
		return new Cliente().builder()
				.nomeCliente("Joao")
				.cpf("851.712.410-31")
				.email("joao@joao.com.br")
				.build();
	}

	@Test
	public void salvarUmCliente() {
		Cliente cliente = criarUmNovoCliente();
		this.clienteService.save(cliente);
		this.entityManager.persistAndFlush(cliente);
		assertThat(cliente.getId()).isNotNull();
		assertThat(cliente.getNomeCliente()).isEqualTo("Joao");
		assertThat(cliente.getCpf()).isEqualTo("851.712.410-31");
		assertThat(cliente.getEmail()).isEqualTo("joao@joao.com.br");
	}
	
	@Test
	public void deletarUmCliente() {
		Cliente cliente = criarUmNovoCliente();
		cliente = this.clienteService.save(cliente);
		this.entityManager.persistAndFlush(cliente);
		
		final long idCliente = cliente.getId();
//		this.clienteService.delete(cliente);
		this.entityManager.remove(cliente);
		expException.expect(NoSuchElementException.class);
		assertThat(this.clienteService.findById(idCliente).get()).isNull();
	}

	@Test
	public void atualizarUmCliente() {
		Cliente cliente = criarUmNovoCliente();
		this.clienteService.save(cliente);
		this.entityManager.persistAndFlush(cliente);
		
		Cliente clienteParaAtualizar = Cliente.builder()
			.nomeCliente("Joao 12")
			.cpf("505.695.890-53")
			.email("joao12@joao12.com.br")
			.build();		
		
		this.clienteService.save(clienteParaAtualizar);
		this.entityManager.persistAndFlush(clienteParaAtualizar);
		Optional<Cliente> clienteAtualizado = this.clienteService.findById(clienteParaAtualizar.getId());
		assertThat(clienteAtualizado.get().getNomeCliente()).isEqualTo("Joao 12");
		assertThat(clienteAtualizado.get().getCpf()).isEqualTo("505.695.890-53");
		assertThat(clienteAtualizado.get().getEmail()).isEqualTo("joao12@joao12.com.br");
	}
	
	
}
