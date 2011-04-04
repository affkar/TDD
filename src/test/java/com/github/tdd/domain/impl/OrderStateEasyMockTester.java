package com.github.tdd.domain.impl;

import org.easymock.EasyMock;
import org.easymock.IMockBuilder;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;

import com.github.tdd.domain.Warehouse;
import static org.easymock.EasyMock.*;

public class OrderStateEasyMockTester {

	private static String TALISKER = "Talisker";
	private static String HIGHLAND_PARK = "Highland Park";
	private Warehouse warehouseMock;
	
	
	@Before
	public void setUp() {
		
		warehouseMock= EasyMock.createMock(Warehouse.class);
		System.out.println(warehouseMock==null);
		warehouseMock.init();
		warehouseMock.add(TALISKER, 20);
		warehouseMock.add(HIGHLAND_PARK, 30);
        
	}

	@Test
	public void orderShouldGetFilled() {
		// setup - data
		Order order = new Order(TALISKER, 50);
		
		//record: Object-Under-Test with Mocked Collaborator
		warehouseMock.getProducts();
        
		replay(warehouseMock);
		order.fill(warehouseMock);
       
		

	}

}
