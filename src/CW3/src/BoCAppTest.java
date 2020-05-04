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
import java.util.Date;
import java.util.List;
import java.util.Scanner;


class BoCAppTest {

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); 
    private static ArrayList<BoCTransaction> UserTransactions;
    private static ArrayList<BoCCategory> UserCategories;
    private static Scanner in;
    private static BoCApp a = null;

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
        
        in = new Scanner(System.in);
        a = new BoCApp();
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    public static void tearDown() {
        System.setOut(null); 
    }



    @DisplayName("testToString")
    @ParameterizedTest
    @MethodSource
    void AddTransactionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method AddTransactionTest = a.getClass().getDeclaredMethod("AddTransaction", Scanner.class);
        AddTransactionTest.setAccessible(true);
        //调用
        String input = "Hello2"; 
        InputStream in = new ByteArrayInputStream(input.getBytes());  
        System.setIn(in);

        Object result = AddTransactionTest.invoke(a, "this is a test information");
        System.out.println(result);
        assertNotNull(result);
    }

    static List<Arguments> testToString() {
        return List.of( // arguments:
                Arguments.arguments(cat2,toStringResult1),
                Arguments.arguments(cat3,toStringResult2)
        );
    }

    @Test
    void AddCategoryTest() {

    }
}
