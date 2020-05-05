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
    private static ArrayList<BoCTransaction> UserTransactions;
    private static ArrayList<BoCCategory> UserCategories;
    private static Scanner inp;
    private static BoCApp a = null;
    static BoCApp addCat1;

    @BeforeAll 
    static void setup() {
        System.setOut(new PrintStream(outContent)); 


        UserCategories = new ArrayList<BoCCategory>();
		UserTransactions = new ArrayList<BoCTransaction>();

		// SETUP EXAMPLE DATA //
		UserCategories.add(new BoCCategory("Unknown"));

		BoCCategory BillsCategory = new BoCCategory("Bills");
		BillsCategory.setCategoryBudget(new BigDecimal("120.00"));
		UserCategories.add(BillsCategory);

		BoCCategory Groceries = new BoCCategory("Groceries");
		Groceries.setCategoryBudget(new BigDecimal("75.00"));
		UserCategories.add(Groceries);

		BoCCategory SocialSpending = new BoCCategory("Social");
		SocialSpending.setCategoryBudget(new BigDecimal("100.00"));
		UserCategories.add(SocialSpending);

		UserTransactions.add(new BoCTransaction("Rent", new BigDecimal("850.00"), 0));
		UserTransactions.add(new BoCTransaction("Phone Bill", new BigDecimal("37.99"), 1));
		UserTransactions.add(new BoCTransaction("Electricity Bill", new BigDecimal("75.00"), 1));
		UserTransactions.add(new BoCTransaction("Sainsbury's Checkout", new BigDecimal("23.76"), 2));
		UserTransactions.add(new BoCTransaction("Tesco's Checkout", new BigDecimal("7.24"), 2));
		UserTransactions.add(new BoCTransaction("RockCity Drinks", new BigDecimal("8.50"), 3));
        UserTransactions.add(new BoCTransaction("The Mooch", new BigDecimal("13.99"), 3));
        

        a = new BoCApp();
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    public void tearDown() {
        System.setOut(null);
        outContent.reset();
    }



    @DisplayName("AddTransactionTest")
    @ParameterizedTest
    @MethodSource
    void AddTransactionTest(String name1, String val1, String cat1, String out1) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Method AddTransactionTest = a.getClass().getDeclaredMethod("AddTransaction", Scanner.class);
        AddTransactionTest.setAccessible(true);

        String input = "\n" + name1 + "\n" + val1 + "\n" + cat1 + "\n";
        inp = new Scanner(input);

        AddTransactionTest.invoke(a, inp);
        
        assertEquals(out1, outContent.toString());
        outContent.reset(); 
    }

    static List<Arguments> AddTransactionTest() {
        return List.of( // arguments:
        		Arguments.arguments("tran1", "1", "1", "What is the title of the transaction?\nWhat is the value of the transaction?\n[Transaction added]\n")
//                Arguments.arguments("\n", ""),
//                Arguments.arguments("tran3", "\n", "3", "1", ""),
//                Arguments.arguments("\n", "tran4", "\n", "4", "\n", ""),
//                Arguments.arguments("tran5", "", "5", "", "6", "" ),
//                Arguments.arguments("tran6", "", "6", "", "-1", "5"),
//                Arguments.arguments("tran7", "", "7", "", "-1", "6" ),
//                Arguments.arguments("tran2", "tran8", "8", "", "1", "")
        );
    }

    @DisplayName("AddCategoryTest")
    @ParameterizedTest
    @MethodSource
    void AddCategoryTest(String string1, String string2, String string3, String string4, String string5) throws IllegalAccessException, 
    IllegalArgumentException, InvocationTargetException, 
    NoSuchMethodException, SecurityException {
        Method AddCategoryTest = a.getClass().getDeclaredMethod("AddCategory", Scanner.class);
    	addCat1 = new BoCApp();
    	String input = new String();
    	InputStream in = new ByteArrayInputStream(string2.getBytes());
    	System.setIn(in);
    	addCat1.addCategory(in);
    	
    	
    	
    	
    	 

    }
    static List<Arguments> AddCategoryTest() {
    	return List.of( // arguments:
        		Arguments.arguments("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\n", "cat1Name", "What is the budget for this category?\r\nNote:It should be a pisitive decimal number with exact two decimal places.\r\n", "6.23", "[Category added]"),
        		Arguments.arguments("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\n", "cat2Name123456789", "", "", ""),
        		Arguments.arguments("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\n", "cat1Name", "", "", ""),
        		Arguments.arguments("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\n", "cat1Name", "What is the budget for this category?\r\nNote:It should be a pisitive decimal number with exact two decimal places.\r\n", "6", ""),
        		Arguments.arguments("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\n", "cat1Name", "What is the budget for this category?\r\nNote:It should be a pisitive decimal number with exact two decimal places.\r\n", "6.1", ""),
        		Arguments.arguments("What is the title of the category?\r\nNOTE: It should not be blank and should be at most 15 characters\r\n", "cat1Name", "What is the budget for this category?\r\nNote:It should be a pisitive decimal number with exact two decimal places.\r\n", "-7.23", "")
        );
    }
    
}
