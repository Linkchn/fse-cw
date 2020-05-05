package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.io.ByteArrayInputStream;
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

//    private static ArrayList<BoCTransaction> UserTransactions;
//    private static ArrayList<BoCCategory> UserCategories;
//    private static Scanner in;
//    private static BoCApp a = null;
    
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static BoCApp a = null;
    private static Scanner inp;
    private static String prompt1, prompt2, prompt3, prompt4, prompt5, catList;

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
	
		for (int x = 0; x < BoCApp.UserTransactions.size(); x++) {
			BoCTransaction temp = BoCApp.UserTransactions.get(x);
			int utCat = temp.transactionCategory();
			BoCCategory temp2 = BoCApp.UserCategories.get(utCat);
			temp2.addExpense(temp.transactionValue());
			BoCApp.UserCategories.set(utCat, temp2);
		}
		
		a = new BoCApp();
		prompt1 = new String("Which transaction ID?\r\n");
        prompt2 = new String("Which category will it move to?\r\n");
        prompt3 = new String("Change complete!\r\n");
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

    @Ignore
    void main() {

    }

    @Ignore
    void listTransactionsTest() {

    }

    @Ignore
    void categoryOverviewTest() {
        
    }

    @Ignore
    public void listTransactionsForCategoryTest1() {
    	int CategoryNum = 0;
    	BoCApp.ListTransactionsForCategory(CategoryNum);
    	assertEquals("1)  Rent - ¥850.00"+'\n', outContent.toString());
        //outContent.reset();
    }
    

    
	@Ignore
	void listTransactionsForCategoryTest(int CategoryNum, String ExpectedOutput) throws Exception {
    	BoCApp.ListTransactionsForCategory(CategoryNum);
    	assertEquals(ExpectedOutput, outContent.toString());
	}
	static List<Arguments> listTransactionsForCategoryTest(){
		return List.of(
				Arguments.arguments(0,"1)  Rent - ¥850.00"+'\n'),
				Arguments.arguments(1,"2)  Phone Bill - ¥37.99"+'\n'+"3)  Electricity Bill - ¥75.00"+'\n'),
				Arguments.arguments(2,"4)  Sainbury Bill - ¥37.99"+'\n'+"5)  Electricity Bill - ¥75.00"+'\n'),
				Arguments.arguments(3,"2)  Phone Bill - ¥37.99"+'\n'+"3)  Electricity Bill - ¥75.00"+'\n')
				//Arguments.arguments(1,"1)  Rent - ¥850.00"+'\n')
		);
	}

	/* 
	1 – Pass – Leo - 00:46/6/5  
	Problem: /
	Reason:/
	Traceability: ChangeTransactionCategoryTest1,2,3,4,5,6
	*/
	@DisplayName("AddTransactionTest")
	@ParameterizedTest
	@MethodSource
	void ChangeTransactionCategoryTest(String tID, String newCat, String alert) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	    Method ChangeTransactionCategoryTest = a.getClass().getDeclaredMethod("ChangeTransactionCategory", Scanner.class);
	    ChangeTransactionCategoryTest.setAccessible(true);
	    
	    try {
		    if(alert.equals("1")) {
			    String input = "\n" + tID + "\n" + newCat + "\n";
			    inp = new Scanner(input);
			    catList = "1) " + a.UserCategories.get(0).toString() + "\r\n";
		    	for (int x = 1; x < a.UserCategories.size(); x++) {
					BoCCategory temp = a.UserCategories.get(x);
					catList += (x+1) + ") " + temp.toString() + "\r\n";
				}
		    	int tIDi = Integer.parseInt( tID )-1;
		    	int newCati = Integer.parseInt( newCat )-1;
			    
		    	BoCTransaction temp = a.UserTransactions.get(tIDi);
				int oldCat = temp.transactionCategory();
		    	
	        	ChangeTransactionCategoryTest.invoke(a, inp);
	        	BoCCategory newCatSpend = a.UserCategories.get(newCati);
	        	BoCCategory oldCatSpend = a.UserCategories.get(oldCat);
	            assertEquals(prompt1 + "\t- " + a.UserTransactions.get( tIDi ).toString() + "\r\n" + prompt2 + catList + prompt3 + "Target category: " + (newCati + 1) + ") " + newCatSpend.toString() + "\r\n" + "Origin category: " + (oldCat + 1) + ") " + oldCatSpend.toString() + "\r\n", outContent.toString());
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
                Arguments.arguments("3", "1", "1"),
                Arguments.arguments("4", "2", "1"),
                Arguments.arguments("7", "4", "1"),
                Arguments.arguments("8", "4", "Please input valid transaction value!"),
                Arguments.arguments("5", "-1", "Please input valid category!")
        );
    }
	
    @Ignore
    void AddCategoryTest() {

    }
}
