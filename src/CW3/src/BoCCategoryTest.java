import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
