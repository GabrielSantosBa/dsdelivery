package com.devsuperior.dsdelivey.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdelivey.dto.OrderDTO;
import com.devsuperior.dsdelivey.services.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
	List<OrderDTO> list = orderService.findAll(); //Usando Metodo já criado antes de retorno
	return ResponseEntity.ok().body(list); //Retornando Metodo HTTP

	}
	}
