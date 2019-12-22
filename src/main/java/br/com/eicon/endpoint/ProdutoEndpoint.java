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
import br.com.eicon.model.Produto;
import br.com.eicon.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Validated
@RequestMapping("/produto")
@Tag(name = "Produto", description = "Produtos")
public class ProdutoEndpoint {

	@Autowired
	private ProdutoService produtoService;

	@Operation(summary = "Busca produtos", description = "Retorna uma lista de Produtos", tags = { "Produto" })
	@ApiResponses(value = {
		        @ApiResponse(responseCode = "200", description = "Operacao realizada com sucesso", 
		        		content = @Content(array = @ArraySchema(schema = @Schema(implementation = Produto.class)))) })	
	@GetMapping()
	public ResponseEntity<?> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
		    							@RequestParam(value = "size", defaultValue = "10") Integer size){
		
		return new ResponseEntity<>(produtoService.findAll(PageRequest.of(page, size, Sort.by("id").ascending())), HttpStatus.OK);
	}

	@Operation(summary = "Busca um Produto pelo ID", description = "Retorna somente um produto por ID", tags = { "Produto" })
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Produto.class))),
	        @ApiResponse(responseCode = "404", description = "Produto não encontrado") })	 
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") @NotNull  Long id){
		return new ResponseEntity<>(produtoService.findById(id), HttpStatus.OK);
	}
	
	@Operation(summary = "Adiciona um novo produto", description = "", tags = { "Produto" })
	@ApiResponses(value = { 
	        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso", content = @Content(schema = @Schema(implementation = Produto.class))), 
	        @ApiResponse(responseCode = "400", description = "Inserção inválida"), 
	        @ApiResponse(responseCode = "409", description = "Produto existente") })	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@Valid @RequestBody Produto produto){
		return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
	}
	
    @Operation(summary = "Atualiza um produto existente", description = "", tags = { "Produto" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "400", description = "Id do produto inválido"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
        @ApiResponse(responseCode = "405", description = "Exceção de validação") })
	@PutMapping
	public ResponseEntity<?> update(@Valid @RequestBody Produto produto){
		return new ResponseEntity<>(produtoService.save(produto), HttpStatus.OK);
	}
	
	@Operation(summary = "Deleta um produto", description = "", tags = { "Produto" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado") })
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable @NotNull Long id){
		produtoService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
