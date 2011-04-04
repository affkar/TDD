package com.github.tdd.domain.impl;

import java.util.Map;

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
		
		Map<String, Integer> products = warehouse.getProducts();
		Integer quantityAvailable = products.get(productName);
		
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

    public void report(Warehouse warehouse)
    {
    	warehouse.report();
    }

}
