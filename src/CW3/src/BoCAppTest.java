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

// define the order of tests
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoCAppTest {

    // set output
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static BoCApp a = null;
    private static Scanner inp;
    private static String prompt1;
    private static String prompt2;
    private static String prompt3;
    private static String prompt4;
    private static String prompt5;
    private static String prompt6;
    private static String prompt7;
    private static String prompt8;
    private static String prompt9;
    private static String allCategory;
    private static String catList;
    private static String alertTitle1;
    private static String alertTitle2;
    private static String alertBudget1;

    @BeforeAll 
    static void setup() {
        a = new BoCApp();

        BoCApp.UserCategories = new ArrayList<BoCCategory>();
        BoCApp.UserTransactions = new ArrayList<BoCTransaction>();

        // SETUP EXAMPLE DATA //
        BoCApp.UserCategories.add(new BoCCategory("Unknown"));

        BoCCategory BillsCategory = new BoCCategory("Bills");
        BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
        BoCApp.UserCategories.add(BillsCategory);

        BoCCategory Groceries = new BoCCategory("Groceries");
        Groceries.setCategoryBudget(new BigDecimal("75.00"));
        BoCApp.UserCategories.add(Groceries);

        BoCCategory SocialSpending = new BoCCategory("Social");
        SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
        BoCApp.UserCategories.add(SocialSpending);

        BoCApp.UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
        BoCApp.UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
        BoCApp.UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
        BoCApp.UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
        BoCApp.UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
        BoCApp.UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
        BoCApp.UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));
    

        prompt1 = new String("What is the title of the transaction?\r\nNOTE: It should not be blank and less than 25 characters.\r\n");
        prompt2 = new String("What is the value of the transaction?\r\nNOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n");
        prompt3 = new String("What is the category of the transaction?\r\nNote: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n");
        prompt4 = new String("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters or it will get first 15 charaters.\r\n");
        prompt5 = new String("What is the budget for this category?\r\nNote:It should be a pisitive decimal number with exact two decimal places.\r\n");
        prompt6 = new String("[Category added]");
        prompt7 = new String("Which transaction ID?\r\n");
        prompt8 = new String("Which category will it move to?\r\n");
        prompt9 = new String("Change complete!\r\n");
        alertTitle1 = new String("Wrong title! It should not be blank.\r\n" + 
        		"What is the title of the category?\r\n" + 
        		"NOTE: It should not be blank and should be at most 15 characters or it will get first 15 charaters.\r\n");
        alertTitle2 = new String("Wrong title! It should not be the same as the existed name.\r\n" + 
        		"What is the title of the category?\r\n" + 
        		"NOTE: It should not be blank and should be at most 15 characters or it will get first 15 charaters.\r\n");
        alertBudget1 = new String("Wrong budget! It should be a positive decimal number with exact two decimal places.\r\n" + 
        		"What is the title of the category?\r\n" + 
        		"NOTE: It should not be blank and should be at most 15 characters.\r\n");
        allCategory = new String("1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n"+
                "2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n"+
                "3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n"+
                "4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n"+
                "5) cat1Name1234567(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n"
                );
                
        for (int x = 0; x < BoCApp.UserTransactions.size(); x++) {
            BoCTransaction temp = BoCApp.UserTransactions.get(x);
            int utCat = temp.transactionCategory();
            BoCCategory temp2 = BoCApp.UserCategories.get(utCat);
            temp2.addExpense(temp.transactionValue());
            BoCApp.UserCategories.set(utCat, temp2);
        }
    }

    // redirect outstream
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterAll
    public static void cleanUpStreams() {
    }

    // reset outstream
    @AfterEach
    void tearDown() {
        System.setOut(null);
        outContent.reset();
    }

    // main test aims to test the functionality of while loop and the if statement
    // it is tested via comparing the expected output to the actual output which in the out put stream
    // if they are same, then every expected function is called successfully and loop, if work well
    @Order(5)
    @DisplayName("mainTest")
    @ParameterizedTest
    @MethodSource
    void mainTest(String a, String b) {
        String input = a;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        // call main for test
        BoCApp.main(new String[]{""});
        // compare output to show if they are successfully called and whether the loop is correct
        assertEquals(b, outContent.toString());
    }
    static List<Arguments> mainTest() {
        long timeStamp = System.currentTimeMillis();
        SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sd = sdff.format(new Date(timeStamp));
        return List.of( // arguments:
                /*
                1 - PASS - Shiliang - 20:55 6/5
                Problem: /
                Reason: /
                Traceability: mainTest1
                 */
                Arguments.arguments("X\n", "1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" +
                        "2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" +
                        "3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" +
                        "4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" +
                        "\nWhat do you want to do?\n" +
                        "O = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it\r\n" +
                        "Goodbye!\r\n"),
                /*
                1 - PASS - Jiawei - 20:55 6/5
                Problem: /
                Reason: /
                Traceability: mainTest6
                 */
                Arguments.arguments("N\nTestTitle\n6.23\nX\n",
                        "1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" +
                                "2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" +
                                "3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" +
                                "4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" +
                                "\n" +
                                "What do you want to do?\n" +
                                "O = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it\r\n" +
                                "What is the title of the category?\r\n" +
                                "NOTE: It should not be blank and should be at most 15 characters or it will get first 15 charaters.\r\n" +
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
                1 - PASS - Shiliang - 20:55 6/5
                Problem: /
                Reason: /
                Traceability: mainTest7
                 */
                Arguments.arguments("A\nTestTitle\n6.23\n1\nX\n",
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
                                "TestTitle(¥6.23) was added to Unknown\r\n" +
                                "\n" +
                                "What do you want to do?\n" +
                                "O = [O]verview\n" +
                                "T = List All [T]ransactions\n" +
                                "[num] = Show Category [num]\n" +
                                "C = [C]hange Transaction Category\n" +
                                "A = [A]dd Transaction\n" +
                                "N = [N]ew Category\n" +
                                "X = E[x]it\r\n"+
                                "Goodbye!\r\n"),
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
                                "Goodbye!\r\n"),
               /*
               1. FAIL - Hongming - 20:55 6/5
               Reason: If there is an unknown input, the method Integer.parseInt(s) would lead to
               	crash and the program throws an exception, but not output the "Command not recognised".
               Change: Add a if statement to lead the program to output "Command not recognised",
               	if the input is noit completely constructed by numbers, the statement return false and
               	the program output "Command not recognised".

               2. PASS - Hongming - 21:25 6/5

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
               Reason:/
               Change:/
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
                                "Goodbye!\r\n"),
                /*
                1. Passed - Hongming Ping - 13:18 7/5
                Reason:/
                Change:/
                Traceability: BoCAppmainTest5
                */
                Arguments.arguments("O\nt\nT\n1\nC\n1\n3\nA\nTestTitle\n6.23\n1\nN\nTestTitle\n6.23\nX\n",
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
                                "1) "+sd+" Rent - ¥850.00\r\n" + 
                                "2) "+sd+" Phone Bill - ¥37.99\r\n" + 
                                "3) "+sd+" Electricity Bill - ¥75.00\r\n" + 
                                "4) "+sd+" Sainsbury's Checkout - ¥23.76\r\n" + 
                                "5) "+sd+" Tesco's Checkout - ¥7.24\r\n" + 
                                "6) "+sd+" RockCity Drinks - ¥8.50\r\n" + 
                                "7) "+sd+" The Mooch - ¥13.99\r\n" + 
                                ""+
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
                                "Which transaction ID?\r\n" + 
                        		"	- "+ sd+
                        		" Rent - ¥850.00\r\n" + 
                        		"Which category will it move to?\r\n" + 
                        		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
                        		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
                        		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
                        		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
                        		"Change complete!\r\n" + 
                        		"Target category: 3) Groceries(¥75.00) - Est. ¥881.00 (¥806.00 Overspent)\r\n" + 
                        		"Origin category: 1) Unknown(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)\r\n" +                         	
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
                                "TestTitle(¥6.23) was added to Unknown\r\n" +
                                "\n" +
                                "What do you want to do?\n" +
                                "O = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it\r\n" +
                                "What is the title of the category?\r\n" +
                                "NOTE: It should not be blank and should be at most 15 characters or it will get first 15 charaters.\r\n" +
                                "What is the budget for this category?\r\n" +
                                "Note:It should be a pisitive decimal number with exact two decimal places.\r\n" +
                                "[Category added]\r\n" +
                                "1) Unknown(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)\r\n" +
                                "2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" +
                                "3) Groceries(¥75.00) - Est. ¥881.00 (¥806.00 Overspent)\r\n" +
                                "4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" +
                                "5) TestTitle(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n" +
                                "\n" +
                                "What do you want to do?\n" +
                                "O = [O]verview\n" +
                                "T = List All [T]ransactions\n" +
                                "[num] = Show Category [num]\n" +
                                "C = [C]hange Transaction Category\n" +
                                "A = [A]dd Transaction\n" +
                                "N = [N]ew Category\n" +
                                "X = E[x]it\r\n" +
                                "Goodbye!\r\n"
                		)

        );
    }

    /*
    5 – Pass – Leo - 21:18/6/5  
	Problem: /
	Reason:/
	Traceability: mainTest5
     */
    @Order(6)
    @DisplayName("mainTest5")
    @ParameterizedTest
    @MethodSource
    void mainTest5(String a, String b, String c) {
        String input = a;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        long timeStamp = System.currentTimeMillis(); 
		SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String sd = sdff.format(new Date(timeStamp));
        BoCApp.main(new String[]{""});
        assertEquals(b + sd + c, outContent.toString());
    }
    static List<Arguments> mainTest5() {
        return List.of( // arguments:
                Arguments.arguments("C\n1\n3\nX\n",
                		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
                		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
                		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
                		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
                		"\n" + 
                		"What do you want to do?\n" + 
                		"O = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it\r\n" +
                		"Which transaction ID?\r\n" + 
                		"	- ", 
                		" Rent - ¥850.00\r\n" + 
                		"Which category will it move to?\r\n" + 
                		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
                		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
                		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
                		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
                		"Change complete!\r\n" + 
                		"Target category: 3) Groceries(¥75.00) - Est. ¥881.00 (¥806.00 Overspent)\r\n" + 
                		"Origin category: 1) Unknown(¥0.00) - Est. ¥0.00 (¥0.00 Remaining)\r\n" + 
                		"\n" + 
                		"What do you want to do?\n" + 
                		"O = [O]verview\nT = List All [T]ransactions\n[num] = Show Category [num]\nC = [C]hange Transaction Category\nA = [A]dd Transaction\nN = [N]ew Category\nX = E[x]it\r\n" + 
                		"Goodbye!\r\n")
        );
    }
    
    /*
    1. Failed Hongming Ping 22:14/4/5
    Reason: The output doesn't include the name of Category as required.
    If a number larger than bound is input, no tips is output. 
    2. Failed Hongming Ping 17:48/5/5
    Reason: The output doesn't include the name of Category as required.
    Change: The problem of out of bound has been solved.
    3. Passed Hongming Ping 20:45/5/5
    Traceability: listTransactionsForCategoryTest
    */
    @Order(3)
   @ParameterizedTest
   @MethodSource
   void listTransactionsForCategoryTest(int CategoryNum, String ExpectedOutput) throws Exception {
       BoCApp.ListTransactionsForCategory(CategoryNum);
       assertEquals(ExpectedOutput, outContent.toString());
   }
   static List<Arguments> listTransactionsForCategoryTest(){
		long timeStamp = System.currentTimeMillis(); 
		SimpleDateFormat sdff=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String sd = sdff.format(new Date(timeStamp));
		return List.of(
               Arguments.arguments(1,"Unknown: 1) "+sd+" Rent - ¥850.00\r\n"),
               Arguments.arguments(2,"Bills: 2) "+sd+" Phone Bill - ¥37.99\r"+'\n'+"Bills: 3) "+sd+" Electricity Bill - ¥75.00\r"+'\n'),
               Arguments.arguments(3,"Groceries: 4) "+sd+" Sainsbury's Checkout - ¥23.76\r"+'\n'+"Groceries: 5) "+sd+" Tesco's Checkout - ¥7.24\r"+'\n'),
               Arguments.arguments(4,"Social: 6) "+sd+" RockCity Drinks - ¥8.50\r"+'\n'+"Social: 7) "+sd+" The Mooch - ¥13.99\r"+'\n'),
               Arguments.arguments(5,"The Category doesn't exit\r"+'\n')
       );
   }

    /*
    1 - FAIL - Shiliang - 23:15 4/5
    Problem:1. Category cant be correctly set up 
            2. prompt message is different 
            3. Confirmation message is different
            4. It does not alert and stop
            5. an invocation exception
            6. no exception thrown
            7. category set is wrong 
            8. BigDecimal went wrong
    Reason: 1. No category input is set up 
            2. The original message does not match new expected one 
            3. Confirmation message has not been created yet
            4. Exception catcher has not been created yet
            5. BigDecimal get a ""
            6. blank input has not been banned
    Traceability: addTransactionTest 1 - 14
    
    2 - PASS - Jiawei Shiliang - 16:15 5/5
    Problem: /
    Reason: 1. Add a module for category setup, updated the prompt message string, reconstructed confirmation message
            2. Add if statement for exception throw
            3. Adjust \n to proper places
            4. modified category setup and messages
            5. add if for "   " situation
    Traceability: addTransactionTest 1' - 3', 5' - 14'

    3 - FAIL - Jiawei Shiliang - 16:15 5/5
    Problem: the third argument went wrong
    Reason: haven't handled \n
    Traceability: addTransactionTest 4'

    4 - PASS - Shiliang - 16:31 5/5
    Problem: /
    Reason: add if for "" situation (blank input)
    Traceability: addTransactionTest 4''
     */
   @Order(7)
   @DisplayName("AddTransactionTest")
   @ParameterizedTest
   @MethodSource
   void AddTransactionTest(String name, String name1, String val, String val1, String cat, String cat1, String exp, String eval) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
       // prepare for calling a private method
       Method AddTransactionTest = a.getClass().getDeclaredMethod("AddTransaction", Scanner.class);
       AddTransactionTest.setAccessible(true);

       // create an input stream from expected inputs
       String input = "\n"+ name + name1 + val + val1 + cat + cat1;
       inp = new Scanner(input);

       
       AddTransactionTest.invoke(a, inp);
       BoCTransaction tr = BoCApp.UserTransactions.get(BoCApp.UserTransactions.size()-1);
       
       
       // compare the prompt message and confirmation message
       assertEquals(exp, outContent.toString());
       // compare the name, value and category
       String eName = (name + name1).replaceAll("\n", "").replaceAll(" ", "");
       if (eName.length() > 25) {
    	   eName = eName.substring(0,25);
       }
       assertTrue(eName.equals(tr.transactionName()));
       assertEquals(new BigDecimal(eval) ,tr.transactionValue());
       assertEquals(0 ,tr.transactionCategory());
       
       
       
   }

   // list of arguments which will be taken by the above method
   static List<Arguments> AddTransactionTest() {
       return List.of( // arguments:
               Arguments.arguments("tran1\n", "", "1.00\n", "", "1\n", "", "What is the title of the transaction?\r\n" + 
               		"NOTE: It should not be blank and less than 25 characters.\r\n" + 
               		"What is the value of the transaction?\r\n" + 
               		"NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
               		"What is the category of the transaction?\r\n" + 
               		"Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
               		"tran1(¥1.00) was added to Unknown\r\n", "1.00"),
               Arguments.arguments("\n", "tran2\n", "2.00\n", "", "1\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "Wrong name. It should not be blank!\r\n" + 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran2(¥2.00) was added to Unknown\r\n", "2.00"),
               Arguments.arguments("tran3\n", "", "\n", "3.00\n", "1\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "Wrong value. It should not be blank!\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran3(¥3.00) was added to Unknown\r\n", "3.00"),
               Arguments.arguments("tran4\n", "", "4.00\n", "", "\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran4(¥4.00) was added to Unknown\r\n", "4.00"),
               Arguments.arguments("tran5\n", "", "5.00\n", "", "6\n", "1\n", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "Wrong category. It should be an integer between 1 - 4\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran5(¥5.00) was added to Unknown\r\n", "5.00"),
               Arguments.arguments("tran6\n", "", "0.00\n", "6.00\n", "1\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "Wrong value. It should be a positive number with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran6(¥6.00) was added to Unknown\r\n" + 
            		   "", "6.00"),
               Arguments.arguments("tran7\n", "", "-5.00\n", "7.00\n", "1\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "Wrong value. It should be a positive number with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" +  
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran7(¥7.00) was added to Unknown\r\n" + 
            		   "", "7.00"),
               Arguments.arguments("tran8\n", "", "8.00\n", "", "0\n", "1\n", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "Wrong category. It should be an integer between 1 - 4\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran8(¥8.00) was added to Unknown\r\n" + 
            		   "", "8.00"),
               Arguments.arguments("tran9\n", "", "9.00\n", "", "-1\n", "1\n", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "Wrong category. It should be an integer between 1 - 4\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran9(¥9.00) was added to Unknown\r\n" + 
            		   "", "9.00"),
               Arguments.arguments("tttttrrrrraaaaannnnn10101\n", "", "10.00\n", "", "1\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tttttrrrrraaaaannnnn10101(¥10.00) was added to Unknown\r\n" + 
            		   "", "10.00"),
               Arguments.arguments("tttttrrrrraaaaannnnn111111111111\n", "", "11.00\n", "", "1\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tttttrrrrraaaaannnnn11111(¥11.00) was added to Unknown\r\n" + 
            		   "", "11.00"),
               Arguments.arguments("tran12\n", "", "12\n", "12.00\n", "1\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "Wrong value. It should be a positive number with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran12(¥12.00) was added to Unknown\r\n" + 
            		   "", "12.00"),
               Arguments.arguments("   \n", "tran13\n", "13.00\n", "", "1\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "Wrong name. It should not be blank!\r\n" + 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran13(¥13.00) was added to Unknown\r\n" + 
            		   "", "13.00"),
               Arguments.arguments("tran14\n", "", "   \n", "14.00\n", "1\n", "", 
            		   "What is the title of the transaction?\r\n" + 
            		   "NOTE: It should not be blank and less than 25 characters.\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "Wrong value. It should not be blank!\r\n" + 
            		   "What is the value of the transaction?\r\n" + 
            		   "NOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n" + 
            		   "What is the category of the transaction?\r\n" + 
            		   "Note: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n" + 
            		   "tran14(¥14.00) was added to Unknown\r\n" + 
            		   "", "14.00")
       );
	}
		
   /* 
	1 - Pass - Leo - 00:18/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest1,2,3,4
	
	2 - Pass - Leo - 00:48/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest5ï¼Œ6
	*/
	@DisplayName("ChangeTransactionCategoryTest")
	@ParameterizedTest
	@MethodSource
	void ChangeTransactionCategoryTest(String tID, String newCat, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	    Method ChangeTransactionCategoryTest = a.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
	    ChangeTransactionCategoryTest.setAccessible(true);
	    
	    try {
		    if(alert.equals("1")) {
			    String input = "\n" + tID + "\n" + newCat + "\n";
			    inp = new Scanner(input);
			    catList = "1) " + BoCApp.UserCategories.get(0).toString() + "\r\n";
		    	for (int x = 1; x < BoCApp.UserCategories.size(); x++) {
					BoCCategory temp = BoCApp.UserCategories.get(x);
					catList += (x+1) + ") " + temp.toString() + "\r\n";
				}
		    	int tIDi = Integer.parseInt( tID )-1;
		    	int newCati = Integer.parseInt( newCat )-1;
			    
		    	BoCTransaction temp = BoCApp.UserTransactions.get(tIDi);
				int oldCat = temp.transactionCategory();
		    	
	        	ChangeTransactionCategoryTest.invoke(a, inp);
	        	BoCCategory newCatSpend = BoCApp.UserCategories.get(newCati);
	        	BoCCategory oldCatSpend = BoCApp.UserCategories.get(oldCat);
	            assertEquals(prompt7 + "\t- " + BoCApp.UserTransactions.get( tIDi ).toString() + "\r\n" + prompt8 + catList + prompt9 + "Target category: " + (newCati + 1) + ") " + newCatSpend.toString() + "\r\n" + "Origin category: " + (oldCat + 1) + ") " + oldCatSpend.toString() + "\r\n", outContent.toString());
	            assertEquals(newCati, temp.transactionCategory());
		    }
	    }
	    catch (Exception e) {
           assertEquals(alert, e.getCause().getMessage());
       }
       
	    outContent.reset(); 
	}
	static List<Arguments> ChangeTransactionCategoryTest() {
       return List.of( // arguments:
               Arguments.arguments("1", "3", "1"),
               Arguments.arguments("1", "1", "1"),
               Arguments.arguments("4", "2", "1"),
               Arguments.arguments("4", "3", "1"),
               Arguments.arguments("7", "1", "1"),
               Arguments.arguments("7", "4", "1")
       );
   }
	
	/* 
	1 - Pass - Leo - 11:38/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest7, 8, 9, 10
	*/
	@DisplayName("ChangeTransactionCategoryTest")
	@ParameterizedTest
	@MethodSource
	void ChangeTransactionCategoryTestD(String tID1, String tID2, String newCat, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	    Method ChangeTransactionCategoryTest = a.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
	    ChangeTransactionCategoryTest.setAccessible(true);
	    
	    try {
		    if(alert.equals("1")) {
			    String input = "\n" + tID1 + "\n" + tID2 + "\n" + newCat + "\n";
			    inp = new Scanner(input);
			    catList = "1) " + BoCApp.UserCategories.get(0).toString() + "\r\n";
		    	for (int x = 1; x < BoCApp.UserCategories.size(); x++) {
					BoCCategory temp = BoCApp.UserCategories.get(x);
					catList += (x+1) + ") " + temp.toString() + "\r\n";
				}
		    	int tIDi = Integer.parseInt( tID2 )-1;
		    	int newCati = Integer.parseInt( newCat )-1;
			    
		    	BoCTransaction temp = BoCApp.UserTransactions.get(tIDi);
				int oldCat = temp.transactionCategory();
		    	
	        	ChangeTransactionCategoryTest.invoke(a, inp);
	        	BoCCategory newCatSpend = BoCApp.UserCategories.get(newCati);
	        	BoCCategory oldCatSpend = BoCApp.UserCategories.get(oldCat);
	            assertEquals(prompt7 + "Please input valid transaction value!\r\n" + "Which transaction ID?\r\n" + "\t- " + BoCApp.UserTransactions.get( tIDi ).toString() + "\r\n" + prompt8 + catList + prompt9 + "Target category: " + (newCati + 1) + ") " + newCatSpend.toString() + "\r\n" + "Origin category: " + (oldCat + 1) + ") " + oldCatSpend.toString() + "\r\n", outContent.toString());
	            assertEquals(newCati, temp.transactionCategory());
		    }
	    }
	    catch (Exception e) {
           assertEquals(alert, e.getCause().getMessage());
       }
       
	    outContent.reset(); 
	}
	static List<Arguments> ChangeTransactionCategoryTestD() {
       return List.of( // arguments:
               Arguments.arguments("100", "1", "3", "1"),
               Arguments.arguments(" ", "1", "1", "1"),
               Arguments.arguments("-5", "7", "2", "1"),
               Arguments.arguments("", "7", "4", "1")
       );
   }
	

	/* 
	1 - Pass - Leo - 12:42 /6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest11, 12, 13, 14
	*/
	@DisplayName("ChangeTransactionCategoryTest")
	@ParameterizedTest
	@MethodSource
	void ChangeTransactionCategoryTestC(String tID, String newCat1, String newCat2, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	    Method ChangeTransactionCategoryTest = a.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
	    ChangeTransactionCategoryTest.setAccessible(true);
	    
	    try {
		    if(alert.equals("1")) {
			    String input = "\n" + tID + "\n" + newCat1 + "\n" + newCat2 + "\n";
			    inp = new Scanner(input);
			    catList = "1) " + BoCApp.UserCategories.get(0).toString() + "\r\n";
		    	for (int x = 1; x < BoCApp.UserCategories.size(); x++) {
					BoCCategory temp = BoCApp.UserCategories.get(x);
					catList += (x+1) + ") " + temp.toString() + "\r\n";
				}
		    	int tIDi = Integer.parseInt( tID )-1;
		    	int newCati = Integer.parseInt( newCat2 )-1;
			    
		    	BoCTransaction temp = BoCApp.UserTransactions.get(tIDi);
				int oldCat = temp.transactionCategory();
		    	
	        	ChangeTransactionCategoryTest.invoke(a, inp);
	        	BoCCategory newCatSpend = BoCApp.UserCategories.get(newCati);
	        	BoCCategory oldCatSpend = BoCApp.UserCategories.get(oldCat);
	            assertEquals(prompt7 + "\t- " + BoCApp.UserTransactions.get( tIDi ).toString() + "\r\n" + prompt8 + catList + "Please input valid category!\r\n" + prompt8 + catList + prompt9 + "Target category: " + (newCati + 1) + ") " + newCatSpend.toString() + "\r\n" + "Origin category: " + (oldCat + 1) + ") " + oldCatSpend.toString() + "\r\n", outContent.toString());
	            assertEquals(newCati, temp.transactionCategory());
		    }
	    }
	    catch (Exception e) {
           assertEquals(alert, e.getCause().getMessage());
       }
       
	    outContent.reset(); 
	}
	static List<Arguments> ChangeTransactionCategoryTestC() {
       return List.of( // arguments:
               Arguments.arguments("1", "100", "3", "1"),
               Arguments.arguments("1", " ", "1", "1"),
               Arguments.arguments("7", "-5", "2", "1"),
               Arguments.arguments("7", "", "4", "1")
       );
   }

    
    /*
    1 - FAIL - 14:06 5/6 - Jiawei
    Problem:1. prompt message is different 
            2. It does not alert and stop
            3. an invocation exception
            4. no exception thrown
    Reason: 1. The original message does not match new expected one 
            2. Confirmation message has not been created yet
            3. Exception catcher has not been created yet
            4. blank input has not been banned
    Traceability: AddCategoryTest

    2 - PASS - 14:06 5/6 - Jiawei
    Problem:/
    Reason: 1. modify the prompt message
            2. throw some new exceptions the avoid illegal input
            3. modify the alert message
    3 - FAIL - 14:06 5/6 - Jiawei
    Problem: the code does not stop when budget is 0
    Reason: miss a test that the budget is 0
    TraceabilityL AddCategoryTest

    4 - PASS - 14:06 5/6 - Jiawei
    Problem: /
    Reason: /
    Traceability: AddCategoryTest
     */
	@Order(4)
    @DisplayName("AddCategoryTest1")
    @ParameterizedTest
    @MethodSource
    void AddCategoryTest1(String name, String budget, String alert) throws IllegalAccessException, 
    IllegalArgumentException, InvocationTargetException, 
    NoSuchMethodException, SecurityException {
        Method AddCategoryTest = a.getClass().getDeclaredMethod("AddCategory", Scanner.class);
        AddCategoryTest.setAccessible(true);
        String input = "\n" + name + budget;
        if(name.length()>15) {
        	name = name.substring(0, 15);
        }
        inp = new Scanner(input);
        try {
            AddCategoryTest.invoke(a, inp);
            BoCCategory tr = BoCApp.UserCategories.get(BoCApp.UserCategories.size()-1);
            if (alert.equals("1")) {
                assertEquals(prompt4 + prompt5 + prompt6 + "\r\n" + allCategory, outContent.toString());
                assertEquals(name.replace("\n", "") ,tr.CategoryName());
                assertEquals(new BigDecimal(budget.replace("\n", "")) ,tr.CategoryBudget());
            }
        }
        catch (Exception e) {

            assertEquals(alert, e.getCause().getMessage());
        }
    }

    static List<Arguments> AddCategoryTest1() {
        return List.of( // arguments:
        Arguments.arguments("cat1Name123456789\n","6.23\n","1")

        );
    }
    @Order(5)
    @DisplayName("AddCategoryTest2")
    @ParameterizedTest
    @MethodSource
    void AddCategoryTest2(String illName, String name, String illBudget, String budget, String alert, String alertTit, String alertBud, String allCategory2) throws IllegalAccessException, 
    IllegalArgumentException, InvocationTargetException, 
    NoSuchMethodException, SecurityException {
        Method AddCategoryTest = a.getClass().getDeclaredMethod("AddCategory", Scanner.class);
        AddCategoryTest.setAccessible(true);
        String input = "\n" + illName + name + illBudget + budget;
        if(name.length()>15) {
        	name = name.substring(0, 15);
        }
        inp = new Scanner(input);
        try {
            AddCategoryTest.invoke(a, inp);
            BoCCategory tr = BoCApp.UserCategories.get(BoCApp.UserCategories.size()-1);
            if (alert.equals("1")) {
                assertEquals(prompt4 +alertTit+ prompt5 +alertBud+ prompt6 + "\r\n" + allCategory2, outContent.toString());
                assertEquals(name.replace("\n", "") ,tr.CategoryName());
                assertEquals(new BigDecimal(budget.replace("\n", "")) ,tr.CategoryBudget());
            }
        }
        catch (Exception e) {

            assertEquals(alert, e.getCause().getMessage());
        }
    }

    static List<Arguments> AddCategoryTest2() {
        return List.of( // arguments:
        Arguments.arguments("\n","cat1Name\n","6\n","6.00\n", "1",alertTitle1 ,alertBudget1 ,
        		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
        		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
        		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
        		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
        		"5) cat1Name1234567(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n" + 
        		"6) cat1Name(¥6.00) - Est. ¥0.00 (¥6.00 Remaining)\r\n" ),
        Arguments.arguments("   \n","cat2Name\n","ads\n","6.23\n", "1",alertTitle1 ,alertBudget1 ,
        		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
        		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
        		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
        		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
        		"5) cat1Name1234567(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n" + 
        		"6) cat1Name(¥6.00) - Est. ¥0.00 (¥6.00 Remaining)\r\n" + 
        		"7) cat2Name(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n"  ),
        Arguments.arguments("cat2Name\n","cat3Name\n","-7.23\n","34.53\n", "1",alertTitle2 ,alertBudget1 ,
        		"1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n" + 
        		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n" + 
        		"3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n" + 
        		"4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n" + 
        		"5) cat1Name1234567(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n" + 
        		"6) cat1Name(¥6.00) - Est. ¥0.00 (¥6.00 Remaining)\r\n" + 
        		"7) cat2Name(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n" + 
        		"8) cat3Name(¥34.53) - Est. ¥0.00 (¥34.53 Remaining)\r\n")
        );
    }
}
