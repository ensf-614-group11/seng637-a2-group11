package org.jfree.data.test;

import static org.junit.Assert.assertEquals;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest extends DataUtilities {

	private Mockery context;
	private Values2D mockData;

	@Before
	public void setUp() {
		context = new Mockery();
		mockData = context.mock(Values2D.class);
	}

	// Test Case 1: Valid data, valid column index
	@Test
	public void testValidDataAndColumn() {
		context.checking(new Expectations() {
			{
				allowing(mockData).getRowCount();
				will(returnValue(2));
				allowing(mockData).getColumnCount();
				will(returnValue(2));
				allowing(mockData).getValue(0, 1);
				will(returnValue(2.0));
				allowing(mockData).getValue(1, 1);
				will(returnValue(4.0));
			}
		});

		double result = DataUtilities.calculateColumnTotal(mockData, 1);
		assertEquals(6.0, result, 0.0001);
	}

	@After
	public void tearDown() {
		// Not Required
	}

	@AfterClass
	public static void afterAllTests() {
		// Not Required
	}

}
