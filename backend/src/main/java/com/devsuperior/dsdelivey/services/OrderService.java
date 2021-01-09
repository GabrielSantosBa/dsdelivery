package com.devsuperior.dsdelivey.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdelivey.dto.OrderDTO;
import com.devsuperior.dsdelivey.dto.ProductDTO;
import com.devsuperior.dsdelivey.entities.Order;
import com.devsuperior.dsdelivey.entities.OrderStatus;
import com.devsuperior.dsdelivey.entities.Product;
import com.devsuperior.dsdelivey.repositories.OrderRepository;
import com.devsuperior.dsdelivey.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly =  true)
	public List<OrderDTO> findAll(){
		
		List<Order> list = orderRepository.buscandoPedidosComProdutos();
		
		//usando Lambda par receber a stream             Desfazendo a stream(VERBOSO)    
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional          //Recebdo Pedido com os Produtos
	public OrderDTO insert(OrderDTO dto){
		//Inserindo Produto
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),				
				Instant.now(), OrderStatus.PENDENTE);
		
		//Associando Produtos no Pedido
		for(ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		
		//Guardando referencia para o OBJ Order
		order = orderRepository.save(order);	
		
	return new OrderDTO(order);
	}
	
}
