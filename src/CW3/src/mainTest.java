package src;

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
	
    @DisplayName("mainTest5")
    @ParameterizedTest
    @MethodSource
    void mainTest5(String a, String b) {
        String input = a;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BoCApp.main(new String[]{""});
        assertEquals(b, outContent.toString());
    }
    static List<Arguments> mainTest() {
        return List.of( // arguments:
                Arguments.arguments("C\n1\n3\nX\n","1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
                		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
                		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
                		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
                		"\n" + 
                		"What do you want to do?\n" + 
                		" T = List All [T]ransactions, [num] = Show Category [num], A = [A]dd Transaction, X = E[x]it\r\n" +
                		"Which transaction ID?\r\n" + 
                		"	- Rent - ¥850.00		2020-05-06 20:08:26\r\n" + 
                		"Which category will it move to?\r\n" + 
                		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
                		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
                		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
                		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
                		"Change complete!\r\n" + 
                		"Target category: 3) Groceries(¥75.00) - Est. ¥881.00 (¥806.00 Overspent)\r\n" + 
                		"Origin category: 1) Unknown(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)\r\n" + 
                		"\r\n" + 
                		"What do you want to do?\r\n" + 
                		" O = [O]verview, T = List All [T]ransactions, [num] = Show Category [num], C = [C]hange Transaction Category, A = [A]dd Transaction, N = [N]ew Category, X = E[x]it\r\n" + 
                		"Goodbye!\r\n")
        );
    }
}
