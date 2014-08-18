package net.combase.example.eip.throttle.dao;

import net.combase.example.eip.throttle.domain.Order;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {

}
