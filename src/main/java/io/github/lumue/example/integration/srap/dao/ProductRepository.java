package io.github.lumue.example.integration.srap.dao;

import io.github.lumue.example.integration.srap.domain.Product;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {

}
