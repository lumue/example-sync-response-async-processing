package io.github.lumue.example.integration.srap.domain;

import javax.persistence.Entity;

@Entity
public class Customer extends BaseEntity {

	private String number;
	
	private String name;
	
	public Customer(String number, String name) {
		setNumber(number);
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String nummer) {
		this.number = nummer;
	}

	Customer() {
		super();
	}
	
	

}
