package net.combase.example.eip.throttle.service;

import java.util.UUID;

public class OrderRequest {

	private final String id = UUID.randomUUID().toString();

	private final String prodcutId;

	private final String customerId;

	private final String quantity;

	public OrderRequest(String prodcutId, String customerId, String quantity) {
		super();
		this.prodcutId = prodcutId;
		this.customerId = customerId;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public String getProdcutId() {
		return prodcutId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getQuantity() {
		return quantity;
	}

}