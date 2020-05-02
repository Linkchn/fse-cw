import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

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
	private static BigDecimal bignum2;
	private static BigDecimal bignum3;
	private static BigDecimal bignum4;

	static BoCTransaction tran1;
    static BoCTransaction tran2;
    static BoCTransaction tran3;
    static BoCTransaction tran4;

    
	@BeforeAll
	static void setup() {
		string1 = "food";
		string2 = "trip";
		integer1 = 1;
		integer2 = 2;
		bignum1 = new BigDecimal("10000");
		bignum2 = new BigDecimal("20000");
		bignum3 = new BigDecimal("20000.15");
		bignum4 = new BigDecimal("20000.151");
		
		tran1 = new BoCTransaction();
        tran2 = new BoCTransaction(null, new BigDecimal("850.00"), 0);
        tran3 = new BoCTransaction("Rent", null, 0);
        tran4 = new BoCTransaction("Rent", new BigDecimal("850.00"), 0);
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
	1 – Fail – Haonan CHEN - 23:38/30/4  
	Problem: The transactionName is not same as the expected outcome.
	Reason:
	Traceability:
	*/
	@Test 			//Test of the default constructor by Haonan CHEN
	void Default_Constructor_test1() throws Exception {

			BoCTransaction empty = new BoCTransaction();
			assertEquals(empty.transactionName(),"[Pending Transaction]"); 
			assertEquals(empty.transactionCategory(),0);
	}
	
	
	
	/* MAIN CONSTRUCTOR TEST**********************************************************************
	1 – Pass – Haonan CHEN - 00:09/01/05  
	Problem: 
	Reason:
	Traceability:
	*/
	@Test 			//Test of the default constructor by Haonan CHEN
	void Main_Constructor_test1() throws Exception {
		Date current = new Date();
		BigDecimal value = new BigDecimal("10000");
		try {
			BoCTransaction food = new BoCTransaction(string1,bignum1,integer2);

			
			assertEquals(food.transactionName(),"food"); 
			assertEquals(food.transactionCategory(),2);
			assertEquals(food.transactionValue(),value);
			assertEquals(getSecondTimestamp(food.transactionTime()),getSecondTimestamp(current));
		}catch(Exception e) {
			fail ("Something wrong with catch");
		}
	}
	
	/* 
	2 – Pass – Haonan CHEN - 14:56/01/05  
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
			assertEquals(food.transactionName(),"food"); 
			assertEquals(food.transactionCategory(),2);
			assertEquals(food.transactionValue(),value);
			assertEquals(food.transactionTime(),current);
		}catch(Exception e) {
			fail ("Something wrong with catch");
		}
	}
	
	/* 
	3 – Pass – Haonan CHEN - 16:07/01/05  
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
			assertEquals(trip.transactionName(),"trip"); 
			assertEquals(trip.transactionCategory(),1);
			assertEquals(trip.transactionValue(),value2);
			assertEquals(getSecondTimestamp(trip.transactionTime()),getSecondTimestamp(current));
		}catch(Exception e) {
			fail ("Something wrong with catch");
		}
	}
	
	/* 
	4 – Pass – Haonan CHEN - 16:07/01/05  
	Problem: 
	Reason:
	Traceability:Main Constructors Test 6
	*/
	@Test 
	void Main_Constructor_test4() throws Exception {
		Date current = new Date();
		BigDecimal value2 = new BigDecimal("20000.15");
		try {
			BoCTransaction trip = new BoCTransaction(string2,bignum4,integer1);
			assertEquals(trip.transactionName(),"trip"); 
			assertEquals(trip.transactionCategory(),1);
			assertEquals(trip.transactionValue(),value2);
			assertEquals(getSecondTimestamp(trip.transactionTime()),getSecondTimestamp(current));
		}catch(Exception e) {
			fail ("Something wrong with catch");
		}
	}
	
	
	
	/* TRANSACTION NAME TEST*******************************************************************
	1 – Pass – Haonan CHEN - 18:51/01/05  
	Problem: 
	Reason:
	Traceability:transactionName Test 1
	*/
	@Test 
	void transactionNameTest1() throws Exception {
		BoCTransaction food = new BoCTransaction(string1,bignum1,integer2);
		assertEquals(food.transactionName(),"food");
	}
	
	/* 
	2 – Pass – Haonan CHEN - 19:03/01/05  
	Problem: 
	Reason:
	Traceability:transactionName Test 2
	*/
	@Test 
	void transactionNameTest2() throws Exception {
		BoCTransaction trip = new BoCTransaction(string2,bignum3,integer1);
		assertEquals(trip.transactionName(),"trip");
	}
	
	/* 
	3 – Pass – Haonan CHEN - 19:04/01/05  
	Problem: 
	Reason:
	Traceability:transactionName Test 3
	*/
	@Test 
	void transactionNameTest3() throws Exception {
		BoCTransaction empty = new BoCTransaction();
		assertEquals(empty.transactionName(),"[Pending Transaction]");
	}
	
	
	
	/* TRANSACTION VALUE TEST*******************************************************************
	1 – Pass – Haonan CHEN - 19:07/01/05  
	Problem: 
	Reason:
	Traceability:transactionValue Test 1
	*/
	@Test 
	void transactionValueTest1() throws Exception {
		BoCTransaction food = new BoCTransaction(string1,bignum1,integer2);
		BigDecimal testvalue = new BigDecimal("10000");
		assertEquals(food.transactionValue(),testvalue);
	}
	
	/* 
	2 – Pass – Haonan CHEN - 19:12/01/05  
	Problem: 
	Reason:
	Traceability:transactionValue Test 2
	*/
	@Test 
	void transactionValueTest2() throws Exception {
		BoCTransaction trip = new BoCTransaction(string2,bignum3,integer1);
		BigDecimal testvalue = new BigDecimal("20000.15");
		assertEquals(trip.transactionValue(),testvalue);
	}
	
	/* 
	3 – Pass – Haonan CHEN - 19:16/01/05  
	Problem: 
	Reason:
	Traceability:transactionValue Test 3
	*/
	@Test 
	void transactionValueTest3() throws Exception {
		BoCTransaction empty = new BoCTransaction();
		BigDecimal testvalue = null;
		assertEquals(empty.transactionValue(),testvalue);
	}
	
	
	/* TRANSACTION CATEGORY TEST*******************************************************************
	1 – Pass – Haonan CHEN - 19:20/01/05  
	Problem: 
	Reason:
	Traceability:transactionCategory Test 1
	*/
	@Test 
	void transactionCategoryTest1() throws Exception {
		BoCTransaction food = new BoCTransaction(string1,bignum1,integer2);
		assertEquals(food.transactionCategory(),2);
	}
	
	/* 
	2 – Pass – Haonan CHEN - 19:30/01/05  
	Problem: 
	Reason:
	Traceability:transactionCategory Test 2
	*/
	@Test 
	void transactionCategoryTest2() throws Exception {
		BoCTransaction trip = new BoCTransaction(string2,bignum3,integer1);
		assertEquals(trip.transactionCategory(),1);
	}
	
	/* 
	3 – Pass – Haonan CHEN - 19:42/01/05  
	Problem: 
	Reason:
	Traceability:transactionCategory Test 3
	*/
	@Test 
	void transactionCategoryTest3() throws Exception {
		BoCTransaction empty = new BoCTransaction();
		assertEquals(empty.transactionCategory(),0);
	}
	
	
	/* TRANSACTION TIME TEST*******************************************************************
	1 – Pass – Haonan CHEN - 19:45/01/05  
	Problem: 
	Reason:
	Traceability:transactionTime Test 1
	*/
	@Test 
	void transactionTimeTest1() throws Exception {
		Date current = new Date();
		BoCTransaction food = new BoCTransaction(string1,bignum1,integer2);
		assertEquals(getSecondTimestamp(food.transactionTime()),getSecondTimestamp(current));
	}
	
	/* 
	2 – Pass – Haonan CHEN - 19:51/01/05  
	Problem: 
	Reason:
	Traceability:transactionTime Test 2
	*/
	@Test 
	void transactionTimeTest2() throws Exception {
		Date current = new Date();
		BoCTransaction trip = new BoCTransaction(string2,bignum3,integer1);
		assertEquals(getSecondTimestamp(trip.transactionTime()),getSecondTimestamp(current));
	}
	
	/* 
	3 – Pass – Haonan CHEN - 20:03/01/05  
	Problem: 
	Reason:
	Traceability:transactionTime Test 3
	*/
	@Test 
	void transactionTimeTest3() throws Exception {
		BoCTransaction empty = new BoCTransaction();
		assertEquals(empty.transactionTime(),null);
	}

	/*
    1 – ERROR – Shiliang – 21:43 1/5
    Problem: isComplete () does not exist
    Reason: java reported error, cant invoke a non-exist method
    Traceability: isCompleteTest 1

    2 – PASS – Shiliang – 22:37 1/5
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
}
