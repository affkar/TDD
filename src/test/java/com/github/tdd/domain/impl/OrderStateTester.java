package com.github.tdd.domain.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.tdd.domain.Warehouse;

public class OrderStateTester {

	private static String TALISKER = "Talisker";
	private static String HIGHLAND_PARK = "Highland Park";
	private Warehouse warehouse = new WarehouseImpl();

	@Before
	public void setUp()
	{
		warehouse.add(TALISKER,20);
		warehouse.add(HIGHLAND_PARK,30);
	}
	
	@Test
	  public void testOrderIsFilledIfEnoughInWarehouse() {
		    Order order = new Order(TALISKER, 15);
		    order.fill(warehouse);
		    assertTrue(order.isOrderFilled());
		    assertEquals(new Integer(0), warehouse.getInventoryQuantity(TALISKER));
		  }

}
