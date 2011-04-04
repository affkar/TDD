package com.github.tdd.domain;

import java.util.Map;

public interface Warehouse {

	public void setName(String warehouseName);
	public String getName();
	public void add(String product,Integer quantity);
	public Map<String, Integer> getProducts();
	public Integer getInventoryQuantity(String product);
	public void init();
	public void report();
}
