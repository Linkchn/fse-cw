import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;



class mainTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(null);
        outContent.reset();
    }


    @DisplayName("mainTest")
    @ParameterizedTest
    @MethodSource
    void mainTest(String a, String b) {
        String input = a;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BoCApp.main(new String[]{""});
        assertEquals(b, outContent.toString());
    }
    static List<Arguments> mainTest() {
        return List.of( // arguments:
                Arguments.arguments("X\n", "1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" +
                        "2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" +
                        "3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" +
                        "4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" +
                        "\nWhat do you want to do?\n" +
                        "O = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it\r\n" +
                        "Goodbye!\r\n"),
                Arguments.arguments("N\nTestTitle\n6.23\nX\n",
                		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
                		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
                		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
                		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
                		"\n" + 
                		"What do you want to do?\n" + 
                		"O = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it\r\n" + 
                		"What is the title of the category?\r\n" + 
                		"NOTE: It should not be blank and should be at most 15 characters.\r\n" + 
                		"What is the budget for this category?\r\n" + 
                		"Note:It should be a pisitive decimal number with exact two decimal places.\r\n" + 
                		"[Category added]\r\n" + 
                		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
                		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
                		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
                		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
                		"5) TestTitle(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n" + 
                		"\n" + 
                		"What do you want to do?\n" + 
                		"O = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it\r\n" + 
                		"Goodbye!\r\n" 
                		),
                Arguments.arguments("A\nTestTitle\n6.23\nX\n",
                		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
                		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
                		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
                		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
                		"\n" + 
                		"What do you want to do?\n" + 
                		"O = [O]verview\n" + 
                		"T = List All [T]ransactions\n" + 
                		"[num] = Show Category [num]\n" + 
                		"C = [C]hange Transaction Category\n" + 
                		"A = [A]dd Transaction\n" + 
                		"N = [N]ew Category\n" + 
                		"X = E[x]it\r\n" + 
                		"What is the title of the transaction?\r\n" + 
                		"NOTE: It should not be blank and less than 25 characters.\r\n" + 
                		"What is the value of the transaction?\r\n" + 
                		"NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
                		"What is the category of the transaction?\r\n" + 
                		"Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
                		"Something went wrong: java.lang.Exception: Wrong category. It should be an integer between 1 - 4\n" + 
                		"\r\n" + 
                		"\n" + 
                		"What do you want to do?\n" + 
                		"O = [O]verview\n" + 
                		"T = List All [T]ransactions\n" + 
                		"[num] = Show Category [num]\n" + 
                		"C = [C]hange Transaction Category\n" + 
                		"A = [A]dd Transaction\n" + 
                		"N = [N]ew Category\n" + 
                		"X = E[x]it\r\n"),
               Arguments.arguments("O\nX\n",
            		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
               		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
               		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
               		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
               		"\n" + 
               		"What do you want to do?\n" + 
               		"O = [O]verview\n" + 
               		"T = List All [T]ransactions\n" + 
               		"[num] = Show Category [num]\n" + 
               		"C = [C]hange Transaction Category\n" + 
               		"A = [A]dd Transaction\n" + 
               		"N = [N]ew Category\n" + 
               		"X = E[x]it\r\n" + 
               		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
               		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
               		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
               		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
               		"\n" + 
               		"What do you want to do?\n" + 
               		"O = [O]verview\n" + 
               		"T = List All [T]ransactions\n" + 
               		"[num] = Show Category [num]\n" + 
               		"C = [C]hange Transaction Category\n" + 
               		"A = [A]dd Transaction\n" + 
               		"N = [N]ew Category\n" + 
               		"X = E[x]it\r\n" + 
               		"Goodbye!\r\n")

//                Arguments.arguments(""),
//                Arguments.arguments("")
        );
    }
}
