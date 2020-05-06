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


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoCAppTest {
    
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private static BoCApp a = null;
    static BoCApp addCat1;
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
        prompt4 = new String("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters.\r\n");
        prompt5 = new String("What is the budget for this category?\r\nNote:It should be a pisitive decimal number with exact two decimal places.\r\n");
        prompt6 = new String("[Category added]");
        prompt7 = new String("Which transaction ID?\r\n");
        prompt8 = new String("Which category will it move to?\r\n");
        prompt9 = new String("Change complete!\r\n");
        allCategory = new String("1) Unknown(¥0.00) - Est. ¥850.00 (¥850.00 Overspent)\r\n"+
                "2) Bills(¥120.00) - Est. ¥112.99 (¥7.01 Remaining)\r\n"+
                "3) Groceries(¥75.00) - Est. ¥31.00 (¥44.00 Remaining)\r\n"+
                "4) Social(¥100.00) - Est. ¥22.49 (¥77.51 Remaining)\r\n"+
                "5) cat1Name(¥6.23) - Est. ¥0.00 (¥6.23 Remaining)\r\n"
                );
                
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

    @Disabled
    @DisplayName("mainTest")
    @ParameterizedTest
    @MethodSource
    void mainTest(String a) {
        String input = "A\nABC\n10.00\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BoCApp.main(new String[]{"X\n"});
    }
    static List<Arguments> mainTest() {
        return List.of( // arguments:
                Arguments.arguments(""),
                Arguments.arguments(""),
                Arguments.arguments("")
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
               Arguments.arguments(1,"Unknown: 1) "+sd+" Rent - ¥850.00\r\nUnknown: 8) "+sd+" tran1 - ¥1.00\r\n" + "Unknown: 9) "+sd+" tran4 - ¥4.00\r\n" + "Unknown: 10) "+sd+" tran6 - ¥0.00\r\n" + "Unknown: 11) "+sd+" tttttrrrrraaaaannnnn10101 - ¥10.00\r\n"),
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
    @DisplayName("AddTransactionTest")
    @ParameterizedTest
    @MethodSource
    void AddTransactionTest(String name, String val, String cat, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        // prepare for calling a private method
        Method AddTransactionTest = a.getClass().getDeclaredMethod("AddTransaction", Scanner.class);
        AddTransactionTest.setAccessible(true);

        // create an input stream from expected inputs
        String input = "\n"+ name + val + cat;
        inp = new Scanner(input);

        try {
            AddTransactionTest.invoke(a, inp);
            BoCTransaction tr = BoCApp.UserTransactions.get(BoCApp.UserTransactions.size()-1);
            // if this should run properly without exception
            if (alert.equals("1")) {
                // handle cat with blank input, which should be considered as 1
                if (cat.equals("\n")) {
                    cat = cat.replaceAll("\n", "1");
                }
                // compare the prompt message and confirmation message
                assertEquals(prompt1 + prompt2 + prompt3 + name.replace("\n", "") + "(¥" + val.replace("\n", "") + ")" + " was added to " + BoCApp.UserCategories.get(Integer.parseInt(cat.replace("\n", "")) - 1).CategoryName() + "\r\n", outContent.toString());
                // compare the name, value and category
                assertTrue(name.replace("\n", "").equals(tr.transactionName()));
                assertEquals(new BigDecimal(val.replace("\n", "")) ,tr.transactionValue());
                assertEquals(Integer.parseInt(cat.replace("\n", "")) - 1 ,tr.transactionCategory());
            }
        }
        catch (Exception e) {
            // firts make sure the exception is thrown from invocation
            assertThrows(InvocationTargetException.class, () -> {
                AddTransactionTest.invoke(a, inp);
            });
            // compare the expected alert message to the actual one
            assertEquals(alert, e.getCause().getMessage());
        }
    }

    // list of arguments which will be taken by the above method
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
	
	
    /* 
	1 - Pass - Leo - 00:18/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest1,2,3,4
	
	2 - Pass - Leo - 00:48/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest5，6
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
                Arguments.arguments("7", "4", "1"),
                Arguments.arguments("8", "4", "Please input valid transaction value!"),
                Arguments.arguments("5", "-1", "Please input valid category!")
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
    @DisplayName("AddCategoryTest")
    @ParameterizedTest
    @MethodSource
    void AddCategoryTest(String name, String budget, String alert) throws IllegalAccessException, 
    IllegalArgumentException, InvocationTargetException, 
    NoSuchMethodException, SecurityException {
        Method AddCategoryTest = a.getClass().getDeclaredMethod("AddCategory", Scanner.class);
        AddCategoryTest.setAccessible(true);
        String input = "\n" + name + budget;
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
        Arguments.arguments("cat10Name\n", "   \n", "Wrong budget! It should not be blank."),
        Arguments.arguments("cat11Name\n", "0.00\n", "Wrong budget! It should be a positive decimal number with exact two decimal places.")
        );
    }
}
