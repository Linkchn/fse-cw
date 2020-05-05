import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import jdk.nashorn.internal.ir.annotations.Ignore;

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
				Arguments.arguments(1,"Unknown: 1) Rent - ¥850.00"+'\n'),
				Arguments.arguments(2,"Bills: 2) Phone Bill - ¥37.99"+'\n'+"Bills: 3) Electricity Bill - ¥75.00"+'\n'),
				Arguments.arguments(3,"Groceries: 4) Sainsbury's Checkout - ¥23.76"+'\n'+"Groceries: 5) Tesco's Checkout - ¥7.24"+'\n'),
				Arguments.arguments(4,"Social: 6) RockCity Drinks - ¥8.50"+'\n'+"Social: 7) The Mooch - ¥13.99"+'\n'),
				Arguments.arguments(5,"The Category doesn't exit"+'\n')
		);
	}
	
	@Ignore
    void ChangeTransactionCategoryTest() {

    }

    @Ignore
    void AddCategoryTest() {

    }
}
