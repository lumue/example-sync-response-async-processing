package io.github.lumue.example.integration.srap.dao;

import io.github.lumue.example.integration.srap.domain.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

	public Customer findByNumber(String number);

}
