import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoCTransactionTest {
	private static String string1, string2;
	private static int integer1, integer2;
	private static BigDecimal bignum1;
	private static BigDecimal bignum3;
	private static BigDecimal bignum4;
	private static BoCTransaction food;
	private static BoCTransaction trip;
	private static BoCTransaction empty;

	private static BoCTransaction tran1;
	private static BoCTransaction tran2;
	private static BoCTransaction tran3;
	private static BoCTransaction tran4;
	
	private String testInputString, testOutputString, testInputString1, testInputString2;
	private BigDecimal testInputBudget;
	private BigDecimal testInputBudget1;
	private BigDecimal testInputBudget2;
	private BigDecimal testOutputBudget;
	private BigDecimal testExceptOutputBudget;
    
	@BeforeAll
	static void setup() {
		string1 = "food";
		string2 = "trip";
		integer1 = 1;
		integer2 = 2;
		bignum1 = new BigDecimal("10000");
		bignum3 = new BigDecimal("20000.15");
		bignum4 = new BigDecimal("20000.151");
		food = new BoCTransaction(string1,bignum1,integer2);
		trip = new BoCTransaction(string2,bignum3,integer1);
		empty = new BoCTransaction();
		
		tran1 = new BoCTransaction();
        tran2 = new BoCTransaction(null, new BigDecimal("850.00"), 0);
        tran3 = new BoCTransaction("Rent", null, 0);
        tran4 = new BoCTransaction("Rent", new BigDecimal("850.00"), 0);
	}
	
	@AfterEach
    void tearDown() {
    }
	
	/*
	 * method of get the timestamp until seconds
	 * author:Haonan CHEN
	 */
	public static int getSecondTimestamp(Date date){  
	    if (null == date) {  
	        return 0;  
	    }  
	    String timestamp = String.valueOf(date.getTime());  
	    int length = timestamp.length();  
	    if (length > 3) {  
	        return Integer.valueOf(timestamp.substring(0,length-3));  
	    } else {  
	        return 0;  
	    }  
	}  

	@Disabled
	void test() {
		fail("Not yet implemented");
	}

	/* DEFAULT CONSTRUCTOR TEST******************************************************************
	1 - Fail - Haonan CHEN - 23:38/30/4  
	Problem: The transactionName is not same as the expected outcome.
	Reason:
	Traceability:
	*/
	@Test 			//Test of the default constructor by Haonan CHEN
	void Default_Constructor_test1() throws Exception {
			BoCTransaction empty = new BoCTransaction();
			assertEquals("[Pending Transaction]", empty.transactionName()); 
			assertEquals(0,empty.transactionCategory());
	}
	
	
	
	/* MAIN CONSTRUCTOR TEST**********************************************************************
	1 - Pass - Haonan CHEN - 00:09/01/05  
	Problem: 
	Reason:
	Traceability:
	*/
	@Test 			
	//Test of the default constructor by Haonan CHEN
	void Main_Constructor_test1() throws Exception {
		Date current = new Date();
		BigDecimal value = new BigDecimal("10000");
		try {
			BoCTransaction food = new BoCTransaction(string1,bignum1,integer2);
			assertEquals("food",food.transactionName()); 
			assertEquals(2,food.transactionCategory());
			assertEquals(value,food.transactionValue());
			assertEquals(getSecondTimestamp(current),getSecondTimestamp(food.transactionTime()));
		}catch(Exception e) {
			fail ("Something wrong with catch");
		}
	}
	
	/* 
	2 - Pass - Haonan CHEN - 14:56/01/05  
	Problem: The numbers of parameters and input is not matching
	Reason: the constructor BoCTransaction(string,bigdecimal) is undefined.
	Traceability:Main Constructors Test 2; Main Constructors Test 3;Main Constructors Test 4;
	*/
	@Disabled 			
	void Main_Constructor_test2() throws Exception {
		Date current = new Date();
		BigDecimal value = new BigDecimal("10000");
		try {
			BoCTransaction food = new BoCTransaction();
			assertEquals("food",food.transactionName()); 
			assertEquals(2,food.transactionCategory());
			assertEquals(value,food.transactionValue());
			assertEquals(food.transactionTime(),current);
		}catch(Exception e) {
			fail ("Something wrong with catch");
		}
	}
	
	/* 
	3 - Pass - Haonan CHEN - 16:07/01/05  
	Problem: constructorTime is not same as the expected value.
	Reason:The delay of the constructorTime and currentTime are created.
	Traceability:Main Constructors Test 5; Main Constructors Test 5(2)
	*/
	@Test 
	void Main_Constructor_test3() throws Exception {
		Date current = new Date();
		BigDecimal value2 = new BigDecimal("20000.15");
		try {
			BoCTransaction trip = new BoCTransaction(string2,bignum3,integer1);
			assertEquals("trip",trip.transactionName()); 
			assertEquals(1,trip.transactionCategory());
			assertEquals(value2,trip.transactionValue());
			assertEquals(getSecondTimestamp(current),getSecondTimestamp(trip.transactionTime()));
		}catch(Exception e) {
			fail ("Something wrong with catch");
		}
	}
	
	/* 
	4 - FAIL - Haonan CHEN - 16:07/01/05  
	Problem: The method can only input decimal with 2 numbers after point
	Reason: the data in bank  should keep 2 decimal place
	Traceability:Main Constructors Test 6
	*/
	@Disabled 
	void Main_Constructor_test4() throws Exception {
		Date current = new Date();
		BigDecimal value2 = new BigDecimal("20000.15");
		try {
			BoCTransaction trip = new BoCTransaction(string2,bignum4,integer1);
			assertEquals("trip",trip.transactionName()); 
			assertEquals(1,trip.transactionCategory());
			assertEquals(value2,trip.transactionValue());
			assertEquals(getSecondTimestamp(current),getSecondTimestamp(trip.transactionTime()));
		}catch(Exception e) {
			fail ("Something wrong with catch");
		}
	}
	
	
	
	/* TRANSACTION NAME TEST*******************************************************************
	1 - Pass - Haonan CHEN - 18:51/01/05  
	Problem: 
	Reason:
	Traceability:transactionName Test 1
	
	2 - Pass - Haonan CHEN - 19:03/01/05  
	Problem: 
	Reason:
	Traceability:transactionName Test 2
	
	3 - Pass - Haonan CHEN - 19:04/01/05  
	Problem: 
	Reason:
	Traceability:transactionName Test 3
	*/
	@ParameterizedTest
	@MethodSource
	void transactionNameTest(BoCTransaction test,String testValue) throws Exception {
		assertEquals(testValue,test.transactionName());
	}
	static List<Arguments> transactionNameTest(){
		return List.of(
				Arguments.arguments(food,"food"),
				Arguments.arguments(trip,"trip"),
				Arguments.arguments(empty,"[Pending Transaction]")
		);
	}
	
	
	/* TRANSACTION VALUE TEST*******************************************************************
	1 - Pass - Haonan CHEN - 19:07/01/05  
	Problem: 
	Reason:
	Traceability:transactionValue Test 1
	
	2 - Pass - Haonan CHEN - 19:12/01/05  
	Problem: 
	Reason:
	Traceability:transactionValue Test 2
	
	3 - Pass - Haonan CHEN - 19:16/01/05  
	Problem: 
	Reason:
	Traceability:transactionValue Test 3
	*/
	@ParameterizedTest
	@MethodSource
	void transactionValueTest(BoCTransaction test,BigDecimal testValue) throws Exception {
		assertEquals(testValue,test.transactionValue());
	}
	static List<Arguments> transactionValueTest(){
		return List.of(
				Arguments.arguments(food,bignum1),
				Arguments.arguments(trip,bignum3),
				Arguments.arguments(empty,null)
		);
	}
	
	/* TRANSACTION CATEGORY TEST*******************************************************************
	1 - Pass - Haonan CHEN - 19:20/01/05  
	Problem: 
	Reason:
	Traceability:transactionCategory Test 1
	
	2 - Pass - Haonan CHEN - 19:30/01/05  
	Problem: 
	Reason:
	Traceability:transactionCategory Test 2
	
	3 - Pass - Haonan CHEN - 19:42/01/05  
	Problem: 
	Reason:
	Traceability:transactionCategory Test 3
	*/
	@ParameterizedTest
	@MethodSource
	void transactionCategoryTest(BoCTransaction test,int testValue) throws Exception {
		assertEquals(testValue,test.transactionCategory());
	}
	static List<Arguments> transactionCategoryTest(){
		return List.of(
				Arguments.arguments(food,2),
				Arguments.arguments(trip,1),
				Arguments.arguments(empty,0)
		);
	}
	
	
	/* TRANSACTION TIME TEST*******************************************************************
	1 - Pass - Haonan CHEN - 19:45/01/05  
	Problem: 
	Reason:
	Traceability:transactionTime Test 1
	
	2 - Pass - Haonan CHEN - 19:51/01/05  
	Problem: 
	Reason:
	Traceability:transactionTime Test 2
	
	3 - Pass - Haonan CHEN - 20:03/01/05  
	Problem: 
	Reason:
	Traceability:transactionTime Test 3
	*/
	@ParameterizedTest
	@MethodSource
	void transactionTimeTest(BoCTransaction test,Date testValue) throws Exception {
		assertEquals(getSecondTimestamp(testValue),getSecondTimestamp(test.transactionTime()));
	}
	static List<Arguments> transactionTimeTest(){
		return List.of(
				Arguments.arguments(food,new Date()),
				Arguments.arguments(trip,new Date()),
				Arguments.arguments(empty,null)
		);
	}

	/*
    1 - ERROR - Shiliang - 21:43 1/5
    Problem: isComplete () does not exist
    Reason: java reported error, cant invoke a non-exist method
    Traceability: isCompleteTest 1

    2 - PASS - Shiliang - 22:37 1/5
    Problem: /
    Reason: /
    Traceability: isCompleteTest 2

     */
    @DisplayName("isCompleteTest")
    @ParameterizedTest
    @MethodSource
    void isCompleteTest(BoCTransaction tran) {
    assertEquals((tran.transactionName()) != null && (tran.transactionValue() != null), tran.isComplete());
    }

    static List<Arguments> isCompleteTest() {
        return List.of( // arguments:
                Arguments.arguments(tran1),
                Arguments.arguments(tran2),
                Arguments.arguments(tran3),
                Arguments.arguments(tran4)
        );
    }
    
    /* 
	1 - Pass - Leo - 14:25/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest1
	
	2 – Pass – Leo - 14:42/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest2
	
	3 – Pass – Leo - 15:27/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest3
	*/
    @DisplayName("setNameTest")
	@ParameterizedTest
	@MethodSource	
	void setNameTest(String testInputString, String testExpectOutputString, int alert) throws Exception {
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString);
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			if (alert == 1 ) {
				assertEquals("Set failed. This transaction name has already been set.", e.getMessage());
			}else if (alert == 2) {
				assertEquals("Set failed. Transaction name cannot be blank.", e.getMessage());
			}
		}
		assertEquals(testExpectOutputString, testOutputString);
	}
	static List<Arguments> setNameTest(){
		return List.of(
				Arguments.arguments("LEO", "LEO", 2),
				Arguments.arguments(null, null, 2),
				Arguments.arguments("QWERTYUIOPASDFGHJKLZXCVBNM", "QWERTYUIOPASDFGHJKLZXCVBN", 2)
		);
	}

	/* 
	4 – Pass – Leo - 23:21/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest4
	
	5 – Pass – Leo - 23:26/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest5
	
	6 – Pass – Leo - 23:37/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest6
	*/
	@DisplayName("setNameTestD")
	@ParameterizedTest
	@MethodSource	
	void setNameTestD(String testInputString1, String testInputString2, String testExpectOutputString, int alert) throws Exception {
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString1);
			testOutputString = copy.transactionName();
			copy.setTransactionName(testInputString2);
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			if (alert == 1 ) {
				assertEquals("Set failed. This transaction name has already been set.", e.getMessage());
			}else if (alert == 2) {
				assertEquals("Set failed. Transaction name cannot be blank.", e.getMessage());
			}
		}
		assertEquals(testExpectOutputString, testOutputString);
	}
	static List<Arguments> setNameTestD(){
		return List.of(
				Arguments.arguments("[Pending Transaction]", "LEO", "LEO", 2),
				Arguments.arguments("Leo", "Leopard", "Leo", 1),
				Arguments.arguments("Leo", null, "Leo", 1)
		);
	}

	/* 
	7 – Pass – Leo - 15:50/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest1
	
	8 – Pass – Leo - 16:55/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest2
	
	9 – Pass – Leo - 17:19/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest3
	
	10 – Pass – Leo - 18:28/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest4
	*/
	@DisplayName("setValueTest")
	@ParameterizedTest
	@MethodSource
	void setValueTest(BigDecimal testInputBudget, BigDecimal testExceptOutputBudget) throws Exception {
		testInputBudget = new BigDecimal(123);
		testExceptOutputBudget = new BigDecimal("123");
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionValue(testInputBudget);
			testOutputBudget = copy.transactionValue();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutputBudget, testOutputBudget);
	}
	static List<Arguments> setValueTest(){
		return List.of(
				Arguments.arguments(new BigDecimal(123), new BigDecimal("123")),
				Arguments.arguments(new BigDecimal("123.12"), new BigDecimal("123.12")),
				Arguments.arguments(new BigDecimal("123.123"), null),
				Arguments.arguments(new BigDecimal("-123.123"), null)
		);
	}

	/* 
	11 – Pass – Leo - 23:48/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest5
	
	12 – Pass – Leo - 00:55/2/5  
	Problem: 
	Reason:
	Traceability: setValueTest6
	*/
	@DisplayName("setValueTestD")
	@ParameterizedTest
	@MethodSource
	void setValueTestD(BigDecimal testInputBudget1,BigDecimal testInputBudget2, BigDecimal testExceptOutputBudget) throws Exception {
		testInputBudget1 = new BigDecimal("-123.12");
		testInputBudget2 = new BigDecimal("123.13");
		testExceptOutputBudget = new BigDecimal("123.13");
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionValue(testInputBudget1);
			copy.setTransactionValue(testInputBudget2);
			testOutputBudget = copy.transactionValue();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutputBudget, testOutputBudget);
	}
	static List<Arguments> setValueTestD(){
		return List.of(
				Arguments.arguments(new BigDecimal("-123.12"), new BigDecimal("123.13"), new BigDecimal("123.13")),
				Arguments.arguments(new BigDecimal("123.12"), new BigDecimal("123.14"), new BigDecimal("123.13"))
		);
	}
	
	/* 
	13 – Pass – Leo - 19:03/1/5  
	Problem: 
	Reason:
	Traceability: setCatTest1
	
	14 – Pass – Leo - 19:05/1/5  
	Problem: 
	Reason:
	Traceability: setCatTest2
	*/
	@DisplayName("setCatTest")
	@ParameterizedTest
	@MethodSource
	void setCatTest(int testInput, int testExceptOutput, int testOutput) throws Exception {
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionCategory(testInput);
			testOutput = copy.transactionCategory();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}
	static List<Arguments> setCatTest(){
		return List.of(
				Arguments.arguments(10, 10, 0),
				Arguments.arguments(-10, 0, 0)
		);
	}

	/* 
	15 – Pass – Leo - 00:59/2/5  
	Problem: 
	Reason:
	Traceability: setCatTest3
	*/
	@Test
	void setCatTest3(){
		int testInput1 = 10;
		int testInput2 = 15;
		int testExceptOutput = 15;
		int testOutput = 0;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionCategory(testInput1);
			copy.setTransactionCategory(testInput2);
			testOutput = copy.transactionCategory();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}
	
	/* 
	16 – Pass – Leo - 22:21/1/5  
	Problem: 
	Reason:
	Traceability: toStringTest1
	*/
	@Test
	void ToStringTest1(){
		BigDecimal tValue = new BigDecimal(123);
		String testExceptOutput = null;
		String testOutput = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionValue(tValue);
			testOutput = copy.toString();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}

	/* 
	17 – Pass – Leo - 22:23/1/5  
	Problem: 
	Reason:
	Traceability: toStringTest2
	*/
	@Test
	void ToStringTest2(){
		String tName = "Leo";
		String testExceptOutput = null;
		String testOutput = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(tName);
			testOutput = copy.toString();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}

	/* 
	18 – Pass – Leo - 22:37/1/5  
	Problem: 
	Reason:
	Traceability: toStringTest3
	*/
	@Test
	void ToStringTest3(){
		String tName = "Leo";
		BigDecimal tValue = new BigDecimal(123);
		long timeStamp = System.currentTimeMillis(); 
		SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String sd = sdff.format(new Date(timeStamp));
		String testExceptOutput = sd + " Leo - ¥123" ;
		String testOutput = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(tName);
			copy.setTransactionValue(tValue);
			testOutput = copy.toString();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}
}
