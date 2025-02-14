package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    private Range exampleRange5; 
    private Range exampleRange6; 
    private Range exampleRange7; 
    private Range exampleRange8; 
   

    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1); //Range variable for example test 
    	exampleRange2 = new Range(5.5, 10.5); // Range variable for tests 1, 2, 3, 4, 5
    	exampleRange3 = new Range(15.0, 25.0); // Range variable for tests 7, 8
    	exampleRange4 = new Range(10.0, 17.5); // Range variable for test 9
    	exampleRange5 = new Range(0.5, 35.0); // Range variable for test 9
    	exampleRange6 = new Range (-10.5, 5.5); // Range variable for test 10
        exampleRange7 = new Range(45.5, 75.5); // Range variable for test 10
        exampleRange8 = new Range (-10.5, 75.5); // Range variable for test 10
     
     

    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    // Test Case 1: Test method contains(double value) with the partition of value between lower and upper (within the range) 
    // The value tested is 0.1 larger than the value of lower in the range, therefore this is also testing a boundary condition of being within the range
    @Test
    public void testContains_ValueWithinRange() {
    	assertTrue("Value 5.6 should be within range", exampleRange2.contains(5.6));
    }
    
    // Test Case 2: Test method contains(double value) with the partition of value within the range, and value is equal to lower
    // This is testing a boundary condition where value is equal to lower 
    @Test
    public void testContains_ValueEqualtoLower() {
    	assertTrue("Value 5.5 should be within range", exampleRange2.contains(5.5));
    }
    
    // Test Case 3: Test method contains(double value) with the partition of value within the range, and value is equal to upper 
    // This is testing a boundary condition where value is equal to upper 
    @Test
    public void testContains_ValueEqualtoUpper() {
    	assertTrue("Value 10.5 should be within range", exampleRange2.contains(10.5));
    }
    
    // Test Case 4: Test method contains(double value) with the partition of value below range 
    // The value tested is 0.1 smaller than the value of lower in the range, therefore this is also testing a boundary condition of being below the range
    @Test
    public void testContains_ValueBelowRange() {
    	assertFalse("Value 5.4 should not be within range", exampleRange2.contains(5.4));
    }
    
    // Test Case 5: Test method contains(double value) with the partition of value above range
    // The value test is 0.1 larger than the value of upper in the range, therefore this is also testing a boundary condition of being above the range 
    @Test
    public void testContains_ValueAboveRange() {
    	assertFalse("Value 10.6 should not be within range", exampleRange2.contains(10.6));
    }
    
    // Test Case 6: Test method combine(Range range1, Range range2) for the partition in which range1 and range2 are both null
    @Test
    public void testCombine_BothRangesNull() {
    	assertNull("Combined range should be null since both ranges are null", Range.combine(null, null));
    }
    
    // Test Case 7: Test method combine(Range range1, Range range2) for the partition in which range1 is null and range2 is non-null 
    @Test
    public void testCombine_Range1NullRange2NonNull() {
    	assertEquals("Combined range should be equal to range2 since range1 is null", exampleRange3, Range.combine(null, exampleRange3));
    }
  
    
    // Test Case 8: Test method combine(Range range1, Range range2) for the partition in which range1 is non-null and range2 is null
    @Test
    public void testCombine_Range1NonNullRange2Null() {
    	assertEquals("Combined range should be equal to range1 since range2 is null", exampleRange3, Range.combine(exampleRange3, null));
    }
  
    
    // Test Case 9: Test method combine(Range range1, Range range2) for the partition in which range1 and range2 are both non-null 
    // This also tests a boundary condition where range1 is completely within range2
    @Test
    public void testCombine_Range1WithinRange2() {
    	assertEquals("Combined range should be equal to range2 since range 1 is within range2", exampleRange5, Range.combine(exampleRange4, exampleRange5));
    }
   
    
    // Test Case 10: Test method combine(Range range1, Range range2) for the partition in which range1 and range2 are both non-null
    // This also tests a boundary condition where and range1 and range2 do not overlap at all (upper of range1 is less than lower of range2) 
    @Test
    public void testCombine_Range1AndRange2DoNotOverlap() {
    	// This test originally resulted in an error due to an Illegal Argument Exception, therefore a try/catch was added to allow the test to gracefully fail 
    	try {
    		assertEquals("Combined range should subsume both ranges since they do not overlap", exampleRange8, Range.combine(exampleRange6, exampleRange7));
    	} catch (IllegalArgumentException e) {
    	fail("Exception should not be thrown, but Illegal Argument Exception was thrown: " + e.getMessage());
    	}	
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

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
