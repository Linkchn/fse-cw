package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BoCTransactionTest {
	private String testInputString, testOutputString, testInputString1, testInputString2;
	private BigDecimal testInputBudget;
	private BigDecimal testInputBudget1;
	private BigDecimal testInputBudget2;
	private BigDecimal testOutputBudget;
	private BigDecimal testExceptOutputBudget;
	
	@Ignore
	void test() {
		fail("Not yet implemented");
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
	void setNameTest(String testInputString, String testExpectOutputString) throws Exception {
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString);
			copy.resetCounter();
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExpectOutputString, testOutputString);
	}
	static List<Arguments> setNameTest(){
		return List.of(
				Arguments.arguments("LEO", "LEO"),
				Arguments.arguments(null, null),
				Arguments.arguments("QWERTYUIOPASDFGHJKLZXCVBNM", "QWERTYUIOPASDFGHJKLZXCVBN")
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
	void setNameTestD(String testInputString1, String testInputString2, String testExpectOutputString) throws Exception {
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString1);
			copy.setTransactionName(testInputString2);
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExpectOutputString, testOutputString);
	}
	static List<Arguments> setNameTestD(){
		return List.of(
				Arguments.arguments(null, "LEO", "LEO"),
				Arguments.arguments("Leo", "Leopard", "Leo"),
				Arguments.arguments("Leo", null, "Leo")
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
			copy.resetCounter();
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
			copy.resetCounter();
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
		SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sd = sdff.format(new Date(timeStamp));
		String testExceptOutput = sd + " Leo - ¥123" ;
		String testOutput = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(tName);
			copy.resetCounter();
			copy.setTransactionValue(tValue);
			copy.resetCounter();
			testOutput = copy.toString();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testExceptOutput, testOutput);
	}
}
