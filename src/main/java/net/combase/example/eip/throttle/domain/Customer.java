package net.combase.example.eip.throttle.domain;

import javax.persistence.Entity;

@Entity
public class Customer extends BaseEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
