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
    private static BoCApp b = null;
    private static BoCApp addCat1;
    private static Scanner inp;
    private static Scanner inp2;
    private static String prompt1;
    private static String prompt2;
    private static String prompt3;
    private static String prompt4;
    private static String prompt5;
    private static String prompt6;
    private static String allCategory;

    


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
        b = new BoCApp();
        prompt1 = new String("What is the title of the transaction?\r\nNOTE: It should not be blank and less than 25 characters.\r\n");
        prompt2 = new String("What is the value of the transaction?\r\nNOTE: It should be greater than 0 with two decimal places e.g. 10.00.\r\n");
        prompt3 = new String("What is the category of the transaction?\r\nNote: It should be the index number of a categoryType from above. Type \"1\" or press enter for the Unknown category.\r\n");
        prompt4 = new String("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters.\r\n");
        prompt5 = new String("What is the budget for this category?\r\nNote:It should be a pisitive decimal number with exact two decimal places.\r\n");
        prompt6 = new String("[Category added]");
        allCategory = new String("1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n"+
        		"2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n"+
        "3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n"+
        "4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n"+
        "5) cat1Name(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n"
        		);
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    public void tearDown() {
        outContent.reset();
    }

    @Test
    void mainTest() {
        String input = "A\nABC\n10.00\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BoCApp.main(new String[]{"X\n"});
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
	
	2 - PASS - Jiawei Shiliang- 16:15 5/5
    Problem: /
    Reason: 1. Add a module for category setup, updated the prompt message string, reconstructed confirmation message
            2. Add if statement for exception throw
            3. Adjust \n to proper places
            4. modified category setup and messages
            5. add if for "   " situation
    Traceability: addTransactionTest 1' - 3', 5' - 14'

    3 - FAIL - Jiawei Shiliang- 16:15 5/5
    Problem: the third argument went wrong
    Reason: haven't handled \n
    Traceability: addTransactionTest 4'

	4 - PASS - Shiliang- 16:31 5/5
    Problem: /
    Reason: add if for "" situation (blank input)
	Traceability: addTransactionTest 4''
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

    @DisplayName("AddCategoryTest")
    @ParameterizedTest
    @MethodSource
    void AddCategoryTest(String name, String budget, String alert) throws IllegalAccessException, 
    IllegalArgumentException, InvocationTargetException, 
    NoSuchMethodException, SecurityException {
        Method AddCategoryTest = b.getClass().getDeclaredMethod("AddCategory", Scanner.class);
        AddCategoryTest.setAccessible(true);
        String input = "\n" + name + budget;
        inp2 = new Scanner(input);
        try {
            AddCategoryTest.invoke(b, inp2);
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
    	
    	
        outContent.reset(); 
    	 

    }
    static List<Arguments> AddCategoryTest() {
    	return List.of( // arguments:
    			Arguments.arguments("cat1Name\n","6.23\n","1"),
    			Arguments.arguments("cat2Name123456789\n","6.23\n", "Wrong title! It should be at most 15 characters."),
    			Arguments.arguments("cat1Name\n", "7.45\n", "Wrong title! It should not be the same as the existed name."),
    			Arguments.arguments("cat4Name\n", "6\n", "Wrong budget! It should be a positive decimal number with exact two decimal places."),
    			Arguments.arguments("cat5Name\n", "6.1\n", "Wrong budget! It should be a positive decimal number with exact two decimal places."),
    			Arguments.arguments("cat6Name\n", "-7.23\n", "Wrong budget! It should be a positive decimal number with exact two decimal places."),
    			Arguments.arguments("\n", "6.34\n", "Wrong title! It should not be blank."),
    			Arguments.arguments("   \n", "6.34\n", "Wrong title! It should not be blank."),
    			Arguments.arguments("cat9Name\n", "\n", "Wrong budget! It should not be blank."),
    			Arguments.arguments("cat10Name\n", "   \n", "Wrong budget! It should not be blank.")
        );
    }
    
}
