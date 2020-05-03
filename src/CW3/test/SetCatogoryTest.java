import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Date;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class BoCCategoryTest {
	private static String string1, string2, string3;
	private static BigDecimal bignum1; 
	private static BigDecimal bignum2;
	private static BigDecimal bignum3;
	private static BigDecimal bignum4;
	
	@BeforeAll
	static void setup() {
		string1 = "5";
		string2 = "transport";
		string3 = "shopping";
		final BigDecimal bignum1 = new BigDecimal("1000");
		final BigDecimal bignum2 = new BigDecimal("1200.85");
		final BigDecimal bignum3 = new BigDecimal("3000");
		final BigDecimal bignum4 = new BigDecimal("4500.45");
	}
		
	/*
	 * method of get the timestamp until seconds
	 * author:Haonan CHEN
	 */
	public static int getSecondTimestamp(final Date date){  
		if (null == date) {  
		    return 0;  
		}  
		final String timestamp = String.valueOf(date.getTime());  
		final int length = timestamp.length();  
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
    1 -Fail- Yuxiang Zhang - 17:30/01/05       
    Problem: The categoryName is not same as the expected outcome.
	Reason:
	Traceability:
	*/
	@Test 			//Test of the default constructor by Yuxiang Zhang
	void Default_Constructor_test1() throws Exception {

			final BoCCategory empty = new BoCCatogory();
			assertEquals(empty.CategoryName(),"[Pending Catogory]"); 
			assertEquals(empty.Category(),0);
	}
		
	/* 
	2 -Pass- Yuxiang Zhang - 19:50/01/05  
	Problem: 
	Reason:
	Traceability:
	*/
	@Test 			
	void Main_Constructor_test1() throws Exception {
		final Date current = new Date();
		final BigDecimal budget = new BigDecimal("1000");
		try {
			final BoCCatogory transport = new BoCCatogory(string2,bignum1,bignum2);

				
			assertEquals(transport.CatogoryName(),"transport"); 
			assertEquals(transport.CatogoryBudget(),1000);
			assertEquals(transport.CatogorySpend(),1200.85);
			assertEquals(getSecondTimestamp(transport.CatogoryTime()),getSecondTimestamp(current));
		}catch(final Exception e) {
			fail ("Something wrong with catch");
		}
	}
		
	/* 
	3 -Fail- Yuxiang Zhang - 20:05/01/05  
	Problem: The numbers of parameters and input is not matching
	Reason: the constructor BoCCatogory(string,bigdecimal,bigdecimal) is undefined.
	Traceability:Main Constructors Test 2; Main Constructors Test 2;Main Constructors Test 2;
	*/
	@Ignore 			
	void Main_Constructor_test2() throws Exception {
		final Date current = new Date();
		final BigDecimal spend = new BigDecimal("1000");
		try {
			BoCCatogorytransport = new BoCCatogory();
			assertEquals(transport.CatogoryName(),"transport"); 
			assertEquals(transport.CatogoryBudget(),1000);
			assertEquals(transport.CatogorySpend(),1200.85);
		}catch(final Exception e) {
			fail ("Something wrong with catch");
		}
	}
		
	/* 
	4 -Pass- Yuxiang Zhang - 21:40/01/05  
	Problem: constructorTime is not same as the expected value.
	Reason:The delay of the constructorTime and currentTime are created.
	Traceability:Main Constructors Test 3; Main Constructors Test 3
	*/
	@Test 
	void Main_Constructor_test3() throws Exception {
		final Date current = new Date();
		final BigDecimal spend = new BigDecimal("3000");
		try {
			final BoCCatogory shopping = new BoCCatogory(string3,bignum3,bignum4);
			assertEquals(shopping.CatogoryName(),"shopping"); 
			assertEquals(shopping.CatogoryBudget(),3000);
			assertEquals(shopping.CatogorySpend(),4500.45);
			assertEquals(getSecondTimestamp(shopping.CatogoryTime()),getSecondTimestamp(current));
		}catch(final Exception e) {
			fail ("Something wrong with catch");
		}
	}
		
	/* 
	5 -Pass- Yuxiang Zhang - 21:40/01/05  
	Problem: 
	Reason:
	Traceability:Main Constructors Test 3
	*/
	@Test 
	void Main_Constructor_test3() throws Exception {
		final Date current = new Date();
		final BigDecimal spend = new BigDecimal("3000");
		try {
			final BoCCatogory shopping = new BoCCatogory(string3,bignum3,bignum4);
			assertEquals(shopping.CatogoryName(),"shopping"); 
			assertEquals(shopping.CatogoryCategory(),3000);
			assertEquals(shopping.CatogoryValue(),4500.45);
			assertEquals(getSecondTimestamp(shopping.CatogoryTime()),getSecondTimestamp(current));
		}catch(final Exception e) {
			fail ("Something wrong with catch");
		}
	}
}		
}

class SetCatogoryTest {
	private String TestInputString, TestOutputString;
	private BigDecimal TestInputBudget;
	private BigDecimal TestOutputBudget;
	private BigDecimal TestExceptOutputBudget;
	
	@Test
	void setCNTest1() throws Exception {
		TestInputString="YTB";
		try {
			BoCCategory copy = new BoCCategory();
			copy.setCategoryName(TestInputString);
			TestOutputString = copy.CategoryName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(TestInputString, TestOutputString);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Bills", " " ,""})
	void setCNTest234(String TestInputString) throws Exception {
		try {
			BoCCategory copy = new BoCCategory();
			copy.setCategoryName(TestInputString);
			TestOutputString = copy.CategoryName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertNull(TestOutputString);
	}
	
	@Test
	void setCBTest1(){
		TestInputBudget = new BigDecimal("12");
		TestExceptOutputBudget = new BigDecimal("12.00");
		try {
			BoCCategory copy = new BoCCategory();
			copy.setCategoryBudget(TestInputBudget);
			TestOutputBudget = copy.CategoryBudget();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(TestExceptOutputBudget, TestOutputBudget);
	}
	
	@Test
	void setCBTest2(){
		TestInputBudget = new BigDecimal("0");
		TestExceptOutputBudget = new BigDecimal("0.00");
		try {
			BoCCategory copy = new BoCCategory();
			copy.setCategoryBudget(TestInputBudget);
			TestOutputBudget = copy.CategoryBudget();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(TestExceptOutputBudget, TestOutputBudget);
	}
	
	@Test
	void setCBTest3(){
		TestInputBudget = new BigDecimal("1.002");
		TestExceptOutputBudget = new BigDecimal("1.00");
		try {
			BoCCategory copy = new BoCCategory();
			copy.setCategoryBudget(TestInputBudget);
			TestOutputBudget = copy.CategoryBudget();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(TestExceptOutputBudget, TestOutputBudget);
	}
	
	@Test
	void setCBTest4(){
		TestInputBudget = new BigDecimal("8.9999");
		TestExceptOutputBudget = new BigDecimal("9.00");
		try {
			BoCCategory copy = new BoCCategory();
			copy.setCategoryBudget(TestInputBudget);
			TestOutputBudget = copy.CategoryBudget();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(TestExceptOutputBudget, TestOutputBudget);
	}
	
	@Test
	void setCBTest5(){
		TestInputBudget = new BigDecimal("-100");
		TestExceptOutputBudget = new BigDecimal("0.00");
		try {
			BoCCategory copy = new BoCCategory();
			copy.setCategoryBudget(TestInputBudget);
			TestOutputBudget = copy.CategoryBudget();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(TestExceptOutputBudget, TestOutputBudget);
	}
	
	@Test
	void setCBTest6(){
		TestInputBudget = new BigDecimal("11.2");
		TestExceptOutputBudget = new BigDecimal("11.20");
		try {
			BoCCategory copy = new BoCCategory();
			copy.setCategoryBudget(TestInputBudget);
			TestOutputBudget = copy.CategoryBudget();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(TestExceptOutputBudget, TestOutputBudget);
	}
}
