package com.devsuperior.dsdelivey.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivey.dto.OrderDTO;
import com.devsuperior.dsdelivey.entities.Order;
import com.devsuperior.dsdelivey.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(readOnly =  true)
	public List<OrderDTO> findAll(){
		
		List<Order> list = orderRepository.buscandoPedidosComProdutos();
		
		//usando Lambda par receber a stream             Desfazendo a stream(VERBOSO)    
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	
}
