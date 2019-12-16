package br.com.eicon.dto;

import org.springframework.data.rest.core.config.Projection;

import br.com.eicon.model.Cliente;

@Projection(name = "clienteProjection", types = { Cliente.class })
public interface ClienteProjection {

	Long getId();
	
	String getNomeCLiente();
	
	String getEmail();
	
}
