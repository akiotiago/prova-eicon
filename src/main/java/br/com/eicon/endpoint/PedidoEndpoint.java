package br.com.eicon.endpoint;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eicon.model.Pedido;
import br.com.eicon.service.PedidoService;
import br.com.eicon.util.ApiPageable;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pedido")
public class PedidoEndpoint {
	
	@Autowired
	private PedidoService pedidoService;

	@ApiOperation(value = "Retorna uma lista paginada de pedidos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna a lista de pedidos"),
			@ApiResponse(code = 500, message = "Erro nao esperado")
	})
	@ApiPageable
	@GetMapping()
	public ResponseEntity<?> findAll(Pageable pageable){
		return new ResponseEntity<>(pedidoService.findAll(pageable), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		return new ResponseEntity<>(pedidoService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody Pedido pedido){
		return new ResponseEntity<>(pedidoService.save(pedido), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Pedido pedido){
		return new ResponseEntity<>(pedidoService.save(pedido), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		pedidoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
