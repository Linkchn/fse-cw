import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class BoCAppTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 

    private static BoCApp a = null;
    private static Scanner inp;
    private static String prompt1;
    private static String prompt2;
    private static String prompt3;


    @BeforeAll 
    static void setup() {
        System.setOut(new PrintStream(outContent)); 


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
        

        a = new BoCApp();

        prompt1 = new String("What is the title of the transaction?\r\nNOTE: It should not be blank and less than 25 characters.\r\n");
        prompt2 = new String("What is the value of the transaction?\r\nNOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n");
        prompt3 = new String("What is the category of the transaction?\r\nNote: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n");
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    public void tearDown() {
        outContent.reset();
    }



    @DisplayName("AddTransactionTest")
    @ParameterizedTest
    @MethodSource
    void AddTransactionTest(String name, String val, String cat, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Method AddTransactionTest = a.getClass().getDeclaredMethod("AddTransaction", Scanner.class);
        AddTransactionTest.setAccessible(true);

        String input = "\n" + name + "\n" + val + "\n" + cat + "\n";
        inp = new Scanner(input);
        try {
            AddTransactionTest.invoke(a, inp);
            if (alert.equals("1")) {
                assertEquals(prompt1 + prompt2 + prompt3 + name + "(¥" + val + ")" + " was added to " + BoCApp.UserCategories.get(Integer.parseInt(cat) - 1).CategoryName() + "\r\n", outContent.toString());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            assertEquals(alert, e);
        }
        

        outContent.reset(); 
    }

    static List<Arguments> AddTransactionTest() {
        return List.of( // arguments:
                Arguments.arguments("tran1", "1.00", "1", "1"),
                Arguments.arguments("\n", "2.00", "1", "Wrong name. It should not be blank!"),
                Arguments.arguments("tran3", "\n", "1", "Wrong value. It should not be blank!"),
                Arguments.arguments("tran4", "4.00", "\n", "1"),
                Arguments.arguments("tran5", "5.00", "6", "Wrong category. It should be an integer between 1 - 4"),
                Arguments.arguments("tran6", "0.00", "3", "Wrong value. It should be a number greater than 0!"),
                Arguments.arguments("tran7", "-5.00", "2", "Wrong value. It should be a number greater than 0!"),
                Arguments.arguments("tran8", "8.00", "0", "Wrong category. It should be a number between 1 - 4"),
                Arguments.arguments("tran9", "9.00", "-1", "Wrong category. It should be an integer between 1 - 4"),
                Arguments.arguments("tttttrrrrraaaaannnnn10101", "10.00", "1", "1"),
                Arguments.arguments("tttttrrrrraaaaannnnn111111111111", "11.00", "1", "Wrong name. It should not be more than 25 characters!"),
                Arguments.arguments("tran12", "12", "2", "Wrong value. It should have two decimal places e.g. 10.00!")
        );
    }

    @Test
    void AddCategoryTest() {

    }
}
