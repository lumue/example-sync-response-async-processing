package net.combase.example.eip.throttle.dao;

import net.combase.example.eip.throttle.domain.Customer;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
