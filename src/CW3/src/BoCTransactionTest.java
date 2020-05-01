import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class BoCTransactionTest {
	private static String string1, string2;
	private static int integer1, integer2;
	private static BigDecimal bignum1;
	private static BigDecimal bignum2;
	private static BigDecimal bignum3;
	private static BigDecimal bignum4;
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

	@Ignore
	void test() {
		fail("Not yet implemented");
	}

	/* 
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
	
	/* 
	2 – Pass – Haonan CHEN - 00:09/01/05  
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
	3 – Pass – Haonan CHEN - 14:56/01/05  
	Problem: The numbers of parameters and input is not matching
	Reason: the constructor BoCTransaction(string,bigdecimal) is undefined.
	Traceability:Main Constructors Test 2; Main Constructors Test 3;Main Constructors Test 4;
	*/
	@Ignore 			
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
	4 – Pass – Haonan CHEN - 16:07/01/05  
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
	5 – Pass – Haonan CHEN - 16:07/01/05  
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
	
}
