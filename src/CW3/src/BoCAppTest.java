import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


class BoCAppTest {
    
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	private static BoCApp a = null;
    static BoCApp addCat1;
    private static Scanner inp;
    private static String prompt1;
    private static String prompt2;
	private static String prompt3;
	
    @BeforeAll 
    static void setup() {
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
		
		for (int x = 0; x < BoCApp.UserTransactions.size(); x++) {
			BoCTransaction temp = BoCApp.UserTransactions.get(x);
			int utCat = temp.transactionCategory();
			BoCCategory temp2 = BoCApp.UserCategories.get(utCat);
			temp2.addExpense(temp.transactionValue());
			BoCApp.UserCategories.set(utCat, temp2);
		}
    }

    @BeforeEach
    void setUp() {
    	System.setOut(new PrintStream(outContent));
    }
    
    @AfterAll
    public static void cleanUpStreams() {
    	
    }
    
    @AfterEach
    void tearDown() {
    	System.setOut(null);
    	outContent.reset();
    }
    
    /*
     1. Failed Hongming Ping 22:14/4/5
     Reason: The output doesn't include the name of Category as required.
     If a number larger than bound is input, no tips is output. 
     2. Failed Hongming Ping 17:48/5/5
     Reason: The output doesn't include the name of Category as required.
     Change: The problem of out of bound has been solved.
     3. Passed Hongming Ping 20:45/5/5
     
     */
    @ParameterizedTest
	@MethodSource
	void listTransactionsForCategoryTest(int CategoryNum, String ExpectedOutput) throws Exception {
    	BoCApp.ListTransactionsForCategory(CategoryNum);
    	assertEquals(ExpectedOutput, outContent.toString());
	}
	static List<Arguments> listTransactionsForCategoryTest(){
		return List.of(
				Arguments.arguments(1,"Unknown: 1) Rent - ¥850.00\r\nUnknown: 8) tran1 - ¥1.00\r\n" + "Unknown: 9) tran4 - ¥4.00\r\n" + "Unknown: 10) tran6 - ¥0.00\r\n" + "Unknown: 11) tttttrrrrraaaaannnnn10101 - ¥10.00\r\n"),
				Arguments.arguments(2,"Bills: 2) Phone Bill - ¥37.99\r"+'\n'+"Bills: 3) Electricity Bill - ¥75.00\r"+'\n'),
				Arguments.arguments(3,"Groceries: 4) Sainsbury's Checkout - ¥23.76\r"+'\n'+"Groceries: 5) Tesco's Checkout - ¥7.24\r"+'\n'),
				Arguments.arguments(4,"Social: 6) RockCity Drinks - ¥8.50\r"+'\n'+"Social: 7) The Mooch - ¥13.99\r"+'\n'),
				Arguments.arguments(5,"The Category doesn't exit\r"+'\n')
		);
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
                Arguments.arguments("tran6\n", "0.00\n", "1\n", "Wrong value. It should be a positive number with two decimal places e.g. 10.00."),
                Arguments.arguments("tran7\n", "-5.00\n", "1\n", "Wrong value. It should be a positive number with two decimal places e.g. 10.00."),
                Arguments.arguments("tran8\n", "8.00\n", "0\n", "Wrong category. It should be an integer between 1 - 4"),
                Arguments.arguments("tran9\n", "9.00\n", "-1\n", "Wrong category. It should be an integer between 1 - 4"),
                Arguments.arguments("tttttrrrrraaaaannnnn10101\n", "10.00\n", "1\n", "1"),
                Arguments.arguments("tttttrrrrraaaaannnnn111111111111\n", "11.00\n", "1\n", "Wrong name. It should not be more than 25 characters!"),
                Arguments.arguments("tran12\n", "12\n", "1\n", "Wrong value. It should be a positive number with two decimal places e.g. 10.00."),
                Arguments.arguments("   \n", "13.00\n", "1\n", "Wrong name. It should not be blank!"),
                Arguments.arguments("tran14\n", "   \n", "1\n", "Wrong value. It should not be blank!")
        );
	}
	
	
	@Disabled
    void ChangeTransactionCategoryTest() {

    }

    @Disabled
    void AddCategoryTest() {

    }
}
