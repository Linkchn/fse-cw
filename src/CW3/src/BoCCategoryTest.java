import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
	 * author:Yuxiang Zhang
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

			final BoCCategory empty = new BoCCategory();
			assertEquals(empty.CategoryName(),"[Pending Category]"); 
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
			final BoCCategory transport = new BoCCategory(string2,bignum1,bignum2);

				
			assertEquals(transport.CategoryName(),"transport"); 
			assertEquals(transport.CategorySpend(),1000);
			assertEquals(transport.CategorySpend(),1200.85);
			assertEquals(getSecondTimestamp(transport.CateoryTime()),getSecondTimestamp(current));
		}catch(final Exception e) {
			fail ("Something wrong with catch");
		}
	}
		
	/* 
	3 -Fail- Yuxiang Zhang - 20:05/01/05  
	Problem: The numbers of parameters and input is not matching
	Reason: the constructor BoCCategory(string,bigdecimal,bigdecimal) is undefined.
	Traceability:Main Constructors Test 2; Main Constructors Test 2;Main Constructors Test 2;
	*/
	@Ignore 			
	void Main_Constructor_test2() throws Exception {
		final Date current = new Date();
		final BigDecimal spend = new BigDecimal("1000");
		try {
			BoCCategorytransport = new BoCCategory();
			assertEquals(transport.CategoryName(),"transport"); 
			assertEquals(transport.CategoryBudget(),1000);
			assertEquals(transport.CategorySpend(),1200.85);
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
			final BoCCategory shopping = new BoCCategory(string3,bignum3,bignum4);
			assertEquals(shopping.CategoryName(),"shopping"); 
			assertEquals(shopping.CategoryBudget(),3000);
			assertEquals(shopping.CategorySpend(),4500.45);
			assertEquals(getSecondTimestamp(shopping.CategoryTime()),getSecondTimestamp(current));
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
			final BoCCategory shopping = new BoCCategory(string3,bignum3,bignum4);
			assertEquals(shopping.CategoryName(),"shopping"); 
			assertEquals(shopping.CategoryCategory(),3000);
			assertEquals(shopping.CategoryValue(),4500.45);
			assertEquals(getSecondTimestamp(shopping.CategoryTime()),getSecondTimestamp(current));
		}catch(final Exception e) {
			fail ("Something wrong with catch");
		}
	}
}

public class BoCCategory {
	/* CATEGORY NAME TEST*******************************************************************
	1 – Pass – Yuxiang Zhang - 21:30/02/05  
	Problem: 
	Reason:
	Traceability:CategoryName Test 1
	
	2 – Pass – Yuxiang Zhang - 22:45/02/05  
	Problem: 
	Reason:
	Traceability:CategoryName Test 2
	
	3 – Pass – Yuxiang Zhang - 00:18/02/05  
	Problem: 
	Reason:
	Traceability:CategoryName Test 3
	*/
	@ParameterizedTest
	@MethodSource
	void CategoryNameTest(BoCCategory test,String testValue) throws Exception {
		assertEquals(testValue,test.CategoryName());
	}
	static List<Arguments> CategoryNameTest(){
		return List.of(
				Arguments.arguments(shopping,"shopping"),
				Arguments.arguments(transport,"transport"),
				Arguments.arguments(empty,"[Pending Category]")
		);
	}

}

/* CATEGORY BUDGET TEST*******************************************************************
1 – Pass – Yuxiang Zhang - 14:29/03/05  
Problem: 
Reason:
Traceability:CategoryBudget Test 1

2 – Pass – Yuxiang Zhang - 14:51/03/05  
Problem: 
Reason:
Traceability:CategoryBudget Test 2

3 – Pass – Yuxiang Zhang - 15:32/03/05  
Problem: 
Reason:
Traceability:CategoryBudget Test 3
*/
@ParameterizedTest
@MethodSource
void CategoryBudgetTest(BoCCategory test,BigDecimal testValue) throws Exception {
	assertEquals(testValue,test.CategoryBudgetTest());
}
static List<Arguments> CategoryBudgetTest(){
	return List.of(
			Arguments.arguments(shopping,bignum3),
			Arguments.arguments(transport,bignum1),
			Arguments.arguments(empty,null)
	);
}

/* CATEGORY  SPEND TEST*******************************************************************
1 – Pass – Yuxiang Zhang - 17:14/03/05  
Problem: 
Reason:
Traceability:CategorySpend Test 1
2 – Pass – Yuxiang Zhang - 17:49/03/05  
Problem: 
Reason:
Traceability:CategorySpend Test 2

3 – Pass – Yuxiang Zhang - 19:47/03/05
Problem: 
Reason:
Traceability:CategorySpend Test 3
*/
@ParameterizedTest
@MethodSource
void CategorySpendTest(BoCCategory test,BigDecimal testValue) throws Exception {
	assertEquals(testValue,test.CategorySpendTest());
}
static List<Arguments> CategorySpendTest(){
	return List.of(
			Arguments.arguments(shopping,bignum4),
			Arguments.arguments(transport,bignum2),
			Arguments.arguments(empty,null)
	);
}

class BoCCategoryTest {

	private String TestInputString, TestOutputString;
	private BigDecimal TestInputBudget;
	private BigDecimal TestOutputBudget;
	private BigDecimal TestExceptOutputBudget;
	
	/* – Pass – Hongming PING - 23:38/30/4  
	
	*/
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
	
	/*1. – Fail – Hongming PING - 21:38/2/5
	Problem: If newName is sapce only or empty, the result still returns the value of
	newName, which is Unknown name.
	2. - Pass - 22:57/2/5
	Reason: Fixed the Method with adding an "if" statement to assign null to String 
	while whose newName is empty or sapce
	*/
	@ParameterizedTest
	@ValueSource(strings = {" " ,""})
	void setCNTest23(String TestInputString) throws Exception {
		try {
			BoCCategory copy = new BoCCategory();
			copy.setCategoryName(TestInputString);
			TestOutputString = copy.CategoryName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertNull(TestOutputString);
	}
	
	/* – Pass – Hongming PING - 16:52/1/5  
	
	*/
	@Test
	void setCBTest1(){
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
	
	/* – Pass – Hongming PING - 16:52/1/5  
	
	*/
	@Test
	void setCBTest2(){
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
	
	/* – Pass – Hongming PING - 16:52/1/5  
	
	*/
	@Test
	void setCBTest3(){
		TestInputBudget = new BigDecimal("11.20");
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
