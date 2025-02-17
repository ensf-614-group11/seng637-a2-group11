**SENG 637 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:      |   11  |
| -------------- | --- |
| Student Names: |     |
|Steven Au       |     |
|Laurel Flanagan |     |
|Rhys Wickens    |     |
|Austen Zhang    |     |

# 1 Introduction

Text…

# 2 Test Plan 
The system under test is JFreeChart, an open-source Java framework for creating and displaying charts, including pie charts, 
bar charts, line charts, and histograms. The purpose of the test plan is to provide an overview of the testing approach for 
the JFreeChart system, including the test types, scope of testing, and test logistics. 

## Test Types 
The test approach consists of the following test type: 
- Criteria-based unit testing 

## Scope of Testing 
The JFreeChart framework incudes two main packages, org.jfree.chart and org.jfree.data. The scope of testing is focused on the 
org.jfree.data package. Test cases will be created for all 5 methods of the org.jfree.data.DataUtilities class and 5 of the 15 methods 
from the org.jfree.data.Range class. 

The methods to be tested include: 
- DataUtilities class methods:
    - calculateColumnTotal 
    - calculateRowTotal
    - createNumberArray
    - createNumberArray2D
    - getCumulativePercentages
- Range class methods: 
    - contains
    - combine
    - intersects
    - shift
    - equals 
    
The test scope is focused on functional testing, checking to see if the system functionality matches the requirements outlined in the 
Javadoc provided for the JFreeChart system. The testing included in the plan is black box testing, checking the system functionality 
based on the Javadoc specifications/requirements, not referencing the implementation of the system code. 
 
The testing approach to be used for the criteria-based unit testing is partitioning, including equivalence class partitioning and 
boundary value analysis techniques. Weak equivalence class testing will be used as the minimum number of test cases to ensure that the 
number of test cases are manageable, and focus is placed on the quality of partitioning of the variables. Some cases may also be included 
for robustness criteria, which will be determined on an as needed basis for each method. After test cases are designed using 
partitioning, automated execution of the unit testing will be carried out using JUnit.

## Test Logistics
Testing can begin after all team members have completed section 2.1 of the lab instructions (familiarization with the system), the 
Eclipse Java project has been set up with JAR files required to run the system, and the test plan has been developed including design of 
all test cases. 

The methods included in the scope to be tested will be divided among the team members. Steven Au and Laurel Flanagan will design test 
cases and write unit test code for 5 of the Range class methods. Rhys Wickens and Austen Zhang will design test cases and write unit 
test code for 5 of the DataUtilities class methods. 
  
All team members will design their test cases first based on equivalence class partitioning and boundary value analysis. The team members 
will review the test cases in pairs to ensure all members are satisfied with the test coverage and quality (each team member designing 
test cases for the Range class methods will review the test cases designed by the other team member, and each team member designing 
test cases for the Utilities class methods will review the test cases designed by the other team member). Team members will then 
develop code for their assigned test cases. The team will also review the JUnit test suite code in pairs as a quality check. The team 
will then run the test suite and review the results. 
 
## Test Environment 
The test environment consists of an Eclipse Java Project with the JUnit framework and JAR files for JFreeChart provided in the Assignment 
2 artifacts folder. 

## Test Tasks and Schedule 
Tasks required to complete the test plan and the estimated schedule for completion of these tasks is provided in the table below. 

Table 1: Testing Schedule 
| Task                                                       | Completion Date   |
|------------------------------------------------------------|-------------------|
| Complete Section 2.1 of Lab Instructions – Familiarization  | February 6, 2025  |
| Select Methods for Testing and Review Javadoc Specifications| February 7, 2025  |
| Develop Test Plan and Design Test Cases                    | February 8, 2025  |
| Team Review of Test Cases                                  | February 9, 2025  |
| Develop Unit Test Code in JUnit framework                  | February 11, 2025 |
| Team Review of Unit Test Code                              | February 12, 2025 |
| Review JUnit Test Suite Results                            | February 13, 2025 |
| Reporting                                                  | February 17, 2025 |

## Test Deliverables
The before testing phase deliverables include:
 - Test plan 
 - Test cases
 
 The during testing phase deliverables include:
 - Unit test code in JUnit for test cases 
 - Error logs and messages from the system 
 
 The after testing deliverables include: 
 - JUnit test suite results 
 - Lab Report  

# 3 Detailed description of unit test strategy
## Test Case Design 
As mentioned previously, the test case design includes equivalence class partitioning and boundary value analysis techniques. The 
following points provide a general outline for the design procedure for the test cases. A review of each of these points is completed in 
the subsections below for each method included in the testing scope.   

- Number of independent variables
- Number of equivalence classes/partitions for each variable 
- Number of test cases based on weak equivalence testing
- Select tests at or near boundary values of equivalence classes 
- Consideration for robustness criteria 
- Review test cases and remove redundancies 

### DataUtilities Class Methods 
#### calculateColumnTotal 
The `calculateColumnTotal` method returns a double that corresponds to the sum of a particular column in a Values2D data object. The 
arguments in this method are the Values2D data object and an int value corresponding to the column number.

- Number of independent variables
    - This method has two independent variables: the `Values2D` data object and the integer corresponding to the column index.

- Number of equivalence classes/partitions for each variable
    - Data
        - There will be two partitions considered for this object: Valid data object and invalid data object (i.e., reference is a null pointer).
    - Column
        - There are two partitions: Valid and invalid integer.

- Number of test cases based on weak equivalence testing
    - The maximum number of partitions between the two variables is two. Therefore, two test cases will be used for weak equivalence testing.

- Select tests at or near boundary values of equivalence classes
  - There are no boundary values for either variable in this method.

- Consideration for robustness criteria
  - Since one of the two column partitions is for invalid inputs, robustness will be tested when we enter an invalid column index.

- Review test cases and remove redundancies
  - Test case 2 and 4 can be combined together due to having the same output. This makes 3 test cases total. Although based on weak equivalence, 
we would only use two test cases, the decision table shows 3 different outputs, so three test cases will be performed to test all 3 different 
outputs.
  
| Conditions        | Case 1                                      | Case 2                | Case 3              | Case 4                |
|-------------------|---------------------------------------------|-----------------------|---------------------|-----------------------|
| Values2D data     | Data is an array of primitive double values | Data is null          | Data is an array of primitive double values | Data is null          |
| Column            | Column is a valid integer                   | Column is valid integer| Column is invalid integer | Column is an invalid integer |
| Expected Output   | Sum of double values corresponding to column index | InvalidParameterException | 0                   | InvalidParameterException |

#### calculateRowTotal 
The `calculateRowTotal` method returns a double that corresponds to the sum of a particular row of values in a `Values2D` data object. The arguments in this method are the `Values2D` data object and an int value corresponding to the row number.

- Number of independent variables
  - This method has two independent variables: the `Values2D` data object and the integer corresponding to the row index.

- Number of equivalence classes/partitions for each variable
  - Data
    - There will be two partitions considered for this object: Valid data object and invalid data object (i.e., reference is a null pointer).
  - Row
    - There are two partitions: Valid and invalid integer.

- Number of test cases based on weak equivalence testing
  - The maximum number of partitions between the two variables is two. Therefore, two test cases will be used for weak equivalence testing.

- Select tests at or near boundary values of equivalence classes
  - There are no boundary values for either variable in this method.

- Consideration for robustness criteria
  - Since one of the two row partitions is for invalid inputs, robustness will be tested when we enter an invalid row index.

- Review test cases and remove redundancies
  - Test case 2 and 4 can be combined together due to having the same output. This makes 3 test cases total. Although based on weak equivalence, we would only use two test cases, the decision table shows 3 different outputs, so three test cases will be performed to test all 3 different outputs.
  
| Conditions        | Case 1                                      | Case 2                | Case 3              | Case 4                |
|-------------------|---------------------------------------------|-----------------------|---------------------|-----------------------|
| Values2D data     | Data is an array of primitive double values | Data is null          | Data is an array of primitive double values | Data is null          |
| Row               | Row is a valid integer                      | Row is valid integer  | Row is invalid integer | Row is an invalid integer |
| Expected Output   | Sum of double values corresponding to row index | InvalidParameterException | 0                   | InvalidParameterException |

#### createNumberArray 
The method `createNumberArray(double[] data)` constructs an array of `Number` objects from an array of double primitives.

- Number of independent variables
  - There is one input variable, the method parameter `data`. This is an array of double primitives. Null is not permitted in this input variable (i.e. throughout the entire array).

- Number of equivalence classes/partitions for each variable:
  - There is just one partition for the `data` variable:
    - `data` is an array of double primitives.

- Number of test cases based on weak equivalence testing:
  - The number of test cases is max | 1 | = 1 since there is only one independent variable.

- Select tests at or near boundary values of equivalence classes:
  - The test case in which the data has a null input.
  - The test case when the data is an empty array.
  - The test case when the data has just a single element.
  - The test case in which the data includes extremely large or small values (i.e. `data = {Double.MAX_VALUE, Double.MIN_VALUE}`).

- Consideration for robustness criteria
  - The above cases include robustness criteria since the function specifies that the data array must be an array of double primitives. The tests at or near boundary values above ensure that the robustness criteria are met because they are test cases where the data array is not a regular array of double primitives.

- Review test cases and remove redundancies

| Case  | Data                                      | Outcome                                       |
|-------|------------------------------------------|----------------------------------------------|
| 1     | Data is an array of primitive doubles   | Array of Number objects                     |
| 2     | Data has just a single element          | Array of Number objects with just a single element |
| 3     | Data is an empty array                  | Empty array                                 |
| 4     | Data has a null input                   | Throws InvalidParameterException           |
| 5     | Data is extremely large or small        | Array of Number objects with extremely large of small values |


- In the above table, I will start with writing two tests for case 1. The first test will be checking if the outcome does not have any null values for the length of the array. The next test is to check that the values are Number objects of the equivalent value as the input. I will then write a test for the remaining test cases, for a total of 6 test cases.
- The following are the test cases that will be written for this function:
    - testCreateNumberArray_ElementsNotNull
    - testCreateNumberArray_ValuesEqual
    - testCreateNumberArray_SingleElement
    - testCreateNumberArray_EmptyArray
    - testCreateNumberArray_NullInput
    - testCreateNumberArray_LargeSmallValues
  
#### createNumberArray2D 
The method `createNumberArray2D(double[][] data)` constructs an array of arrays of `Number` objects from a corresponding structure containing double primitives.

- Number of independent variables
    - There is one input variable, the method parameter `data`. This is an array of arrays of double primitives. Null is not permitted in this input variable (i.e. throughout the entire array).

- Number of equivalence classes/partitions for each variable:
  - There is just one partition for the `data` variable:
    - `data` is an array of arrays of double primitives.

- Number of test cases based on weak equivalence testing:
  - The number of test cases is max | 1 | = 1 since there is only one independent variable.

- Select tests at or near boundary values of equivalence classes:
  - The test case in which the data has a null input.
  - The test case when the data is an empty array of empty arrays.
  - The test case when the data has just a single element
  - The test case in which the data includes extremely large or small values (i.e. `data = {Double.MAX_VALUE, Double.MIN_VALUE}`).

- Consideration for robustness criteria
  - The above cases include robustness criteria since the function specifies that the data array must be an array of arrays of double primitives. The tests at or near boundary values above ensure that the robustness criteria are met because they are test cases where the data array is not an array of arrays of double primitives.

- Review test cases and remove redundancies

| Case  | Data                                          | Outcome                                              |
|-------|----------------------------------------------|------------------------------------------------------|
| 1     | Data is an array of arrays of primitive doubles | Array of arrays of Number objects                   |
| 2     | Data has just a single element in a 2D array  | Array of arrays of Number objects with just a single element |
| 3     | Data is an empty 2D array                     | Empty 2D array                                      |
| 4     | Data has a null input                         | Throws InvalidParameterException                    |
| 5     | Data contains extremely large or small values | Array of arrays of Number objects with extremely large of small values |


- In the above table, I will start with writing two tests for case 1. The first test will be checking if the outcome does not have any null values for the length of the array or arrays. The next test is to check that the values are Number objects of the equivalent value as the input. I will then write a test for the remaining test cases, for a total of 6 test cases.
- The following are the test cases that will be written for this function:
    - testCreateNumberArray2D_ElementsNotNull
    - testCreateNumberArray2D_ValuesEqual
    - testCreateNumberArray2D_SingleElement
    - testCreateNumberArray2D_EmptyArray
    - testCreateNumberArray2D_NullInput
    - testCreateNumberArray2D_LargeSmallValues

#### getCumulativePercentages 
This method `getCumulativePercentages(KeyedValues data)` returns a `KeyedValues` instance that contains the cumulative percentage values for the data in another `KeyedValues` instance. The cumulative percentage is each value's cumulative sum’s portion of the sum of all the values.

- Number of independent variables:
  - There is one input variable, the method parameter `data`. This is a `KeyedValues` instance containing key-value pairs.

- Number of equivalence classes/partitions for each variable:
  - There is just one partition for the `data` variable:
    - `data` is a `KeyedValues` instance containing key-value pairs.

- Number of test cases based on weak equivalence testing:
  - The number of test cases is max | 1 | = 1 since there is only one independent variable.

- Select tests at or near boundary values of equivalence classes:
  - The test case where the data is null.
  - The test case with an empty dataset (i.e. empty key-value pair).
  - The test case where one of the values in the key-value pairs is 0.
  - The test case where one or more of the values in the key-value pairs is negative.
  - The test case where the values are floating point numbers.

- Consideration for robustness criteria:
  - The above cases include robustness criteria since the function specifies that the data must be a `KeyedValues` instance. The tests at or near boundary values above ensure that the robustness criteria are met because they are test cases where the data array is not a regular `KeyedValues` instance.

- Review test cases and remove redundancies

| Case | Data                                              | Outcome                                                   |
|------|---------------------------------------------------|-----------------------------------------------------------|
| 1    | Data is a regular `KeyedValues` instance         | `KeyedValues` instance that contains correct cumulative percentages |
| 2    | Data contains a value that is `0`                | `KeyedValues` instance that contains correct cumulative percentages |
| 3    | Data contains a negative value                   | `KeyedValues` instance that contains correct cumulative percentages |
| 4    | Data contains a floating point number            | `KeyedValues` instance that contains correct cumulative percentages |
| 5    | Data contains a `null` value                     | Throws `InvalidParameterException`                        |
| 6    | Data is an empty `KeyedValues` instance          | Empty `KeyedValues` instance                              |

- In the above table, case 1 will be the first test case. Case 2-4 will then be another test case where we test an array with a 0, negative number, and a floating point. Case 5 and 6 will then each have their own test case. Thus, there will be a total of 4 test cases
- The following are the test cases that will be written for this function:
    - testGetCumulativePercentages_ValidData
    - testGetCumulativePercentages_ZeroNegativeAndFloatingValues
    - testGetCumulativePercentages_NullInput
    - testGetCumulativePercentages_EmptyKeyValues
    
### Range Class Methods 
#### contains
The method `public boolean contains(double value)` returns `true` if the specified value is within the range and `false` otherwise. The 
parameter `value` is the value to be tested. The boolean returned is `true` if the range object the method is called on contains the 
specified value. A range class object consists of two parameters: `lower` and `upper`. Therefore, the return will be `true` if the 
value is between `lower` and `upper`, or equal to `lower` or `upper`.

- Number of independent variables:
  - There is one independent variable, the method parameter `value`.

- Number of equivalence classes/partitions for each variable:
  - There are three partitions for the `value` variable:
    - `value` is below `lower` (not within the range)
    - `value` is above `upper` (not within the range)
    - `value` is between `lower` and `upper` (within the range)

- Number of test cases based on weak equivalence testing:
  - The number of test cases required for weak equivalence is max | 3 | = 3 since there is only one independent variable.

- Select tests at or near boundary values of equivalence classes:
  - The test cases in which `value` equals `lower`, and `value` equals `upper` represent boundary conditions.
  - The test cases for `value` below `lower`, and `value` above `upper` could be tested with the following to reflect boundary conditions:
    - `value = lower - 0.1`
    - `value = upper + 0.1`
  - The test case for `value` between `lower` and `upper` could be tested with one of the following conditions to reflect a boundary condition and maximize the potential for identifying an error:
    - `value = lower + 0.1`
    - `value = upper - 0.1`

- Consideration for robustness criteria:
  - The above cases include robustness criteria since `value` being out of the range is tested for multiple conditions including above `upper`, below `lower`, and equal to `upper` or `lower`.

- Review test cases and remove redundancies

| Conditions                                      | Case 1                             | Case 2         | Case 3                           | Case 4                          | Case 5         | Case 6         |
|-------------------------------------------------|------------------------------------|----------------|----------------------------------|---------------------------------|----------------|----------------|
| value                                           | value is below lower (lower – 0.1) | value equals lower | value is between lower and upper (lower + 0.1) | value is between lower and upper (upper – 0.1) | value equals upper | value is above upper (upper + 0.1) |
| Outcome                                          | false                              | true           | true                             | true                            | true           | false          |

- In the table above, Case 2, Case 3, Case 4 and Case 5 could all be combined, given that these cases have the same outcome and are testing the same partition. However, to include robustness and have good coverage for testing of boundary conditions, both Case 2 and Case 5 will be included in the test suite and only Case 3 and Case 4 will be consolidated to remove redundancy. 

#### combine 
The method `public static Range combine(Range range1, Range range2)` returns a new range subsuming both input ranges. The parameters `range1` and `range2` are the values to be tested. If one of either `range1` or `range2` is null, the other range will be returned. If they are both null, the return will be null.

- Number of independent variables:
  - There are two input variables, the method parameters `range1` and `range2`. These input pairs are dependent on each other to determine the output of the method; therefore, they act as one pair of inputs (one independent variable).

- Number of equivalence classes/partitions for each variable:
  - There are two partitions for the `range1` variable:
    - `range1` is null
    - `range1` is non-null
  - There are two partitions for the `range2` variable:
    - `range2` is null
    - `range2` is non-null
  - This results in four partitions for the input variables `range1` and `range2` together:
    - `range1` is null and `range2` is null
    - `range1` is non-null and `range2` is null
    - `range1` is null and `range2` is non-null
    - `range1` is non-null and `range2` is non-null

- Number of test cases based on weak equivalence testing:
  - The number of test cases is max | 4 | = 4

- Select tests at or near boundary values of equivalence classes:
  - In the case where both `range1` and `range2` are non-null, there are several boundary conditions that could be tested:
    - Condition 1: One range is fully contained within the second range. In this case, the result should be the larger range.
    - Condition 2: The upper bound of one range is the same as the lower bound of the second range. The ranges should be combined to form a single range with the lower bound of the first range and the upper bound of the second range.
    - Condition 3: The two ranges are the same. In this case, the result should be the same range.
    - Condition 4: The two ranges overlap. The ranges should be combined into one range.
    - Condition 5: The ranges do not overlap. The ranges should be combined so the result includes the lower bound of the lower range and the upper bound of the upper range.

- Consideration for robustness criteria:
  - There are five possible cases that could represent boundary conditions within the one equivalence class of `range1` and `range2` both being non-null. It may not be necessary to test all these conditions, since some of them are very similar and have the same outcomes. The cases are reviewed in the table below to determine which redundancies can be removed and decide on the number of test cases.

- Review test cases and remove redundancies

| Conditions | Case 1 | Case 2 | Case 3 | Case 4 | Case 5 | Case 6 | Case 7 | Case 8 |
|------------|--------|--------|--------|--------|--------|--------|--------|--------|
| range1     | null   | null   | non-null | non-null | non-null | non-null | non-null | non-null |
| range2     | null   | non-null | null   | non-null | non-null | non-null | non-null | non-null |
| other      | -      | -      | -      | range1 is within range2 | upper of range1 = lower of range2 | range1 = range2 | upper of range1 > lower of range2 | upper of range1 < lower of range2 |
| Outcome    | null   | range2 | range1 | range2 | combined range | range2 | combined range | combined range |

- In the table above, Case 4 and 6 could be combined, and Case 5, 7, and 8 could be combined, given that these cases have essentially the 
same outcomes. By including one test case from each of these groups, there will be 2 test cases for the equivalence class of both range1 
and range2 being non-null, which exceeds the weak equivalence testing criteria and includes some boundary values. This results in a 
total of 5 test cases. 

#### intersects 
The method `public bool intersects(double lower, double upper)` is the method for the `Range` class which checks to see if the range intersects with the provided range.

- Number of independent variables:
    - There are two input variables: `double lower` and `double upper`.

- Number of equivalence classes/partitions for each variable:
    - For the `lower` variable:
        - Valid: `lower` is < upper bound
        - Valid: `lower` is = lower bound
        - Invalid: `lower` is > upper bound
    - For the `upper` variable:
        - Valid: `upper` is > lower bound
        - Valid: `upper` is = lower bound
        - Invalid: `upper` is < lower bound
    - This results in three partitions for the input variables `double lower` and `double upper`:
        - If `upper` is >= `lower`, the reverse is also true, meaning `lower` is <= `upper`
        - If `lower` is > `upper`, the reverse is also true, meaning `upper` is < `lower`

- Number of test cases based on weak equivalence testing:
    - The number of test cases is `max | 3, 3 | = 3`

- Select tests at or near boundary values of equivalence classes:
    - Case when `lower` and `upper` are fully overlapping with the range object.
    - Case when ranges overlap partially.
    - Case when ranges do not overlap.
    - Case when ranges touch at a boundary. This happens when `upper` of the range being checked is equal to `lower`.

- Consideration for robustness criteria:
    - The cases which may be considered for robustness testing relate to handling the edge values for the `double` primitive type.
    - Check the case where both ranges are a point.

- Review test cases and remove redundancies.

| Condition                                       | Case 1                                           | Case 2                                       | Case 3                           | Case 4                               | Case 5                       |
|-------------------------------------------------|--------------------------------------------------|----------------------------------------------|----------------------------------|--------------------------------------|------------------------------|
| obj                                             | Case when lower and upper are fully overlapping with the range object | Case when ranges overlap partially           | Case when ranges do not overlap  | Case when ranges touch at a boundary | Case when both ranges are a point |
| outcome                                         | TRUE                                             | TRUE                                         | FALSE                            | TRUE                                 | TRUE                         |


### shift 
The method `public static Range shift(Range base, double delta, allowZeroCrossing = false)` returns a range the size of the input, shifted delta units to the right (positively). If `allowZeroCrossing` is false, any bound which crosses the zero mark after shifting from negative to positive, or positive to negative will become zero.

- Number of independent variables:
    - There are three input variables for the method `shift`: `base`, `delta`, and `allowZeroCrossing`.

- Number of equivalence classes/partitions for each variable:
    - For the `base` variable:
        - Valid:
            - base is a valid range
            - base is fully in the positive range
            - base is fully in the negative range
            - base is a range where upper = lower = 0
            - base is a range that overlaps 0 (spans negative and positive)
        - Invalid:
            - base cannot contain `Double.NaN`
            - base does not contain a range where lower > upper
    - For the `delta` variable:
        - delta is negative
        - delta is positive
        - delta is zero
    - For the `allowZeroCrossing` variable:
        - allowZeroCrossing is not specified (defaults to false behavior)
        - allowZeroCrossing is true
        - allowZeroCrossing is false

- Number of test cases based on weak equivalence testing:
    - The number of test cases is `max | 4, 3, 3 | = 4`

- Select tests at or near boundary values of equivalence classes:
    - Select tests where the behavior of the method changes. Specifically, we will want to test the behavior of the interaction between `delta` and the `base` range:
        - base fully in the positive domain, shifted delta units right
        - base fully in the negative domain, shifted delta units left
        - base fully in the negative domain, shifted delta units right, with a result that has only the upper crossing zero
        - base fully in the positive domain, shifted delta units left, with a result that has only the lower portion crossing zero
        - base fully in the positive domain, shifted delta units left, where both upper and lower cross zero
        - base fully in the negative domain, shifted delta units right, where both upper and lower cross zero

- Consideration for robustness criteria:
    - If the range is the maximum or minimum value for `double`, `shift` method should handle overflow.
    - There should be a test case to ensure that invalid ranges which contain `Double.NaN` are handled by throwing an `InvalidParameterException`.

- Review test cases and remove redundancies.

| Condition                                       | Case 1                  | Case 2                  | Case 3                  | Case 4                  | Case 5                               | Case 6                               | Case 7                               | Case 8                               | Case 9                               | Case 10                                     | Case 11                               | Case 12                                     |
|-------------------------------------------------|-------------------------|-------------------------|-------------------------|-------------------------|--------------------------------------|--------------------------------------|--------------------------------------|--------------------------------------|--------------------------------------|--------------------------------------------|--------------------------------------|--------------------------------------------|
| Base                                            | null                    | null                    | null                    | null                    | valid, base is (lower = upper) at (0,0) | valid, base is (lower = upper) at (0,0) | valid, all in positive domain        | valid, all in negative domain        | valid, all in positive domain          | valid, all in positive domain           | valid, all in negative domain            |
| Delta                                           | positive                | positive                | negative                | negative                | positive                             | negative                             | positive                             | negative                             | delta = -(lower + 0.1)                | delta = -(lower + 0.1)                    | delta = upper + 0.1                   |
| allowZeroCrossing                               | TRUE                    | FALSE                   | TRUE                    | FALSE                   | FALSE                                 | FALSE                                 | TRUE                                 | TRUE                                 | TRUE                                    | FALSE                                 | FALSE                                    |
| Outcome                                         | InvalidParameterException | InvalidParameterException | InvalidParameterException | InvalidParameterException | range shifted delta units right       | range shifted delta units left        | range shifted delta units right       | range shifted delta units left        | range shifted delta units left          | range shifted delta units left, with lower set to 0 | range shifted delta units right, with upper set to 0 |

- Cases 1, 2, 3, 4 can be covered with one test when base is null.
- Case 5-12 tests different permutations of values for base and delta which will change the behaviour of the method. These are a result of the relationship between the lower and upper of the range, the delta, and the specified setting for allowZeroCrossing. 

### equals 
The method `public boolean equals (java.lang.Object obj)` tests this object for equality with an arbitrary object `obj`. The parameter to be tested is the object of type `java.lang.Object`. The method returns `true` if the input object is an equivalent range.

- Number of independent variables: 
  - There is one input variable, the parameter, which is an object of type `java.lang.Object`.

- Number of equivalence classes/partitions for each variable:
  - There are four partitions for the `obj` variable:
    - `obj` is a range object with null values
    - `obj` is not a range object
    - `obj` is a range object but not equivalent
    - `obj` is a range object and equivalent

- Number of test cases based on weak equivalence testing: 
  - The number of test cases is `max | 4 | = 4`

- Select tests at or near boundary values of equivalence classes: 
  - There is a type boundary:
    - Object is a range object
    - Object is not a range object
    - Object is null

- Consideration for robustness criteria: 
  - The method should correctly handle the case where the input object is the same instance as the current object. The method should return `true` if this object is checked for equality.
  - The method should correctly handle objects which are derived from `Range`.
  - The method should correctly handle checking instances of `Range` which contain `NaN` values in the range.

- Review test cases and remove redundancies

| Condition     | Case 1                       | Case 2                    | Case 3   | Case 4     | Case 5              |
|---------------|------------------------------|---------------------------|----------|------------|---------------------|
| obj           | Range object but not equivalent | Range object but equivalent | Itself   | Null range | Not a range object  |
| outcome       | FALSE                        | TRUE                      | TRUE     | FALSE      | FALSE               |

- Each case relates to a different input object, resulting in one test for each partition. 

# 4 Test cases developed
Based on the procedure described above in the Test Case Design section, the list of test cases developed is summarized in the following 
table. 

Table 2: Test Cases 
| #  | Class          | Method                  | Test Name                              | Description                                                                                                                                                                                                 | Parameters                                                                 | Expected Result               |
|----|----------------|-------------------------|----------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|-------------------------------|
| 1  | Range          | contains                | testContains_ValueWithinRange()        | This test corresponds to the partition in which value is between lower and upper and within the range. This also tests a boundary condition by testing value near lower.                                     | Range upper = 10.5, Range lower = 5.5, value = 5.6                         | true                          |
| 2  | Range          | contains                | testContains_ValueEqualtoLower()       | This test corresponds to the partition in which value is within the range. This also tests a boundary condition by testing value equal to lower.                                                            | Range upper = 10.5, Range lower = 5.5, value = 5.5                         | true                          |
| 3  | Range          | contains                | testContains_ValueEqualtoUpper()       | This test corresponds to the partition in which value is within the range. This also tests a boundary condition by testing value equal to upper.                                                           | Range upper = 10.5, Range lower = 5.5, value = 10.5                        | true                          |
| 4  | Range          | contains                | testContains_ValueBelowRange()         | This test corresponds to the partition in which value is below lower (not within the range). This also tests a boundary condition by testing value near lower.                                              | Range upper = 10.5, Range lower = 5.5, value = 5.4                         | false                         |
| 5  | Range          | contains                | testContains_ValueAboveRange()         | This test corresponds to the partition in which value is above upper (not within the range). This also tests a boundary condition by testing value near upper.                                              | Range upper = 10.6, Range lower = 5.5, value = 5.5                         | false                         |
| 6  | Range          | combine                 | testCombine_BothRangesNull()           | This test corresponds to the partition in which both range1 and range2 are null.                                                                                                                           | range1 = null, range2 = null                                               | null                          |
| 7  | Range          | combine                 | testCombine_Range1NullRange2NonNull    | This test corresponds to the partition in which range1 is null and range2 is non-null.                                                                                                                     | range1 = null, range2 upper = 25.0, range2 lower = 15.0                    | range2                        |
| 8  | Range          | combine                 | testCombine_Range1NonNullRange2Null    | This test corresponds to the partition in which range1 is non-null and range2 is null.                                                                                                                     | range1 upper = 25.0, range1 lower = 15.0, range2 = null                    | range1                        |
| 9  | Range          | combine                 | testCombine_Range1WithinRange2         | This test corresponds to the partition in which both range1 and range2 are non-null. This also tests a boundary condition by testing where range1 is completely within range2.                              | range1 upper = 17.5, range1 lower = 10.0, range2 upper = 35.5, range2 lower = 0.5 | range2                        |
| 10 | Range          | combine                 | testCombine_Range1AndRange2DoNotOverlap| This test corresponds to the partition in which both range1 and range2 are non-null. This also tests a boundary condition by testing where range1 and range2 do not overlap at all.                         | range1 upper = 5.5, range1 lower = -10.5, range2 upper = 75.5, range2 lower = 45.5 | Combined range: upper = 75.5, lower = -10.5 |
| 11 | Range          | intersects              | test_lower_greater_upper               | This test corresponds to the condition where lower must be <= than upper. Only one test is needed because the conditions for lower and upper are interdependent.                                           | Range(2.9, 6.1), lower = 5.0, upper = 3.0                                  | Throw InvalidParameterException|
| 12 | Range          | intersects              | test_full_overlap                      | This test corresponds to the partition where there is no overlap between the range object and the lower and upper value                                                                                    | Range (2.9, 5.1), lower = 3.0, upper = 5.0                                 | TRUE                          |
| 13 | Range          | intersects              | test_partial_overlap                   | This test corresponds to the partition where the is a partial overlap between the range object and the lower and upper value                                                                               | Range (2.9, 5.1), lower = 3.0, upper = 5.0                                 | TRUE                          |
| 14 | Range          | intersects              | test_no_overlap                        | This test corresponds to the partition where there is no overlap between the range object and the lower and upper value                                                                                   | Range(1.0, 3.0), lower = 3.1, upper = 5.0                                  | FALSE                         |
| 15 | Range          | intersects              | test_touching_lower_boundary           | This test corresponds to the partition where the lower boundary touches the range                                                                                                                          | Range(1.0, 4.0), lower = 4.0, upper = 6.0                                  | TRUE                          |
| 16 | Range          | intersects              | test_touching_upper_boundary           | This test corresponds to the partition where the upper boundary touches the range                                                                                                                          | Range(1.0, 4.0), lower = 0.0, upper = 4.0                                  | TRUE                          |
| 17 | Range          | intersects              | test_range_equal_to_point              | This test corresponds to the partition where both ranges are a single point.                                                                                                                              | Range(3.0, 3.0), lower = 3.0, upper = 3.0                                  | TRUE                          |
| 18 | Range          | shift                   | test_null_base                         | This test corresponds to the case where the base range is null.                                                                                                                                            | base = null, delta = 1.0, allowZeroCrossing = true                         | Throw InvalidParameterException|
| 19 | Range          | shift                   | test_zero_range_positive_delta         | This test corresponds to shifting a zero-length range right.                                                                                                                                               | base = Range(0.0, 0.0), delta = 1.0, allowZeroCrossing = false             | Range(1.0, 1.0)               |
| 20 | Range          | shift                   | test_zero_range_negative_delta         | This test corresponds to shifting a zero-length range left.                                                                                                                                                | base = Range(0.0, 0.0), delta = -1.0, allowZeroCrossing = false            | Range(-1.0, -1.0)             |
| 21 | Range          | shift                   | test_positive_range_positive_delta     | This test corresponds to shifting a positive range right (zero crossing allowed).                                                                                                                          | base = Range(1.0, 5.0), delta = 2.0, allowZeroCrossing = true              | Range(3.0, 7.0)               |
| 22 | Range          | shift                   | test_negative_range_negative_delta     | This test corresponds to shifting a negative range left (zero crossing allowed).                                                                                                                           | base = Range(-5.0, -1.0), delta = -2.0, allowZeroCrossing = true           | Range(-7.0, -3.0)             |
| 23 | Range          | shift                   | test_positive_range_cross_zero_lower   | This test corresponds to shifting a positive range left, crossing zero (lower bound clamped).                                                                                                              | base = Range(1.0, 5.0), delta = -1.1, allowZeroCrossing = false            | Range(0.0, 3.9)               |
| 24 | Range          | shift                   | test_positive_range_cross_zero_lower_allowed | This test corresponds to shifting a positive range left, crossing zero (zero crossing allowed).                                                                                                            | base = Range(1.0, 5.0), delta = -1.1, allowZeroCrossing = true             | Range(-0.1, 3.9)              |
| 25 | Range          | shift                   | test_negative_range_cross_zero_upper   | This test corresponds to shifting a negative range right, crossing zero (upper bound clamped).                                                                                                             | base = Range(-5.0, -1.0), delta = 1.1, allowZeroCrossing = false           | Range(-3.9, 0.0)              |
| 26 | Range          | shift                   | test_negative_range_cross_zero_upper_allowed | This test corresponds to shifting a negative range right, crossing zero (zero crossing allowed).                                                                                                           | base = Range(-5.0, -1.0), delta = 1.1, allowZeroCrossing = true            | Range(-3.9, 0.1)              |
| 27 | Range          | shift                   | test_upper_range_max_double_positive_delta | This test corresponds to the method handling a positive shift where range upper is double.MAX_VALUE                                                                                                        | base = Range(0, double.MAX_VALUE), delta = 1, allowZeroCrossing = true     | InvalidParameterException      |
| 28 | Range          | shift                   | test_lower_range_min_double_negative_delta | This test corresponds to the method handling a positive shift where range upper is double.MIN_VALUE                                                                                                        | base = Range(double.MIN_VALUE, 0), delta = -1, allowZeroCrossing = true    | InvalidParameterException      |
| 29 | Range          | equals                  | test_not_equivalent_range              | This test corresponds to the case where the input is a range but not equivalent.                                                                                                                           | this = Range (0.0, 0.0), obj = Range(1.0, 5.0)                             | FALSE                         |
| 30 | Range          | equals                  | test_equivalent_range                  | This test corresponds to the case where the input is an equivalent range.                                                                                                                                  | this = Range (0.0, 0.0), obj = Range(0.0, 0.0)                             | TRUE                          |
| 31 | Range          | equals                  | test_itself                            | This test corresponds to the case where the input is the same instance.                                                                                                                                    | obj = this                                                                 | TRUE                          |
| 32 | Range          | equals                  | test_null_range                        | This test corresponds to the case where the input is null.                                                                                                                                                 | obj = null                                                                 | FALSE                         |
| 33 | Range          | equals                  | test_not_a_range_object                | This test corresponds to the case where the input is not a range object.                                                                                                                                   | obj = "Not a Range"                                                        | FALSE                         |
| 34 | Range          | equals                  | test_derived_range_object              | This test corresponds to the case where the input is a derived range object.                                                                                                                               | obj = DerivedRange(1.0, 5.0)                                               | TRUE                          |
| 35 | Range          | equals                  | test_range_with_nan_values             | This test corresponds to the case where the range contains NaN values.                                                                                                                                     | obj = Range(Double.NaN, Double.NaN)                                        | TRUE                          |
| 36 | DataUtilities  | createNumberArray       | testCreateNumberArray_ElementsNotNull           | This test checks that the elements in the array are not null.                                                                                                                          | data = {1.1, 2.2, 3.3}                                                    | {Number(1.1), Number(2.2), Number(3.3)} |
| 37 | DataUtilities  | createNumberArray       | testCreateNumberArray_ValuesEqual                   | This test checks that the values in the created `Number` array are equal to the input values.                                                                                                                                        | data = {1.1, 2.2, 3.3}                                                                  | {Number(1.1), Number(2.2), Number(3.3)}                            |
| 38 | DataUtilities  | createNumberArray       | testCreateNumberArray_SingleElement                         | This test checks the case where the input array contains just one element.                                                                                                                                                  | data = {5.5}                                                                | {Number(5.5)} |
| 39 | DataUtilities  | createNumberArray       | testCreateNumberArray_EmptyArray                         | This test checks the case where the input array is empty.                                                                                                                                                 | data = {}                                                                | {} |
| 40 | DataUtilities  | createNumberArray       | testCreateNumberArray_NullInput                         | This test checks the case where the input data is `null`.                                                                                                                                                 | data = null                                                                | Throws InvalidParameterException  |
| 41 | DataUtilities  | createNumberArray       | testCreateNumberArray_LargeSmallValues                         | This test checks that the function works with very large and very small values.                                                                                                                                                | data = {Double.MAX_VALUE, Double.MIN_VALUE}                                                               | {Number(Double.MAX_VALUE), Number(Double.MIN_VALUE)}  |
| 42 | DataUtilities  | createNumberArray2D     | testCreateNumberArray2D_ElementsNotNull       | This test checks that the elements in the 2D array are not null.                                                                                                               | data = {{1.1, 2.2}, {3.3, 4.4}, {5.5, 6.6}}                            | {{Number(1.1), Number(2.2)}, {Number(3.3), Number(4.4)}, {Number(5.5), Number(6.6)}} |
| 43 | DataUtilities  | createNumberArray2D     | testCreateNumberArray2D_ValuesEqual        | This test checks that the values in the 2D `Number` array are equal to the input values.                                                                                                                    | data = {{1.1, 2.2}, {3.3, 4.4}, {5.5, 6.6}}                                                         | {{Number(1.1), Number(2.2)}, {Number(3.3), Number(4.4)}, {Number(5.5), Number(6.6)}}                   |
| 44 | DataUtilities  | createNumberArray2D     | testCreateNumberArray2D_SingleElement         | This test checks the case where the input 2D array contains just one element.                                                                                                                                                   | data = {{5.5}}                                                                | {Number(5.5)} |
| 45 | DataUtilities  | createNumberArray2D     | testCreateNumberArray2D_EmptyArray         | This test checks the case where the input 2D array is empty.                                                                                                                                           | data = { {} , {} }                                                                | { {} , {} } |
| 46 | DataUtilities  | createNumberArray2D     | testCreateNumberArray2D_NullInput          | This test checks the case where the input data is `null`.                                                                                                                                           | data = null                                                                | Throws InvalidParameterException |
| 47 | DataUtilities  | createNumberArray2D     | testCreateNumberArray2D_LargeSmallValues          | This test checks that the function works with very large and very small values.                                                                                                                                                 | data = {{Double.MAX_VALUE, Double.MIN_VALUE}, {Double.MIN_VALUE, Double.MAX_VALUE}}                                                                | {{Number(Double.MAX_VALUE), Number(Double.MIN_VALUE)}, {Number(Double.MIN_VALUE), Number(Double.MAX_VALUE)}}  |
| 48 | DataUtilities  | getCumulativePercentages| testGetCumulativePercentages_ValidData             | This test checks the case where the data is valid and contains typical values for cumulative percentage calculation.                                                                                                                    | data = { {0, 5} , {1, 9} , {2, 2} }                 | { {0, 0.3125} , {1, 0.875} , {2, 1.0} } |
| 49 | DataUtilities  | getCumulativePercentages| testGetCumulativePercentages_ZeroNegativeAndFloatingValues              | This test checks the case where the data contains zero, negative, and floating point values.                                                                                                                                                 | data = { {0, 0} , {1, -4.5} , {2, 3.2} }                                                                | { {0, 0.0} , {1, 3.4615} , {2, 1.0} } |
| 50 | DataUtilities  | getCumulativePercentages| testGetCumulativePercentages_NullInput              | This test checks the case where the input data is `null`.                                                                                                                                                  | data = null                                                              | Throws InvalidParameterException |
| 51 | DataUtilities  | getCumulativePercentages| testGetCumulativePercentages_EmptyKeyValues              | This test checks the case where the input data is an empty `KeyedValues` instance.                                                                                                                                                  | data = { }                                                             | {} |
| 52 | DataUtilities  | calculateColumnTotal    | testValidDataAndColumn             | This test corresponds to the partition where the data object is valid and column is a valid integer                                                                                                        | Data = [[1, 2], [3, 4]], Column = 1                                        | 6                             |
| 53 | DataUtilities  | calculateColumnTotal    | testInvalidDataAndValidColumn     | This test corresponds to the data object being null and the column being a valid integer                                                                                                                   | Data = null, Column = 0                                                    | InvalidParameterException      |
| 54 | DataUtilities  | calculateColumnTotal    | testValidDataAndInvalidColumn     | This test corresponds to the data object being valid while the column integer being invalid (in this case a negative integer)                                                                              | Data = [[1, 2], [3, 4]], Column = -10                                      | 0                             |
| 55 | DataUtilities  | calculateRowTotal       | testValidDataAndRow                | This test corresponds to the partition where the data object is valid and the row is a valid integer                                                                                                       | Data = [[1,2],[3,4]], Row = 1                                              | 7                             |
| 56 | DataUtilities  | calculateRowTotal       | testInvalidDataAndValidRow        | This test corresponds to the data object being null and the row being a valid integer                                                                                                                      | Data = null, Row = 0                                                       | InvalidParameterException      |
| 57 | DataUtilities  | calculateRowTotal       | testValidDataAndInvalidRow        | This test corresponds to the data object being valid while the row integer being invalid (in this case a negative integer)                                                                                 | Data = [[1,2],[3,4]], Row = -10                                            | 0                             |

## Discussion on the benefits and drawbacks of using Mocking

Mocking is a powerful technique in unit testing that allows us to isolate the functionality of the method under test by replacing dependencies with controlled, simulated objects. In our JUnit 4 tests, we used mocking to test functions that rely on Values2D and KeyedValues, enabling us to define the exact behavior of these dependencies without requiring a real implementation.

One of the key benefits of using mocking is improved test isolation. For example, in our testValidDataAndColumn test, we mocked Values2D to ensure that the method calculateColumnTotal was only tested for its ability to sum column values, rather than depending on the behavior of Values2D itself. This isolation makes it easier to pinpoint failures, as any issues in the test can be attributed to the method under test rather than external dependencies. Additionally, mocking allows us to simulate edge cases and uncommon scenarios that may be difficult to create with real data, such as handling null inputs or unexpected return values. This helps improve test coverage and ensures our code is robust against different inputs.

Another advantage of mocking is its ability to improve test performance. If we relied on real database queries or complex data structures, running unit tests would be slower and less efficient. By using mocks, our tests execute quickly since they only process predefined return values rather than performing actual computations or lookups. Moreover, mocking ensures that our tests remain deterministic, meaning they always produce the same results regardless of external factors.

However, mocking also has drawbacks. One limitation is that it does not test the real implementation of dependencies, which can lead to false positives—tests passing because the mock behaves as expected, even if the real dependency contains a bug. For example, in our testGetCumulativePercentages_ValidData test, we mocked KeyedValues to return specific keys and values, ensuring the cumulative percentages were calculated correctly. While this verified our method’s logic, it did not test whether KeyedValues correctly retrieves and stores values from a real implementation. As a result, our tests might pass even if KeyedValues has an underlying issue.

Additionally, maintaining mocks can be cumbersome as the test suite grows. Every time the implementation of the dependent class changes, we may need to update our mock expectations accordingly. If we define many mock behaviors for a method, our tests may become difficult to read and maintain, reducing clarity. Overuse of mocking can also lead to fragile tests, where minor changes in the mocked behavior cause multiple test failures, even when the actual application logic remains correct.

In summary, mocking is a valuable tool for ensuring test isolation, improving performance, and simulating various conditions. However, it comes with trade-offs, including the risk of false positives, maintenance overhead, and limited coverage of real-world behavior. While it is useful for unit tests, it should be complemented with integration tests that verify the interaction of real dependencies to ensure comprehensive validation of the system.

## Test Results 

Here we will list the results of all the tests performed on each method, and a disucssion about what we learned about the method and any defects found.

### contains

| Test Case # | Class  | Test Case Name                         | Pass/Failure | Failure Message |
|------------|--------|--------------------------------------|-------------|----------------|
| 1          | range  | testContains_ValueWithinRange()      | Pass         |                |
| 2          | range  | testContains_ValueEqualtoLower()    | Pass      |                |
| 3          | range  | testContains_ValueEqualtoUpper()    | Pass          |                |
| 4          | range  | testContains_ValueBelowRange()      | Pass            |                |
| 5          | range  | testContains_ValueAboveRange()      | Pass            |                |

### combine

| Test Case # | Class  | Test Case Name                          | Pass/Failure | Failure Message |
|------------|--------|-----------------------------------------|-------------|----------------|
| 6          | range  | testCombine_BothRangesNull()           | Pass            |                |
| 7          | range  | testCombine_Range1NullRange2NonNull    | Pass            |                |
| 8          | range  | testCombine_Range1NonNullRange2Null    | Pass             |                |
| 9          | range  | testCombine_Range1WithinRange2         | Pass             |                |
| 10         | range  | testCombine_Range1AndRange2DoNotOverlap | Fail             | java.lang.AssertionError: Exception should not be thrown, but Illegal Argument Exception was thrown: Range(double, double): require lower (45.5) <= upper (-10.5). | 

The test results for Test Case 10 demonstrated an error with the combine method when the lower and upper values associated with range1 and range2 being tested do not overlap at all. In this case, according to the description of the method in the Javadoc, the combined range of (-10.5, 5.5) and (45.5, 75.5) should result in (-10.5, 75.5), which subsumes both of the ranges. However, the use of the combine method on this test case resulted in an Illegal Argument Exception stating that lower (which is 45.5) must be less than or equal to upper (which is -10.5). This reveals an error in the way the lower and upper values of the new combined range are being defined, since the new range should consist of a lower value of -10.5 and an upper value of 75.5. A try/catch statement was added to the test to allow the test to fail gracefully if an Illegal Argument Exception is thrown. The method successfully handles cases where the ranges do overlap, or one of the given ranges is null.   

### intersects

| Test Case # | Class  | Test Case Name                    | Pass/Failure | Failure Message |
|------------|--------|-----------------------------------|-------------|----------------|
| 11         | range  | test_lower_greater_upper         |             |                |
| 12         | range  | test_full_overlap               |             |                |
| 13         | range  | test_partial_overlap            |             |                |
| 14         | range  | test_no_overlap                 |             |                |
| 15         | range  | test_touching_lower_boundary    |             |                |
| 16         | range  | test_touching_upper_boundary    |             |                |
| 17         | range  | test_range_equal_to_point       |             |                |

### shift

| Test Case # | Class  | Test Case Name                            | Pass/Failure | Failure Message |
|------------|--------|-------------------------------------------|-------------|----------------|
| 18         | range  | test_zero_range_positive_delta           |             |                |
| 19         | range  | test_zero_range_negative_delta           |             |                |
| 20         | range  | test_positive_range_positive_delta       |             |                |
| 21         | range  | test_negative_range_negative_delta       |             |                |
| 22         | range  | test_positive_range_cross_zero_lower     |             |                |
| 23         | range  | test_positive_range_cross_zero_lower_allowed |             |                |
| 24         | range  | test_negative_range_cross_zero_upper     |             |                |
| 25         | range  | test_negative_range_cross_zero_upper_allowed |             |                |
| 26         | range  | test_upper_range_max_double_positive_delta |             |                |
| 27         | range  | test_lower_range_min_double_negative_delta |             |                |

### equals 

| Test Case # | Class  | Test Case Name               | Pass/Failure | Failure Message |
|------------|--------|-----------------------------|-------------|----------------|
| 29         | range  | test_not_equivalent_range   |             |                |
| 30         | range  | test_equivalent_range       |             |                |
| 31         | range  | test_itself                 |             |                |
| 32         | range  | test_null_range             |             |                |
| 33         | range  | test_not_a_range_object     |             |                |
| 34         | range  | test_derived_range_object   |             |                |
| 35         | range  | test_range_with_nan_values  |             |                |

### createNumberArray

| Test Case # | Class         | Test Case Name                          | Pass/Failure | Failure Message                                                      |
|-------------|---------------|-----------------------------------------|--------------|----------------------------------------------------------------------|
| 36          | DataUtilities | testCreateNumberArray_ElementsNotNull  | Failure      | java.lang.AssertionError: Element at index 2 should not be null      |
| 37          | DataUtilities | testCreateNumberArray_ValuesEqual      | Failure      | java.lang.AssertionError: Test failed: Null value encountered in result array. |
| 38          | DataUtilities | testCreateNumberArray_SingleElement    | Failure      | java.lang.AssertionError: Element at index 0 should not be null      |
| 39          | DataUtilities | testCreateNumberArray_EmptyArray       | Pass         |                                                                      |
| 40          | DataUtilities | testCreateNumberArray_NullInput        | Failure      | java.lang.AssertionError: Unexpected exception thrown: java.lang.IllegalArgumentException |
| 41          | DataUtilities | testCreateNumberArray_LargeSmallValues | Failure      | java.lang.AssertionError: Element at index 1 should not be null      |

The test results reveal a key issue with the createNumberArray method: the array it returns is consistently one element shorter than expected, with the last element being null. The testCreateNumberArray_ValuesEqual function confirms that while the values are correctly assigned, the array length is incorrect. The method also handles the empty array case correctly by returning an empty array. However, for null inputs, the method throws an IllegalArgumentException instead of the expected InvalidParameterException as per the JavaDocs. The large and small value test simply reiterated the issue of the shorter array.

### createNumberArray2D 

| Test Case # | Class         | Test Case Name                            | Pass/Failure | Failure Message                                                      |
|-------------|---------------|-------------------------------------------|--------------|----------------------------------------------------------------------|
| 42          | DataUtilities | testCreateNumberArray2D_ElementsNotNull  | Failure      | java.lang.AssertionError: Element at position [0][1] should not be null |
| 43          | DataUtilities | testCreateNumberArray2D_ValuesEqual      | Failure      | java.lang.AssertionError: Test failed: Null value encountered in result array. |
| 44          | DataUtilities | testCreateNumberArray2D_SingleElement    | Failure      | java.lang.AssertionError: Element at position [0][0] should not be null |
| 45          | DataUtilities | testCreateNumberArray2D_EmptyArray       | Pass         |                                                                      |
| 46          | DataUtilities | testCreateNumberArray2D_NullInput        | Failure      | java.lang.AssertionError: Unexpected exception thrown: java.lang.IllegalArgumentException |
| 47          | DataUtilities | testCreateNumberArray2D_LargeSmallValues | Failure      | java.lang.AssertionError: Element at position [0][1] should not be null |

The test results reveal a similar issue with the createNumberArray2D method as the one found in the createNumberArray method: the array returned is shorter than expected, with null values appearing in certain positions. Specifically, the testCreateNumberArray2D_ElementsNotNull and testCreateNumberArray2D_ValuesEqual tests show that although values are assigned correctly, certain elements are missing or null. The method successfully handles the empty array case by returning an empty array. For null inputs, however, it throws an IllegalArgumentException instead of the expected InvalidParameterException as specified in the JavaDocs. Finally, the large and small value test reinforced the issue of missing values in the 2D array.

### getCumulativePercentages

| Test Case # | Class         | Test Case Name                                     | Pass/Failure | Failure Message                                                      |
|-------------|---------------|----------------------------------------------------|--------------|----------------------------------------------------------------------|
| 48          | DataUtilities | testGetCumulativePercentages_ValidData             | Failure      | java.lang.AssertionError: First cumulative percentage should be 0.3125 expected:<0.3125> but was:<0.45454545454545453> |
| 49          | DataUtilities | testGetCumulativePercentages_ZeroNegativeAndFloatingValues | Pass         |                                                                      |
| 50          | DataUtilities | testGetCumulativePercentages_NullInput             | Failure      | java.lang.AssertionError: Unexpected exception thrown: java.lang.IllegalArgumentException |
| 51          | DataUtilities | testGetCumulativePercentages_EmptyKeyValues        | Pass         |                                                                      |

The test results reveal an issue with how cumulative percentages are calculated in the getCumulativePercentages method. Specifically, the test with valid positive numbers (KeyedValues with keys 0, 1, 2 and values 5, 9, 2) showed an error in the first cumulative percentage, indicating a problem with the math. Upon further investigation, it became clear that the first value in the key-value pair was not being included in the denominator for the cumulative percentage calculation. This explains why the test with zero, negative, and floating-point values passed—it allowed the calculation to work because the first value (zero) was omitted from the denominator. The issue was confirmed by comparing the expected value with and without the first value in the denominator. Additionally, the null input test threw the wrong exception, and the empty key-value test worked as expected.

### calculateColumnTotal

| Test Case # | Class         | Test Case Name                                  | Pass/Failure | Failure Message |
|------------|--------------|-----------------------------------------------|-------------|----------------|
| 52         | DataUtilities | testValidDataAndColumn                    |   Pass      |                |
| 53         | DataUtilities | testInvalidDataAndValidColumn             |   Fail      |    java.lang.AssertionError: Expected InvalidParameterException but got NullPointerException            |
| 54         | DataUtilities | testValidDataAndInvalidColumn             |   Fail      |    java.lang.AssertionError: Expected to return 0 but got a IndexOutOfBoundsException            |

### calculateRowTotal

| Test Case # | Class         | Test Case Name                                  | Pass/Failure | Failure Message |
|------------|--------------|-----------------------------------------------|-------------|----------------|
| 55         | DataUtilities | testValidDataAndRow                           |   Fail      |      java.lang.AssertionError: expected:<7.0> but was:<3.0>          |
| 56         | DataUtilities | testInvalidDataAndValidRow               |   Fail      |        java.lang.AssertionError: Expected InvalidParameterException but got NullPointerException        |
| 57         | DataUtilities | testValidDataAndInvalidRow               |   Fail      |      java.lang.AssertionError: Expected to return 0 but got a IndexOutOfBoundsException          |


# 5 How the team work/effort was divided and managed
Before beginning the lab, all members of the team completed Section 2.1 of the Lab instructions to ensure that everyone was familiar with working in Eclipse, the system under test and the workflow for creating and running JUnit tests.

As mentioned in the Test Plan above, the work for this lab was completed in pairs. Steven Au and Laurel Flanagan worked on the test case design and developing test case code for 5 methods from the Range class, and Austen Zhang and Rhys Wickens worked on test case design and developing test case code for the 5 methods from the Data Utilities class. 

Each pair divided up the methods from their class and each person designed tests cases for their portion of the methods. Then within each pair, each person reviewed the other person's test case design and provided feedback. After both people in the pair were satisfied with the test case design, then each person developed the code using the JUnit framework for the test cases that they had designed. Another review was completed within the pairs after developing the code for the test cases. The test results were reviewed together as a team. 

Completing the test case design and development parts of the lab in pairs was efficient and allowed for a more thorough review to ensure that all the requirements for the methods specfied in the Javadoc were covered in the test cases. It also helped to provide more robust test cases based on different individual interpretations of the equivalence class partitioning and boundary value analysis. 

The reporting sections of the lab were split evenly among the team members. 

# 6 Difficulties encountered, challenges overcome, and lessons learned

Text…

# 7 Comments/feedback on the lab itself

Text…
