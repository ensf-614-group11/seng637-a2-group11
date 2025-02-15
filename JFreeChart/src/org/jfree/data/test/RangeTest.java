package org.jfree.data.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.ranges.Range;

public class RangeTest {
    private Range exampleRange;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    private Range exampleRange5; 
    private Range exampleRange6; 
    private Range exampleRange7; 
    private Range exampleRange8;
    private Range exampleRange9;
    private Range exampleRange10;
    private Range exampleRange11;  
    private Range exampleRange12; 
    private Range exampleRange13; 
    private Range exampleRange14; 
    private Range exampleRange15; 
    private Range exampleRange16; 
    private Range exampleRange17; 
    private Range exampleRange18; 
    private Range exampleRange19; 
    private Range exampleRange20; 
    private Range exampleRange21;
    private Range exampleRange22;
    private Range exampleRange23;
    private Range exampleRange24;
    private Range exampleRange25;
    
    private Object exampleObject; 
   

    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1); //Range variable for example test from Section 2.1 of the Assignment Instructions 
    	exampleRange2 = new Range(5.5, 10.5); // Range variable for tests 1, 2, 3, 4, 5
    	exampleRange3 = new Range(15.0, 25.0); // Range variable for tests 7, 8
    	exampleRange4 = new Range(10.0, 17.5); // Range variable for test 9
    	exampleRange5 = new Range(0.5, 35.0); // Range variable for test 9
    	exampleRange6 = new Range (-10.5, 5.5); // Range variable for test 10
        exampleRange7 = new Range(45.5, 75.5); // Range variable for test 10
        exampleRange8 = new Range (-10.5, 75.5); // Range variable for test 10
        exampleRange9 = new Range(2.9, 6.1); // Range variable for test 11
        exampleRange10 = new Range(2.9, 5.1); // Range variable for tests 12, 13
        exampleRange11 = new Range(1.0, 3.0); // Range variable for test 14
        exampleRange12 = new Range(1.0, 4.0); // Range variable for tests 15, 16
        exampleRange13 = new Range(3.0, 3.0); // Range variable for test 17
        exampleRange14 = new Range(0.0, 0.0); // Range variable for tests 19, 20
        exampleRange15 = new Range(1.0, 1.0); // Range variable for test 19
        exampleRange16 = new Range(-1.0, -1.0); // Range variable for test 20
        exampleRange17 = new Range(1.0, 5.0); // Range variable for tests 21, 23, 24
        exampleRange18 = new Range(3.0, 7.0); // Range variable for test 21
        exampleRange19 = new Range(-7.0, -3.0); // Range variable for test 22
        exampleRange20 = new Range(0.0, 3.9);  // Range variable for test 23
        exampleRange21 = new Range(-0.1, 3.9); // Range variable for test 24
        exampleRange22 = new Range(-3.9, 0.0); // Range variable for test 25
        exampleRange23 = new Range(-3.9, 0.1); // Range variable for test 26
        exampleRange24 = new Range (0.0, 0.0); // Range variable for test 30
        exampleRange25 = new Range (Double.NaN, Double.NaN); // Range variable for test 35
        
        exampleObject = new Object();
    }

    // Example Test from Section 2.1 of the Assignment Instructions 
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    // Test Case 1: Test method contains(double value) with the partition of value between lower and upper (within the range) 
    // The value tested is 0.1 larger than the value of lower in the range, therefore this is also testing a boundary condition of being within the range
    @Test
    public void testContains_ValueWithinRange() {
    	assertTrue("Value 5.6 should be within (5.5, 10.5)", exampleRange2.contains(5.6));
    }
    
    // Test Case 2: Test method contains(double value) with the partition of value within the range, and value is equal to lower
    // This is testing a boundary condition where value is equal to lower 
    @Test
    public void testContains_ValueEqualtoLower() {
    	assertTrue("Value 5.5 should be within (5.5, 10.5)", exampleRange2.contains(5.5));
    }
    
    // Test Case 3: Test method contains(double value) with the partition of value within the range, and value is equal to upper 
    // This is testing a boundary condition where value is equal to upper 
    @Test
    public void testContains_ValueEqualtoUpper() {
    	assertTrue("Value 10.5 should be within (5.5, 10.5)", exampleRange2.contains(10.5));
    }
    
    // Test Case 4: Test method contains(double value) with the partition of value below range 
    // The value tested is 0.1 smaller than the value of lower in the range, therefore this is also testing a boundary condition of being below the range
    @Test
    public void testContains_ValueBelowRange() {
    	assertFalse("Value 5.4 should not be within (5.5, 10.5)", exampleRange2.contains(5.4));
    }
    
    // Test Case 5: Test method contains(double value) with the partition of value above range
    // The value test is 0.1 larger than the value of upper in the range, therefore this is also testing a boundary condition of being above the range 
    @Test
    public void testContains_ValueAboveRange() {
    	assertFalse("Value 10.6 should not be within (5.5, 10.5)", exampleRange2.contains(10.6));
    }
    
    // Test Case 6: Test method combine(Range range1, Range range2) for the partition in which range1 and range2 are both null
    @Test
    public void testCombine_BothRangesNull() {
    	assertNull("Combined range of null and null should be null", Range.combine(null, null));
    }
    
    // Test Case 7: Test method combine(Range range1, Range range2) for the partition in which range1 is null and range2 is non-null 
    @Test
    public void testCombine_Range1NullRange2NonNull() {
    	assertEquals("Combined range of (15.0, 25.0) and null should be equal to (15.0, 25.0)", exampleRange3, Range.combine(null, exampleRange3));
    }
  
    
    // Test Case 8: Test method combine(Range range1, Range range2) for the partition in which range1 is non-null and range2 is null
    @Test
    public void testCombine_Range1NonNullRange2Null() {
    	assertEquals("Combined range of null and (15.0, 25.0) should be equal to (15.0, 25.0)", exampleRange3, Range.combine(exampleRange3, null));
    }
  
    
    // Test Case 9: Test method combine(Range range1, Range range2) for the partition in which range1 and range2 are both non-null 
    // This also tests a boundary condition where range1 is completely within range2
    @Test
    public void testCombine_Range1WithinRange2() {
    	assertEquals("Combined range of (0.5, 35.0) and (10.0, 17.5) should be equal to (0.5, 35.0)", exampleRange5, Range.combine(exampleRange4, exampleRange5));
    }
   
    
    // Test Case 10: Test method combine(Range range1, Range range2) for the partition in which range1 and range2 are both non-null
    // This also tests a boundary condition where and range1 and range2 do not overlap at all (upper of range1 is less than lower of range2) 
    @Test
    public void testCombine_Range1AndRange2DoNotOverlap() {
    	// This test originally resulted in an error due to an Illegal Argument Exception, therefore a try/catch was added to allow the test to gracefully fail 
    	try {
    		assertEquals("Combined range of (-10.5, 5.5) and (45.5, 75.5) should be (-10.5, 75.5)", exampleRange8, Range.combine(exampleRange6, exampleRange7));
    	} catch (IllegalArgumentException e) {
    	fail("Exception should not be thrown, but Illegal Argument Exception was thrown: " + e.getMessage());
    	}	
    }
    
    // ================== intersects Method Tests ==================

    // Test Case 11: Test method intersects(double lower, double upper) for the partition where lower > upper
    // This tests the boundary condition where lower must be <= upper, and an exception is expected
	@Test
	public void testIntersects_LowerGreaterThanUpper() {
	    try {
	        exampleRange9.intersects(5.0, 3.0); 
	        fail("Expected IllegalArgumentException but no exception was thrown.");
	    } catch (IllegalArgumentException e) {
	        assertEquals("Lower bound must be less than or equal to upper bound.", e.getMessage()); 
	    } catch (Exception e) {
	        fail("Expected IllegalArgumentException but got " + e.getClass().getSimpleName());
	        }
	    }
    
	 // Test Case 12: Test method intersects(double lower, double upper) for the partition where there is full overlap
	 // This tests the condition where the specified range fully overlaps with the range object
	 @Test
	 public void testIntersects_FullOverlap() {
	     assertTrue("The range (2.9, 5.1) should fully overlap with (3.0, 5.0)",
	                exampleRange10.intersects(3.0, 5.0));
	 }
	
	 // Test Case 13: Test method intersects(double lower, double upper) for the partition where there is partial overlap
	 // This tests the condition where the specified range partially overlaps with the range object
	 @Test
	 public void testIntersects_PartialOverlap() {
	     assertTrue("The range (2.9, 5.1) should partially overlap with (3.0, 5.0)",
	                exampleRange10.intersects(3.0, 5.0));
	 }
	
	 // Test Case 14: Test method intersects(double lower, double upper) for the partition where there is no overlap
	 // This tests the condition where the specified range does not overlap with the range object
	 @Test
	 public void testIntersects_NoOverlap() {
	     assertFalse("The range (1.0, 3.0) should not overlap with (3.1, 5.0)",
	                 exampleRange11.intersects(3.1, 5.0));
	 }
	
	 // Test Case 15: Test method intersects(double lower, double upper) for the partition where the lower boundary touches
	 // This tests the boundary condition where the lower bound of the specified range touches the upper bound of the range object
	 @Test
	 public void testIntersects_TouchingLowerBoundary() {
	     assertTrue("The range (1.0, 4.0) should touch the lower boundary of (4.0, 6.0)",
	                exampleRange12.intersects(4.0, 6.0));
	 }
	
	 // Test Case 16: Test method intersects(double lower, double upper) for the partition where the upper boundary touches
	 // This tests the boundary condition where the upper bound of the specified range touches the lower bound of the range object
	 @Test
	 public void testIntersects_TouchingUpperBoundary() {
	     assertTrue("The range (1.0, 4.0) should touch the upper boundary of (0.0, 1.0)",
	                exampleRange12.intersects(0.0, 1.0));
	 }
	
	 // Test Case 17: Test method intersects(double lower, double upper) for the partition where both ranges are a single point
	 // This tests the condition where both the range object and the specified range are single-point ranges
	 @Test
	 public void testIntersects_RangeEqualToPoint() {
	     assertTrue("The range (3.0, 3.0) should intersect with (3.0, 3.0)",
	                exampleRange13.intersects(3.0, 3.0));
	 }
	
	 // ================== shift Method Tests ==================
	
	// Test Case 18: Test method shift(Range base, double delta, boolean allowZeroCrossing) for the partition where base is null
	    @Test
	    public void testShift_RangeWithNaN() {
	        Range nanRange = new Range(Double.NaN, 5.0);
	        Range shiftedRange = Range.shift(nanRange, 1.0, true);
	        assertTrue("Shifted range should contain NaN",
	                Double.isNaN(shiftedRange.getLowerBound()));
	    }
	    
	    // Test Case 19: Test method shift(Range base, double delta, boolean allowZeroCrossing) for the partition where the base range is a zero-length range and delta is positive
	    @Test
	    public void testShift_ZeroRangePositiveDelta() {
	        Range shiftedRange = Range.shift(exampleRange14, 1.0, false);
	        assertEquals("The shifted range of (0.0, 0.0) with delta 1.0 should be (1.0, 1.0)",
	                exampleRange15, shiftedRange);
	    }
	    
	    // Test Case 20: Test method shift(Range base, double delta, boolean allowZeroCrossing) for the partition where the base range is a zero-length range and delta is negative
	    @Test
	    public void testShift_ZeroRangeNegativeDelta() {
	        Range shiftedRange = Range.shift(exampleRange14, -1.0, false);
	        assertEquals("The shifted range of (0.0, 0.0) with delta -1.0 should be (-1.0, -1.0)",
	                exampleRange16, shiftedRange);
	    }
	    
	    // Test Case 21: Test method shift(Range base, double delta, boolean allowZeroCrossing) for the partition where the base range is fully positive and delta is positive
	    @Test
	    public void testShift_PositiveRangePositiveDelta() {
	        Range shiftedRange = Range.shift(exampleRange17, 2.0, true);
	        assertEquals("The shifted range of (1.0, 5.0) with delta 2.0 should be (3.0, 7.0)",
	                exampleRange18, shiftedRange);
	    }
	    
	    // Test Case 22: Test method shift(Range base, double delta, boolean allowZeroCrossing) for the partition where the base range is fully negative and delta is negative
	    @Test
	    public void testShift_NegativeRangeNegativeDelta() {
	        Range shiftedRange = Range.shift(exampleRange16, -2.0, true);
	        assertEquals("The shifted range of (-5.0, -1.0) with delta -2.0 should be (-7.0, -3.0)",
	                exampleRange19, shiftedRange);
	    }
	    
	    // Test Case 23: Test method shift(Range base, double delta, boolean allowZeroCrossing) for the partition where the base range is positive and delta causes the lower bound to cross zero
	    @Test
	    public void testShift_PositiveRangeCrossZeroLower() {
	        Range shiftedRange = Range.shift(exampleRange17, -1.1, false);
	        assertEquals("The shifted range of (1.0, 5.0) with delta -1.1 should be (0.0, 3.9)",
	                exampleRange20, shiftedRange);
	    }
	    
	    // Test Case 24: Test method shift(Range base, double delta, boolean allowZeroCrossing) for the partition where the base range is positive and delta causes the lower bound to cross zero (zero crossing allowed)
	    @Test
	    public void testShift_PositiveRangeCrossZeroLowerAllowed() {
	        Range shiftedRange = Range.shift(exampleRange17, -1.1, true);
	        assertEquals("The shifted range of (1.0, 5.0) with delta -1.1 should be (-0.1, 3.9)",
	                exampleRange21, shiftedRange);
	    }
	    
	    // Test Case 25: Test method shift(Range base, double delta, boolean allowZeroCrossing) for the partition where the base range is negative and delta causes the upper bound to cross zero
	    @Test
	    public void testShift_NegativeRangeCrossZeroUpper() {
	        Range shiftedRange = Range.shift(exampleRange16, 1.1, false);
	        assertEquals("The shifted range of (-5.0, -1.0) with delta 1.1 should be (-3.9, 0.0)",
	                exampleRange22, shiftedRange);
	    }
	    
	    // Test Case 26: Test method shift(Range base, double delta, boolean allowZeroCrossing) for the partition where the base range is negative and delta causes the upper bound to cross zero (zero crossing allowed)
	    @Test
	    public void testShift_NegativeRangeCrossZeroUpperAllowed() {
	        Range shiftedRange = Range.shift(exampleRange16, 1.1, true);
	        assertEquals("The shifted range of (-5.0, -1.0) with delta 1.1 should be (-3.9, 0.1)",
	                exampleRange23, shiftedRange);
	    }
	
	    // ================== equals Method Tests ==================
	    
	    // Test Case 29: Test method equals(Object obj) for the partition where the input is a range but not equivalent
	    @Test
	    public void testEquals_NotEquivalentRange() {
	        assertFalse("The range (0.0, 0.0) should not be equal to (1.0, 5.0)",
	                exampleRange14.equals(exampleRange17));
	    }
	    
	    // Test Case 30: Test method equals(Object obj) for the partition where the input is an equivalent range
	    @Test
	    public void testEquals_EquivalentRange() {
	        assertTrue("The range (0.0, 0.0) should be equal to (0.0, 0.0)",
	                exampleRange14.equals(exampleRange24));
	    }
	    
	    // Test Case 31: Test method equals(Object obj) for the partition where the input is the same instance
	    @Test
	    public void testEquals_Itself() {
	        assertTrue("The range (0.0, 0.0) should be equal to itself",
	                exampleRange14.equals(exampleRange14));
	    }
	    
	    // Test Case 32: Test method equals(Object obj) for the partition where the input is null
	    @Test
	    public void testEquals_NullRange() {
	        assertFalse("The range (0.0, 0.0) should not be equal to null",
	                exampleRange14.equals(null));
	    }
	    
	    // Test Case 33: Test method equals(Object obj) for the partition where the input is not a range object
	    @Test
	    public void testEquals_NotARangeObject() {
	        assertFalse("The range (0.0, 0.0) should not be equal to an arbitrary object",
	                exampleRange14.equals(exampleObject));
	    }
	    
	    // Test Case 35: Test method equals(Object obj) for the partition where the range contains NaN values
	    @Test
	    public void testEquals_RangeWithNaNValues() {
	        assertTrue("The range (NaN, NaN) should be equal to (NaN, NaN)",
	                exampleRange25.equals(new Range(Double.NaN, Double.NaN)));
	    }
    

    @After
    public void tearDown() throws Exception {
    	exampleRange = null;
    	exampleRange2 = null;
    	exampleRange3 = null;
    	exampleRange4 = null;
    	exampleRange5 = null;
    	exampleRange6 = null;
        exampleRange7 = null;
        exampleRange8 = null;
        exampleRange9 = null;
        exampleRange10 = null;
        exampleRange11 = null;
        exampleRange12 = null;
        exampleRange13 = null;
        exampleRange14 = null;
        exampleRange15 = null;
        exampleRange16 = null;
        exampleRange17 = null;
        exampleRange18 = null;
        exampleRange19 = null;
        exampleRange20 = null;
        exampleRange21 = null;
        exampleRange22 = null;
        exampleRange23 = null;
        exampleRange24 = null;
        exampleRange25 = null;
        
        exampleObject = null;

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
