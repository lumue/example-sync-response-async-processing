package net.combase.example.eip.throttle.service;

import java.math.BigDecimal;

import net.combase.example.eip.throttle.dao.CustomerRepository;
import net.combase.example.eip.throttle.dao.OrderRepository;
import net.combase.example.eip.throttle.dao.ProductRepository;
import net.combase.example.eip.throttle.domain.Customer;
import net.combase.example.eip.throttle.domain.Order;
import net.combase.example.eip.throttle.domain.Product;

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
