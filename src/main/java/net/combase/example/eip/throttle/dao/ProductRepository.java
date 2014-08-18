package net.combase.example.eip.throttle.dao;

import net.combase.example.eip.throttle.domain.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {

}
