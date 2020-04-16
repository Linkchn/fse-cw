import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestMyMathModule {
	private static int input1, input2, input3;
	@BeforeAll 
	static void setup() {
		input1 = 3;  
		input2 = 6; 
		input3 = 2000000000;
	}
	
	@Ignore
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void test1() throws Exception {
	int myAnswer = 0;
	try {
		myAnswer=MathModule.myMultiply(input2, input3);
	}catch(Exception e) {
		
	}
	assertEquals(12000000000, myAnswer); 
}

void testError() {  
	int myAnswer = 0;
	try {   
		myAnswer = MathModule.myMultiply(input2, input3);
	} catch(Exception e) {   
		if(e.getClass() == Exception.class) {    
			return; // it passed   
		} 
	} 
	fail("it failed"); 
}
	
	void test2() throws Exception {
		double myAnswer = 0;
		try {
			myAnswer=MathModule.myDivsion(20, 3);
		}catch(Exception e) {
			
		}
		assertEquals(6.67, myAnswer); 
	}
		
	void testError() {  
		double myAnswer = 0;
		try {   
			myAnswer = MathModule.myDivsion(20, 1);
		} catch(Exception e) {   
			if(e.getClass() == Exception.class) {    
				return; // it passed   
			} 
		} 
		fail("it failed"); 
	}
}