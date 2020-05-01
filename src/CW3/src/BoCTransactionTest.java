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
	1 – Pass – Leo - 14:25/1/5  
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
