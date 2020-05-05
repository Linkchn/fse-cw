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


    /*
	1 - FAIL - Shiliang - 16:13 1/5
    Change: /
    Reason: Decimals are different
	Traceability: getRemainingBudgetTest 1
	
	2 - PASS - Jiawei Shiliang- 22:35 1/5
    Change: /
    Reason: /
	Traceability: getRemainingBudgetTest 3, 4, 5, 6
	 */
    @DisplayName("AddTransactionTest")
    @ParameterizedTest
    @MethodSource
    void AddTransactionTest(String name, String val, String cat, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Method AddTransactionTest = a.getClass().getDeclaredMethod("AddTransaction", Scanner.class);
        AddTransactionTest.setAccessible(true);

        String input = "\n"+ name + val + cat;
        inp = new Scanner(input);

        try {
            AddTransactionTest.invoke(a, inp);
            BoCTransaction tr = BoCApp.UserTransactions.get(BoCApp.UserTransactions.size()-1);
            if (alert.equals("1")) {
                if (cat.equals("\n")) {
                    cat = cat.replaceAll("\n", "1");
                }
                assertEquals(prompt1 + prompt2 + prompt3 + name.replace("\n", "") + "(¥" + val.replace("\n", "") + ")" + " was added to " + BoCApp.UserCategories.get(Integer.parseInt(cat.replace("\n", "")) - 1).CategoryName() + "\r\n", outContent.toString());
                assertEquals(name.replace("\n", "") ,tr.transactionName());
                assertEquals(new BigDecimal(val.replace("\n", "")) ,tr.transactionValue());
                assertEquals(Integer.parseInt(cat.replace("\n", "")) - 1 ,tr.transactionCategory());
            }
        }
        catch (Exception e) {
            assertEquals(alert, e.getCause().getMessage());

        }
        

        outContent.reset(); 
    }

    static List<Arguments> AddTransactionTest() {
        return List.of( // arguments:
                Arguments.arguments("tran1\n", "1.00\n", "1\n", "1"),
                Arguments.arguments("\n", "2.00\n", "1\n", "Wrong name. It should not be blank!"),
                Arguments.arguments("tran3\n", "\n", "1\n", "Wrong value. It should not be blank!"),
                Arguments.arguments("tran4\n", "4.00\n", "\n", "1"),
                Arguments.arguments("tran5\n", "5.00\n", "6\n", "Wrong category. It should be an integer between 1 - 4"),
                Arguments.arguments("tran6\n", "0.00\n", "3\n", "Wrong value. It should be a positive number with two decimal places e.g. 10.00."),
                Arguments.arguments("tran7\n", "-5.00\n", "2\n", "Wrong value. It should be a positive number with two decimal places e.g. 10.00."),
                Arguments.arguments("tran8\n", "8.00\n", "0\n", "Wrong category. It should be an integer between 1 - 4"),
                Arguments.arguments("tran9\n", "9.00\n", "-1\n", "Wrong category. It should be an integer between 1 - 4"),
                Arguments.arguments("tttttrrrrraaaaannnnn10101\n", "10.00\n", "2\n", "1"),
                Arguments.arguments("tttttrrrrraaaaannnnn111111111111\n", "11.00\n", "1\n", "Wrong name. It should not be more than 25 characters!"),
                Arguments.arguments("tran12\n", "12\n", "2\n", "Wrong value. It should be a positive number with two decimal places e.g. 10.00."),
                Arguments.arguments("   \n", "13.00\n", "3\n", "Wrong name. It should not be blank!"),
                Arguments.arguments("tran14\n", "   \n", "2\n", "Wrong value. It should not be blank!")
        );
    }

    @Test
    void AddCategoryTest() {

    }
}
