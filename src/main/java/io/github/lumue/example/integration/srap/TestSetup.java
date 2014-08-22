package io.github.lumue.example.integration.srap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.github.lumue.example.integration.srap.dao.CustomerRepository;
import io.github.lumue.example.integration.srap.dao.ProductRepository;
import io.github.lumue.example.integration.srap.domain.Customer;
import io.github.lumue.example.integration.srap.domain.Product;

/**
 * Initialize the Database with some Customers and Products
 * 
 * @author lm
 *
 */
@Component
public class TestSetup {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	ProductRepository productRepository;
	

	
	@Transactional
	public void insertTestData()
	{
		insertCustomers(10);
		insertProducts(10);
	}

	private void insertProducts(int numberOfProducts) {
		for(int i=0;i<numberOfProducts;i++)
		{
			String number=Integer.toString(i);
			if(productRepository.findByNumber(number)==null)
			{
				String name="Product "+number;
				productRepository.save(new Product(number,name));
			}
		}
	}

	private void insertCustomers(int numberOfCustomers) {
		for(int i=0;i<numberOfCustomers;i++)
		{
			String number=Integer.toString(i);
			if(customerRepository.findByNumber(number)==null)
			{
				String name="Customer "+number;
				customerRepository.save(new Customer(number,name));
			}
		}
		
	}
	
	
}
