package com.github.tdd.domain.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.github.tdd.domain.Warehouse;

public class OrderStateTester {

	private static String TALISKER = "Talisker";
	private static String HIGHLAND_PARK = "Highland Park";
	private Warehouse warehouse = new WarehouseImpl();

	// Step1: SetUp
	@Before
	public void setUp() {
		warehouse.add(TALISKER, 20);
		warehouse.add(HIGHLAND_PARK, 30);
	}

	@Test
	public void testOrderIsFilledIfEnoughInWarehouse() {

		// Step2: Exercise
		Order order = new Order(TALISKER, 15);
		order.fill(warehouse);
		// Step3: Verify
		assertTrue(order.isOrderFilled());
		assertEquals(new Integer(5), warehouse.getInventoryQuantity(TALISKER));
	}

	// Step4: Tear down - No explicit tear down. Left for GC
}
