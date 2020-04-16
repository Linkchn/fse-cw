import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MathModuleTest {

    static int input1 = 0;
    static int input2 = 0;
    static int input3 = 0;
    static int input4 = 0;

    @BeforeAll
    static void setup() {
        input1 = 3;
        input2 = 7;
        input3 = 2000000000;
        input4 = 0;
    }

    @Test
    void test1() {
        int myAnswer = 0;
        try {
            myAnswer = MathModule.myMultiply(input1, input2);
        } catch(Exception e) { }
        assertEquals(21, myAnswer);
    }

    @Test
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

    @Test
    void testAssertThrows() {
        assertThrows(Exception.class, ()->{MathModule.myMultiply(input2, input3);});
    }

    @Test
    void test2() {
        int myAnswer = 0;
        try {
            myAnswer = MathModule.myDivide(input2, input1);
        } catch(Exception e) {
            assertThrows(Exception.class, ()->{
                MathModule.myDivide(input2, input1);
            });
        }
        assertEquals(0, myAnswer);
    }

    @Test
    void testDividedBy0() {
        int myAnswer = 0;
        try {
            myAnswer = MathModule.myDivide(input2, input4);
        } catch(Exception e) {
            assertThrows(ArithmeticException.class, ()->{
                MathModule.myDivide(input2, input4);
            });
        }
    }



}