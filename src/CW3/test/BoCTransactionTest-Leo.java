package src;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;

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
	*/
	@Test		
	void setNameTest1() {
		testInputString = "Leo";
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString);
			copy.resetCounter();
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testInputString, testOutputString);
	}
	
	/* 
	2 - Pass - Leo - 14:42/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest2
	*/
	@Test
	void setNameTest2() {
		testInputString = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString);
			copy.resetCounter();
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals(testInputString, testOutputString);
	}

	/* 
	3 - Pass - Leo - 15:27/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest3
	*/
	@Test
	void setNameTest3() {
		testInputString = "QWERTYUIOPASDFGHJKLZXCVBNM";
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString);
			copy.resetCounter();
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals("QWERTYUIOPASDFGHJKLZXCVBN", testOutputString);
	}

	/* 
	4 - Pass - Leo - 23:21/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest4
	*/
	@Test
	void setNameTest4() {
		testInputString1 = null;
		testInputString2 = "Leo";
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString1);
			copy.setTransactionName(testInputString2);
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals("Leo", testOutputString);
	}

	/* 
	5 - Pass - Leo - 23:26/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest5
	*/
	@Test
	void setNameTest5() {
		testInputString1 = "Leo";
		testInputString2 = "Leopard";
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString1);
			copy.setTransactionName(testInputString2);
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals("Leo", testOutputString);
	}

	/* 
	6 - Pass - Leo - 23:37/1/5  
	Problem: 
	Reason:
	Traceability: setNameTest6
	*/
	@Test
	void setNameTest6() {
		testInputString1 = "Leo";
		testInputString2 = null;
		try {
			BoCTransaction copy = new BoCTransaction();
			copy.setTransactionName(testInputString1);
			copy.setTransactionName(testInputString2);
			testOutputString = copy.transactionName();
		}catch(Exception e) {
			fail ("Someting wrong with catch");
		}
		assertEquals("Leo", testOutputString);
	}
	
	/* 
	7 - Pass - Leo - 15:50/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest1
	*/
	@Test
	void setValueTest1(){
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

	/* 
	8 - Pass - Leo - 16:55/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest2
	*/
	@Test
	void setValueTest2(){
		testInputBudget = new BigDecimal("123.12");
		testExceptOutputBudget = new BigDecimal("123.12");
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

	/* 
	9 - Pass - Leo - 17:19/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest3
	*/
	@Test
	void setValueTest3(){
		testInputBudget = new BigDecimal("123.123");
		testExceptOutputBudget = null;
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

	/* 
	10 - Pass - Leo - 18:28/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest4
	*/
	@Test
	void setValueTest4(){
		testInputBudget = new BigDecimal("-123.12");
		testExceptOutputBudget = null;
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

	/* 
	11 - Pass - Leo - 23:48/1/5  
	Problem: 
	Reason:
	Traceability: setValueTest5
	*/
	@Test
	void setValueTest5(){
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

	/* 
	12 - Pass - Leo - 00:55/2/5  
	Problem: 
	Reason:
	Traceability: setValueTest6
	*/
	@Test
	void setValueTest6(){
		testInputBudget1 = new BigDecimal("123.13");
		testInputBudget2 = new BigDecimal("123.14");
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
	
	/* 
	13 - Pass - Leo - 19:03/1/5  
	Problem: 
	Reason:
	Traceability: setCatTest1
	*/
	@Test
	void setCatTest1(){
		int testInput = 10;
		int testExceptOutput = 10;
		int testOutput = 0;
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

	/* 
	14 - Pass - Leo - 19:05/1/5  
	Problem: 
	Reason:
	Traceability: setCatTest2
	*/
	@Test
	void setCatTest2(){
		int testInput = -10;
		int testExceptOutput = 0;
		int testOutput = 0;
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

	/* 
	15 - Pass - Leo - 00:59/2/5  
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
	16 - Pass - Leo - 22:21/1/5  
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
	17 - Pass - Leo - 22:23/1/5  
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
	18 - Pass - Leo - 22:37/1/5  
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
