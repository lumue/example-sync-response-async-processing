package io.github.lumue.example.integration.srap.service;

import io.github.lumue.example.integration.srap.dao.CustomerRepository;
import io.github.lumue.example.integration.srap.dao.OrderRepository;
import io.github.lumue.example.integration.srap.dao.ProductRepository;
import io.github.lumue.example.integration.srap.domain.Customer;
import io.github.lumue.example.integration.srap.domain.Order;
import io.github.lumue.example.integration.srap.domain.Product;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

	@Autowired(required = true)
	private CustomerRepository customerRepository;

	@Autowired(required = true)
	private ProductRepository productRepository;

	@Autowired(required = true)
	private OrderRepository orderRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW, 
						isolation = Isolation.SERIALIZABLE) 
	// @Isolation.Serializable, because product.stock has to be locked during
	// transaction
	public void processOrderRequest(OrderRequest orderRequest) {
		
		Customer customer = customerRepository.findOne(orderRequest.getCustomerId());
		Product product = productRepository.findOne(orderRequest.getProdcutId());
		BigDecimal quantity = new BigDecimal(orderRequest.getQuantity());

		Order order = new Order(product, customer, quantity);
		orderRepository.save(order);
		product.setStock(product.getStock().subtract(quantity));
	}

}
