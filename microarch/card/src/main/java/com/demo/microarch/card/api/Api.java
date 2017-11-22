package com.demo.microarch.card.api;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microarch.card.exception.CardNotFoundException;
import com.demo.microarch.card.model.Card;

@RestController
public class Api {

	private List<Card> cards;
	
	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	public Api() {
		cards = new ArrayList<>();
		cards.add(new Card(1, 1, "111111"));
		cards.add(new Card(2, 2, "222222"));
		cards.add(new Card(3, 3, "333333"));
		cards.add(new Card(4, 4, "444444"));
		cards.add(new Card(5, 1, "555555"));
		cards.add(new Card(6, 2, "666666"));
		cards.add(new Card(7, 2, "777777"));
	}
	
	@RequestMapping("/cards/{number}")
	public Card findByNumber(@PathVariable("number") String number) throws CardNotFoundException {
		logger.info(String.format("Card.findByNumber(%s)", number));
		Card card = null;
		try{
		card = cards.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
		}catch(NoSuchElementException e){
			throw new CardNotFoundException(number);
		}
		return card;
	}
	
	@RequestMapping("/cards/customer/{customer}")
	public List<Card> findByCustomer(@PathVariable("customer") Integer customerId) {
		try {
			Thread.sleep(120000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(String.format("Card.findByCustomer(%s)", customerId));
		return cards.stream().filter(it -> it.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
	}
	
	@RequestMapping("/cards")
	public List<Card> findAll() {
		logger.info("Card.findAll()");
		return cards;
	}
	
}
