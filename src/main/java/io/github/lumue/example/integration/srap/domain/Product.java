package io.github.lumue.example.integration.srap.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Product extends BaseEntity {

	String name;

	BigDecimal stock;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getStock() {
		return stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

}
