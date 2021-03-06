package io.github.lumue.example.integration.srap.web;

import io.github.lumue.example.integration.srap.service.OrderRequest;
import io.github.lumue.example.integration.srap.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("/execute_order")
	public String executeOrder(@RequestParam(value = "productId", required = true) String productId,
			@RequestParam(value = "customerId", required = true) String customerId,
			@RequestParam(value = "quantity", required = true) String quantity) {

		OrderRequest orderRequest = new OrderRequest(productId, customerId, quantity);
		orderService.processOrderRequest(orderRequest);
		return orderRequest.getId();

	}

}
