import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


class BoCAppTest {

    private static ArrayList<BoCTransaction> UserTransactions;
    private static ArrayList<BoCCategory> UserCategories;
    private static Scanner in;
    private static BoCApp a = null;

    @BeforeAll 
    static void setup() {
        UserCategories = new ArrayList<BoCCategory>();
        UserTransactions = new ArrayList<BoCTransaction>();
        UserCategories.add(new BoCCategory("Unknown"));
        in = new Scanner(System.in);
        a = new BoCApp();
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void main() {

    }

    @Test
    void listTransactionsTest() {

    }

    @Test
    void categoryOverviewTest() {
        
    }

    @Test
    void listTransactionsForCategoryTest() {

    }

    @Test
    void ChangeTransactionCategoryTest() {

    }

    @Test
    void AddTransactionTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method AddTransactionTest = a.getClass().getDeclaredMethod("AddTransaction", Scanner.class);
        AddTransactionTest.setAccessible(true);
        //调用
        Object result = AddTransactionTest.invoke(a, "this is a test information");
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    void AddCategoryTest() {

    }
}
