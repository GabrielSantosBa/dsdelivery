package com.devsuperior.dsdelivey.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dsdelivey.dto.OrderDTO;
import com.devsuperior.dsdelivey.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		List<OrderDTO> list = service.findAll(); // Usando Metodo já criado antes de retorno
		return ResponseEntity.ok().body(list); // Retornando Metodo HTTP

	}
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id) {
		OrderDTO dto = service.setDelivery(id);
		
		return ResponseEntity.ok().body(dto);
	}
}
