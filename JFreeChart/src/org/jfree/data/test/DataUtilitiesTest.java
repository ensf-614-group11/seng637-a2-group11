package org.jfree.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

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

	// Test Case 2: Null Values2D data object
	@Test
	public void testInvalidDataAndValidColumn() {
		try {
			double result = DataUtilities.calculateColumnTotal(null, 0);
			// If no exception is thrown, the test should fail
			fail("Expected InvalidParameterException but no exception was thrown.");
		} catch (InvalidParameterException e) {
			// Test passes because the correct exception was thrown
		} catch (Exception e) {
			// Test fails because the wrong exception was thrown
			fail("Expected InvalidParameterException but got " + e.getClass().getSimpleName());
		}
	}

	// Test Case 3: Valid Values2D data object but invalid column index (negative)
	@Test
	public void testValidDataAndInvalidColumn() {
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
				allowing(mockData).getValue(0, 0);
				will(returnValue(1.0));
				allowing(mockData).getValue(1, 0);
				will(returnValue(3.0));

				allowing(mockData).getValue(0, -10);
				will(throwException(new IndexOutOfBoundsException("Invalid column index")));

				allowing(mockData).getValue(1, -10);
				will(throwException(new IndexOutOfBoundsException("Invalid column index")));
				// Javadoc specifies invalid columns in the getValue function in Values2D
				// throws an IndexOutOfBoundsException.
				// Therefore this behaviour will be simulated with the mock.
			}
		});

		try {
			double result = DataUtilities.calculateColumnTotal(mockData, -10);
			assertEquals(0.0, result, 0.0001);
		} catch (Exception e) {
			fail("Expected to return 0 but got a " + e.getClass().getSimpleName());
		}
	}

	// Test Case 4: Test valid Values2D data object and valid row index
	@Test
	public void testValidDataAndRow() {
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
				allowing(mockData).getValue(0, 0);
				will(returnValue(1.0));
				allowing(mockData).getValue(1, 0);
				will(returnValue(3.0));
			}
		});

		double result = DataUtilities.calculateRowTotal(mockData, 1);
		assertEquals(7.0, result, 0.0001);
	}

	// Test Case 5: Test invalid Values2D data object and valid row index
	@Test
	public void testInvalidDataAndValidRow() {
		try {
			double result = DataUtilities.calculateRowTotal(null, 1);
			// If no exception is thrown, the test should fail
			fail("Expected InvalidParameterException but no exception was thrown.");
		} catch (InvalidParameterException e) {
			// Test passes because the correct exception was thrown
		} catch (Exception e) {
			// Test fails because the wrong exception was thrown
			fail("Expected InvalidParameterException but got " + e.getClass().getSimpleName());
		}
	}

	// Test Case 6: Test valid Values2D data object and invalid row index
	@Test
	public void testValidDataAndInvalidRow() {

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
				allowing(mockData).getValue(0, 0);
				will(returnValue(1.0));
				allowing(mockData).getValue(1, 0);
				will(returnValue(3.0));

				allowing(mockData).getValue(-10, 0);
				will(throwException(new IndexOutOfBoundsException("Invalid column index")));

				allowing(mockData).getValue(-10, 1);
				will(throwException(new IndexOutOfBoundsException("Invalid column index")));
				// Javadoc specifies invalid rows in the getValue function in Values2D
				// throws an IndexOutOfBoundsException.
				// Therefore this behaviour will be simulated with the mock.
			}
		});

		try {
			double result = DataUtilities.calculateRowTotal(mockData, -10);
			assertEquals(0.0, result, 0.0001);
		} catch (Exception e) {
			fail("Expected to return 0 but got a " + e.getClass().getSimpleName());
		}
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
