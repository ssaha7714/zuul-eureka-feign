package com.demo.microarch.config.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microarch.config.intercomm.CardClient;
import com.demo.microarch.config.model.Card;
import com.demo.microarch.config.model.Customer;
import com.demo.microarch.config.model.CustomerType;

@RestController
public class Api {
	
	@Autowired
	private CardClient cardClient;
	
	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	private List<Customer> customers;
	
	public Api() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "Adam Kowalski", CustomerType.INDIVIDUAL));
		customers.add(new Customer(2, "Anna Malinowska", CustomerType.INDIVIDUAL));
		customers.add(new Customer(3, "Pawel Michalski", CustomerType.INDIVIDUAL));
		customers.add(new Customer(4, "Karolina Lewandowska", CustomerType.INDIVIDUAL));
	}
	
	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return customers;
	}
	
	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Customer.findById(%s)", id));
		Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		List<Card> cards =  cardClient.getCards(id);
		customer.setCards(cards);
		return customer;
	}
	
}
