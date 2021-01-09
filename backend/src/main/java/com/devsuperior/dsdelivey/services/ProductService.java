package com.devsuperior.dsdelivey.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivey.dto.ProductDTO;
import com.devsuperior.dsdelivey.entities.Product;
import com.devsuperior.dsdelivey.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly =  true)
	public List<ProductDTO> findAll(){
		
		List<Product> list = repository.findAllByOrderByNameAsc();
		
		//usando Lambda par receber a stream             Desfazendo a stream(VERBOSO)    
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		
	}
	
}
