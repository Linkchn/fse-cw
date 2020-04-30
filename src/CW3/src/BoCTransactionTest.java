import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
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
	@BeforeAll
	static void setup() {
		string1 = "food";
		string2 = "trip";
		integer1 = 1;
		integer2 = 2;
		bignum1 = new BigDecimal("10000");
		bignum2 = new BigDecimal("20000");
		bignum3 = new BigDecimal("20000.15");
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
		try {
			BoCTransaction food = new BoCTransaction(string1,bignum1,integer2);
			assertEquals(food.transactionName(),); 
			assertEquals(food.transactionCategory(),0);
			assertEquals(food.transactionName(),);
		}catch(Exception e) {
			fail ("Something wrong with catch");
		}
	}
	
}
