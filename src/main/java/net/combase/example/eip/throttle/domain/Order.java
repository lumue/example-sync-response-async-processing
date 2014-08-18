package net.combase.example.eip.throttle.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order extends BaseEntity {

	@ManyToOne
	private Product product;

	@ManyToOne
	private Customer customer;

	private BigDecimal quantity;

	public Order(Product product, Customer customer, BigDecimal quantity) {
		super();
		this.product = product;
		this.customer = customer;
		this.quantity = quantity;
	}

	Order() {
		super();
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
