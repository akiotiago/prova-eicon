package br.com.eicon.endpoint;



import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eicon.model.Pedido;
import br.com.eicon.model.query.CustomSpecificationPedido;
import br.com.eicon.service.PedidoService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@RequestMapping("/pedido")
@Tag(name = "Pedido", description = "Pedidos dos Clientes")
public class PedidoEndpoint {
	
	@Autowired
	private PedidoService pedidoService;

//	https://github.com/tkaczmarzyk/specification-arg-resolver
	@Operation(	summary = "Filtro de pedido por SpecificationArgResolver", 
				externalDocs = @ExternalDocumentation(description = "", url = "https://github.com/tkaczmarzyk/specification-arg-resolver"), 
				description = "Retorna uma lista de Pedidos", tags = { "Pedido" })
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Operacao realizada com sucesso", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Pedido.class)))) })	
	@GetMapping(path = "/filtroPorSpecificationArgResolver", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> filtroDePedidosPorSpecificationArgResolver(	@RequestParam(value = "CustomSpecificationPedido") CustomSpecificationPedido customSpecificationPedido,
														@RequestParam(value = "page", defaultValue = "0") Integer page,
														@RequestParam(value = "size", defaultValue = "10") Integer size){
		return new ResponseEntity<>(pedidoService.findAll(customSpecificationPedido, PageRequest.of(page, size, Sort.by("id").ascending())) , HttpStatus.OK);
	}
        
        
	@Operation(summary = "Filtro de pedido por JPQL", description = "Retorna uma lista de Pedidos", tags = { "Pedido" })
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Operacao realizada com sucesso", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Pedido.class)))) })	
	@PostMapping(path = "/filtroPorJPQL", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> filtroDePedidosPorJPQL(	@RequestBody Pedido pedido,
												@RequestParam(value = "page", defaultValue = "0") Integer page,
												@RequestParam(value = "size", defaultValue = "10") Integer size){
		return new ResponseEntity<>(pedidoService.filtroDePedidos(pedido, PageRequest.of(page, size, Sort.by("id").ascending()), Pedido.class) , HttpStatus.OK);
	}
	
	@Operation(summary = "Busca um pedido", description = "Retorna uma lista de Pedidos", tags = { "Pedido" })
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Operacao realizada com sucesso", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Pedido.class)))) })	
	@GetMapping()
	public ResponseEntity<?> findAll(	@RequestParam(value = "page", defaultValue = "0") Integer page,
		    							@RequestParam(value = "size", defaultValue = "10") Integer size){
		return new ResponseEntity<>(pedidoService.findAll(PageRequest.of(page, size, Sort.by("id").ascending().and(Sort.by("dataDoPedido")))), HttpStatus.OK);
	}

	@Operation(summary = "Busca um pedido pelo ID", description = "Retorna somente um pedido por ID", tags = { "Pedido" })
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Pedido.class))),
		@ApiResponse(responseCode = "404", description = "Pedido não encontrado") })	 
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") @NotNull  Long id){
		return new ResponseEntity<>(pedidoService.findById(id), HttpStatus.OK);
	}
	
	@Operation(summary = "Adiciona um novo pedido", description = "", tags = { "Pedido" })
	@ApiResponses(value = { 
	    @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso", content = @Content(schema = @Schema(implementation = Pedido.class))), 
	    @ApiResponse(responseCode = "400", description = "Inserção inválida"), 
	    @ApiResponse(responseCode = "409", description = "Pedido existente") })	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@Valid @RequestBody Pedido pedido){
		return new ResponseEntity<>(pedidoService.save(pedido), HttpStatus.CREATED);
	}
	
    @Operation(summary = "Atualiza um pedido existente", description = "", tags = { "Pedido" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "400", description = "Id do pedido inválido"),
        @ApiResponse(responseCode = "404", description = "Pedido não encontrado"),
        @ApiResponse(responseCode = "405", description = "Exceção de validação") })
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Pedido pedido){
		return new ResponseEntity<>(pedidoService.save(pedido), HttpStatus.OK);
	}
	
	@Operation(summary = "Deleta um pedido", description = "", tags = { "Pedido" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "404", description = "Pedido não encontrado") })
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable @NotNull Long id){
		pedidoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
