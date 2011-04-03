package com.github.tdd.domain.impl;

import com.github.tdd.domain.Warehouse;

public class Order {

	private String productName;
	private Integer quantity;
	private boolean isFilled;

	public Order() {

	}

	public Order(String productName, Integer quantity) {
		this.productName = productName;
		this.quantity = quantity;
	}

	public void fill(Warehouse warehouse) {
		System.out.println("Filling from Warehouse: " + warehouse.getName());
		
		Integer quantityAvailable = warehouse.getProducts().get(productName);
		
		if(quantity<quantityAvailable)
		{ 
			warehouse.getProducts().put(productName,quantityAvailable-quantity);
		    this.isFilled=true;
		}
		else
		{
			this.isFilled=false;
		}
	}

	public boolean isOrderFilled() {
		return isFilled;
	}



}
