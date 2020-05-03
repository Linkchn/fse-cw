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
