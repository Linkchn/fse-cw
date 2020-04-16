import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

class TestMyMathModule {

    static int input1 = 0;
    static int input2 = 0;
    static int input3 = 0;
    static int input4 = 0;
	@Ignore
	void test() {
		fail("Not yet implemented");
	}
	@Test
	void test1() {
		int myAnswer = 0;
		try {
			myAnswer = MathModule.myMultiply(input1, input2);
			} catch(Exception e) { }
			assertEquals(18, myAnswer);
	}
	@Test
	void testError() {
		int myAnswer1 = 0;
		try {
		myAnswer1 = MathModule.myMultiply(input2, input3);
		} catch(Exception e) {
		if(e.getClass() == Exception.class) {
		return; // it passed
		}
		}
		fail("it failed");
	}
	@Test
	void test2() {
		int myAnswer2 = 0;
		try {
            myAnswer2 = MathModule.myDivide(input2, input4);
        } catch(Exception e) {
            assertThrows(ArithmeticException.class, ()->{
                MathModule.myDivide(input2, input4);
            });
        }
	}
	@BeforeAll
	static void setup() {
	input1 = 3;
	input2 = 6;
	input3 = 2000000000;
	input4 = -2000000000;
	}
}
