package com.github.tdd.domain.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.tdd.domain.Warehouse;

public class WarehouseImpl implements Warehouse {

	private String name;
    private Map<String,Integer> products = new HashMap<String,Integer>();
    
	@Override
	public void setName(String warehouseName) {
		this.name=warehouseName;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void add(String product, Integer quantity) {
		this.products.put(product, quantity);
	}

	@Override
	public Map<String, Integer> getProducts() {
		return products;
	}

	@Override
	public Integer getInventoryQuantity(String product) {
		return products.get(product);
	}

	




}
