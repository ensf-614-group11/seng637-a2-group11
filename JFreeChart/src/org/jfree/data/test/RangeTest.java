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
    	exampleRange = new Range(-1, 1);
    	exampleRange2 = new Range(5.5, 10.5);
    	exampleRange3 = new Range(15.0, 25.0);
    	exampleRange4 = new Range(10.0, 17.5);
    	exampleRange5 = new Range(0.5, 35.0);
    	exampleRange6 = new Range (-10.5, 5.5);
        exampleRange7 = new Range(45.5, 75.5);
        exampleRange8 = new Range (-10.5, 75.5);
    
    }

 // Example Test from Section 2.1 of Lab 
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    // Test Case 1: Test method contains() with value between lower and upper (within the range) 
    @Test
    public void testContainsValueWithinRange() {
    	assertTrue("Value 5.6 should be within range", exampleRange2.contains(5.6));
    }
    
    // Test Case 2: Test method contains(double value) with value below range 
    // This also tests boundary condition of value = lower 
    @Test 
    public void testContainsValueBelowRange() {
    	assertFalse("Value 5.5 should not be within range", exampleRange2.contains(5.5));
    }
    
    // Test Case 3: Test method contains(double value) with value above range
    // This also tests boundary condition of value = upper 
    @Test
    public void testContainsValueAboveRange() {
    	assertFalse("Value 10.5 should not be within range", exampleRange2.contains(10.5));
    }
    
    // Test Case 4: Test method combine(Range range1, Range range2) with range1 and range2 null
    @Test
    public void testCombineBothRangesNull() {
    	assertNull("Combined range should be null", Range.combine(null, null));
    }
    
    // Test Case 5: Test method combine(Range range1, Range range2) with range1 null and range2 non-null 
    @Test
    public void testCombineRange1NullRange2NonNull() {
    	assertEquals(exampleRange3, Range.combine(null, exampleRange3));
    }
  
    
    // Test Case 6: Test method combine(Range range1, Range range2) with range1 non-null and range2 null
    @Test
    public void testCombineRange1NonNullRange2Null() {
    	assertEquals(exampleRange3, Range.combine(exampleRange3, null));
    }
  
    
    // Test Case 7: Test method combine(Range range1, Range range2) with range1 and range2 non-null 
    //and range1 is completely within range2
    @Test
    public void testCombineRange1WithinRange2() {
    	assertEquals(exampleRange5, Range.combine(exampleRange4, exampleRange5));
    }
   
    
    // Test Case 8: Test method combine(Range range1, Range range2) with range1 and range2 non-null
    // and range1 and range2 do not overlap 
    @Test
    public void testCombineRange1AndRange2DoNotOverlap() {
    	assertEquals(exampleRange8, Range.combine(exampleRange6, exampleRange7));
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
