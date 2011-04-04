package com.github.tdd.domain.impl;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.HashMap;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.github.tdd.domain.Warehouse;

public class OrderStateEasyMockTester {

	private static String TALISKER = "Talisker";
	private static String HIGHLAND_PARK = "Highland Park";
	private Warehouse warehouseMock;
	Map<String,Integer> getProductsReturnValue; 
	
	@Before
	public void setUp() {
		
		warehouseMock= EasyMock.createMock(WarehouseImpl.class);
		warehouseMock.init();
		warehouseMock.add(TALISKER, 20);
		warehouseMock.add(HIGHLAND_PARK, 30);
        
		getProductsReturnValue = new HashMap<String,Integer>();
		getProductsReturnValue.put(TALISKER,20);
		getProductsReturnValue.put(HIGHLAND_PARK, 30);
	}

	@Test
	public void orderShouldGetFilled() {
		// setup - data
		Order order = new Order(TALISKER, 50);
		
		//record: Object-Under-Test with Mocked Collaborator
		expect(warehouseMock.getProducts()).andReturn(getProductsReturnValue);
        
		replay(warehouseMock);
		order.fill(warehouseMock);
       
		

	}

}
