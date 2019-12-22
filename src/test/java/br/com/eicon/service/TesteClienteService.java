package br.com.eicon.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.eicon.dto.ClienteProjection;
import br.com.eicon.model.Cliente;
import br.com.eicon.model.Cliente.ClienteBuilder;
import br.com.eicon.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TesteClienteService {

	@Autowired
	private ClienteRepository clienteService;
	@Rule
	public ExpectedException expException = ExpectedException.none();

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
		assertThat(cliente.getId()).isNotNull();
		assertThat(cliente.getNomeCliente()).isEqualTo("Joao");
		assertThat(cliente.getCpf()).isEqualTo("851.712.410-31");
		assertThat(cliente.getEmail()).isEqualTo("joao@joao.com.br");
	}
	
	@Test
	public void deletarUmCliente() {
		Cliente cliente = criarUmNovoCliente();
		this.clienteService.save(cliente);
		final long idCliente = cliente.getId();
		this.clienteService.delete(cliente);
		expException.expect(NoSuchElementException.class);
		assertThat(this.clienteService.findById(idCliente).get()).isNull();
	}

	@Test
	public void atualizarUmCliente() {
		Cliente cliente = criarUmNovoCliente();
		this.clienteService.save(cliente);

		ClienteBuilder clienteBuilder = cliente.toBuilder();
		Cliente clienteParaAtualizar = clienteBuilder
			.nomeCliente("Joao 12")
			.cpf("505.695.890-53")
			.email("joao12@joao12.com.br")
			.build();		
		
		this.clienteService.save(clienteParaAtualizar);

		Optional<Cliente> clienteAtualizado = this.clienteService.findById(clienteParaAtualizar.getId());
		assertThat(clienteAtualizado.get().getNomeCliente()).isEqualTo("Joao 12");
		assertThat(clienteAtualizado.get().getCpf()).isEqualTo("505.695.890-53");
		assertThat(clienteAtualizado.get().getEmail()).isEqualTo("joao12@joao12.com.br");
	}
	
	@Test
	public void buscarUmaListaDeClientesPeloNome() {
		Cliente cliente = criarUmNovoCliente();
		this.clienteService.save(cliente);
		
		@SuppressWarnings("static-access")
		Cliente cliente2 = new Cliente().builder()
			.nomeCliente("Joao 12")
			.cpf("505.695.890-53")
			.email("joao12@joao12.com.br")
			.build();		
		
		this.clienteService.save(cliente2);
		
		List<ClienteProjection> listaCliente = this.clienteService.findClienteByNomeClienteStartingWithIgnoreCase("j", ClienteProjection.class);
		assertThat(listaCliente.size()).isEqualTo(2);
	}
	
}
