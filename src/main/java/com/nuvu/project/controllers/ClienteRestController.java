package com.nuvu.project.controllers;


import com.nuvu.project.models.entity.Cliente;
import com.nuvu.project.services.interfaces.IClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Accion exitosa"),
		@ApiResponse(code = 500, message = "Internal Server Error")
})
@Api(value = "Cliente ClienteController", description = "Servicio Cliente  Manager",  tags = {"",""})
public class ClienteRestController {

	private final IClientService clienteService;

	@Autowired
	public ClienteRestController( IClientService clienteService ) {
		this.clienteService = clienteService;
	}

	@ApiOperation(value = "Obtener lista de Cliente", notes = "Retorna listado de Cliente del sistema xxxxx")
	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/page/{page}" )
	public Page<Cliente> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 4);
		return clienteService.findAll(pageable);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Optional<Cliente> cliente;
		Map<String, Object> response = new HashMap<>();
		
		try {
			cliente = clienteService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", Objects.requireNonNull( e.getMessage() ).concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>( response, HttpStatus.INTERNAL_SERVER_ERROR );
		}
		
		if(!cliente.isPresent()) {
			response.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<>( response, HttpStatus.NOT_FOUND );
		}
		
		return new ResponseEntity<>( cliente.get(), HttpStatus.OK );
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<?> create(  @RequestBody Cliente cliente, BindingResult result) {
		
		Cliente clienteNew;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<>( response, HttpStatus.BAD_REQUEST );
		}
		
		try {
			clienteNew = clienteService.save(cliente);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>( response, HttpStatus.INTERNAL_SERVER_ERROR );
		}
		
		response.put("mensaje", "El cliente ha sido creado con éxito!");
		response.put("cliente", clienteNew);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
}
