import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoCCategoryTest {

    private static String TestInputString, TestOutputString;
    private static BigDecimal TestInputBudget;
    private static BigDecimal TestOutputBudget;
    private static BigDecimal TestExceptOutputBudget;

    // Declare BoCCategories for tests
    static BoCCategory cat1;
    static BoCCategory cat2;
    static BoCCategory cat3;

    // Declare result Strings for tests
    static String toStringResult1; 
    static String toStringResult2; 

    // Declare BigDecimals for tests
    static BigDecimal bd1;
    static BigDecimal sum;
    
    @BeforeAll
    static void set() {    
        cat1 = new BoCCategory();
        cat2 = new BoCCategory();
        cat3 = new BoCCategory();

        // Set data for tests
        cat2.setCategoryName("testToStringName");
        cat2.setCategoryBudget(new BigDecimal ("5.00"));
        cat2.addExpense(new BigDecimal ("6.00"));
        cat3.setCategoryName("testToStringName");
        cat3.setCategoryBudget(new BigDecimal ("7.00"));
        cat3.addExpense(new BigDecimal ("6.00"));

        // Define expected result
        toStringResult1 = new String ( "testToStringName(¥5.00) - Est. ¥6.00 (¥1.00 Overspent)");
        toStringResult2 = new String ( "testToStringName(¥7.00) - Est. ¥6.00 (¥1.00 Remaining)");
        
        bd1 = new BigDecimal("100");
        sum = new BigDecimal("0.00");
        
    }
    
    /* - Pass - Hongming PING - 23:38/30/4  
    
    */
    @Test
    void setCNTest1() throws Exception {
        TestInputString="YTB";
        try {
            BoCCategory copy = new BoCCategory();
            copy.setCategoryName(TestInputString);
            TestOutputString = copy.CategoryName();
        }catch(Exception e) {
            fail ("Someting wrong with catch");
        }
        assertEquals(TestInputString, TestOutputString);
    }
    
    /*1. - Fail - Hongming PING - 21:38/2/5
    Problem: If newName is sapce only or empty, the result still returns the value of
    newName, which is Unknown name.
    2. - Pass - 22:57/2/5
    Reason: Fixed the Method with adding an "if" statement to assign null to String 
    while whose newName is empty or sapce
    */
    @ParameterizedTest
    @ValueSource(strings = {" " ,""})
    void setCNTest23(String TestInputString) throws Exception {
        try {
            BoCCategory copy = new BoCCategory();
            copy.setCategoryName(TestInputString);
            TestOutputString = copy.CategoryName();
        }catch(Exception e) {
            fail ("Someting wrong with catch");
        }
        assertNull(TestOutputString);
    }
    
    /* - Pass - Hongming PING - 16:52/1/5  
    
    */
    @Test
    void setCBTest1(){
        TestInputBudget = new BigDecimal("0");
        TestExceptOutputBudget = new BigDecimal("0.00");
        try {
            BoCCategory copy = new BoCCategory();
            copy.setCategoryBudget(TestInputBudget);
            TestOutputBudget = copy.CategoryBudget();
        }catch(Exception e) {
            fail ("Someting wrong with catch");
        }
        assertEquals(TestExceptOutputBudget, TestOutputBudget);
    }
    
    /* - Pass - Hongming PING - 16:52/1/5  
    
    */
    @Test
    void setCBTest2(){
        TestInputBudget = new BigDecimal("-100");
        TestExceptOutputBudget = new BigDecimal("0.00");
        try {
            BoCCategory copy = new BoCCategory();
            copy.setCategoryBudget(TestInputBudget);
            TestOutputBudget = copy.CategoryBudget();
        }catch(Exception e) {
            fail ("Someting wrong with catch");
        }
        assertEquals(TestExceptOutputBudget, TestOutputBudget);
    }
    
    /* - Pass - Hongming PING - 16:52/1/5  
    
    */
    @Test
    void setCBTest3(){
        TestInputBudget = new BigDecimal("11.20");
        TestExceptOutputBudget = new BigDecimal("11.20");
        try {
            BoCCategory copy = new BoCCategory();
            copy.setCategoryBudget(TestInputBudget);
            TestOutputBudget = copy.CategoryBudget();
        }catch(Exception e) {
            fail ("Someting wrong with catch");
        }
        assertEquals(TestExceptOutputBudget, TestOutputBudget);
    }

    
    /* 
    1 - FAIL - Shiliang - 21:43 30/5
    Problem: Decimals are different
    Reason: There might be something wrong with the input type
    Traceability: addExpenseTest 1

    2 - FAIL - Shiliang - 21:46 30/5
    Problem: Decimals are still different
    Reason: BigDecimal requires accurate numbers
    Traceability: addExpenseTest 2

    3 - PASS - Shiliang - 21:55 30/5
    Problem: /
    Reason: Only String can be accurate numbers for a BigDecimal constructor
    Traceability: addExpenseTest 3

    4 - PASS - Shiliang - 22:35 30/5
    Problem: /
    Reason: /
    Traceability: addExpenseTest 4, 5, 6
    */
    @Order(1)
    @DisplayName("addExpenseTest")
    @ParameterizedTest
    @ValueSource(strings = {"0.00", "100.00", "111.50", "10000000000.00"})
    void addExpenseTest(String num) {

        bd1 = new BigDecimal(num);
        sum = sum.add(bd1);
        cat1.addExpense(bd1);
        assertEquals(sum, cat1.CategorySpend());

    }


    /* 
    1 - PASS - Shiliang - 23:44 30/4
    Problem: /
    Reason: /
    Traceability: removeExpenseTest 1, 2, 3, 4

    2 - FAIL - Shiliang - 23:44 30/4
    Problem: Expected an exception that expense should not be negative
    Reason: The source code does not handle this problem
    Traceability: removeExpenseTest 5

    3 - PASS - Shiliang - 16:25 1/5
    Problem: /
    Reason: /
    Traceability: removeExpenseTest 6
    */
    @Order(2)
    @DisplayName("removeExpenseTest")
    @ParameterizedTest
    @ValueSource(strings = {"0.00", "10000000000.00", "111.50", "90.00", "100.00"})
    void removeExpenseTest(String num) {
        bd1 = new BigDecimal(num);
        sum = cat1.CategorySpend();

        try {
            sum = sum.subtract(bd1);
            cat1.removeExpense(bd1);
            assertEquals(sum, cat1.CategorySpend());
            System.out.println(cat1.CategorySpend());

        }
        catch (Exception e){
            assertThrows(Exception.class, ()->{cat1.removeExpense(bd1);});
            assertEquals("Expense should not be less than 0!", e.getMessage());
        }
    }


    /*
    1- FAIL - Jiawei - 16:44 1/5
    Problem: The Test is failed. 
    Reason: The code does not run the resetBudgetSpendTest method in the first test. Therefore,
            the output is not match with the expected output.
    Traceability: resetBudgetSpendTest 1

    2 - PASS -Jiawei - 18:23 1/5
    Problem: /
    Reason:/
    Traceability: resetBudgetSpendTest 2
     */
    @Order(4)
    @DisplayName("resetBudgetSpendTest")
    @ParameterizedTest
    @ValueSource(strings = {"0.00"})
    void resetBudgetSpendTest(String num1) {
        bd1 = new BigDecimal(num1);
        cat1.resetBudgetSpend();
        assertEquals(bd1, cat1.CategorySpend());
        
    }


    /*
    1- PASS - Shiliang Jiawei- 16:13 1/5
    Problem: /
    Reason:  /
    Traceability: getRemainingBudgetTest 1
     */
    @Order(3)
    @DisplayName("getRemainingBudgetTest")
    @Test
    void getRemainingBudgetTest() {
        System.out.println(cat1.CategorySpend());
        assertEquals(new BigDecimal("-10.00"), cat1.getRemainingBudget());
    }


    /*
    1 - FAIL - Jiawei - 15:55 2/5
    Problem: Does not set a specific parameter in the test Therefore two conditions will not test either
    Reason: the parameter needs to be a value in the test plan 
    Traceability: testToString(previous version)

    2 - ERROR - Jiawei Shiliang-19:13 2/5
    Problem: Does not use Parameterized Test 
    Reason: Parameterized Test is more standard
    Traceability: testToString1, testToString 2 

    3 - PASS - Jiawei - 21:20 2/5
    Problem:/
    Reason:/
    Traceability: testToString 3, 4
     */
    @Order(5)
    @DisplayName("testToString")
    @ParameterizedTest
    @MethodSource
    void testToString(BoCCategory cat, String string1 ) {
        if(cat.getRemainingBudget().compareTo(BigDecimal.ZERO) != -1 )
        {
            assertEquals( string1, cat.toString());
        }
        else {
            assertEquals( string1, cat.toString());
        }
    }

    static List<Arguments> testToString() {
        return List.of( // arguments:
                Arguments.arguments(cat2,toStringResult1),
                Arguments.arguments(cat3,toStringResult2)
        );
    }
}

