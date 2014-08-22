package io.github.lumue.example.integration.srap.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class Product extends BaseEntity {

	private String number;
	
	private String name;

	private BigDecimal stock;

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	

}
