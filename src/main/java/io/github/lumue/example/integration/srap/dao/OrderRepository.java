package io.github.lumue.example.integration.srap.dao;

import io.github.lumue.example.integration.srap.domain.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {

}
