package com.devsuperior.dsdelivey.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdelivey.dto.ProductDTO;
import com.devsuperior.dsdelivey.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	
	@Autowired
	private ProductService service;
	
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
	List<ProductDTO> list = service.findAll(); //Usando Metodo já criado antes de retorno
	return ResponseEntity.ok().body(list); //Retornando Metodo HTTP

	}
	}
