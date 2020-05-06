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
    void BoCAppmainTest(String a, String b) {
        String input = a;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BoCApp.main(new String[]{""});
        assertEquals(b, outContent.toString());
    }
    static List<Arguments> BoCAppmainTest() {
    	long timeStamp = System.currentTimeMillis(); 
		SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String sd = sdff.format(new Date(timeStamp));
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
                /*
                 1. Failed - Hongming - 20:55 6/5
                 Reason: If there is an unknown input, the method Integer.parseInt(s) would lead to
                 	crash and the program throws an exception, but not output the "Command not recognised".
                 Change: Add a if statement to lead the program to output "Command not recognised", 
                 	if the input is noit completely constructed by numbers, the statement return false and 
                 	the program output "Command not recognised".
                 2. Passed - Hongming - 21:25 6/5
                 
                 Traceability:  BoCAppmainTest2
                 */
                Arguments.arguments("t\nX\n",
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
                		"Command not recognised\r\n" + 
                		"\n" + 
                		"What do you want to do?\n" + 
                		"O = [O]verview\n" + 
                		"T = List All [T]ransactions\n" + 
                		"[num] = Show Category [num]\n" + 
                		"C = [C]hange Transaction Category\n" + 
                		"A = [A]dd Transaction\n" + 
                		"N = [N]ew Category\n" + 
                		"X = E[x]it\r\n" + 
                		"Goodbye!\r\n"),
                /*
                 1. Passed - Hongming Ping - 22:33 6/5
                 Traceability: BoCAppmainTest5 
                 */
                Arguments.arguments("1\nX\n",
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
                		"Unknown: 1) "+sd+" Rent - ¥850.00\r\n" + 
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
        );
    }
}
