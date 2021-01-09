package com.devsuperior.dsdelivey.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsdelivey.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	
	//Metodo do Spring JPA para receber os dados por ordem(MUITO LOUCO ISSO..)
	List<Product> findAllByOrderByNameAsc();
	
	
}
