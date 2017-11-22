package com.demo.microarch.card.model;

public class Card {
	private Integer id;
	private Integer customerId;
	private String number;

	public Card() {

	}

	public Card(Integer id, Integer customerId, String number) {
		this.id = id;
		this.customerId = customerId;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", customerId=" + customerId + ", number=" + number + "]";
	}
}
