package net.combase.example.eip.throttle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class OrderServiceActivator {

	@Autowired
	OrderService orderService;

	@ServiceActivator
	public void processOrderRequest(OrderRequest orderRequest) {

		orderService.processOrderRequest(orderRequest);

	}

}
