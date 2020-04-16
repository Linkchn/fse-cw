import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MathModuleTest {

    static int input1 = 0;
    static int input2 = 0;

    @BeforeAll
    static void setup() {
        input1 = 3;
        input2 = 6;
    }

    @Test
    void test1() {
        int myAnswer = MathModule.myMultiply(input1, input2);
        assertEquals(18, myAnswer);
    }


}