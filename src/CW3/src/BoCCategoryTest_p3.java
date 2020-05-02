import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoCCategoryTest {
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

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    
    /* 
    1 – FAIL – Shiliang – 21:43 30/5
    Problem: Decimals are different
    Reason: There might be something wrong with the input type
    Traceability: addExpenseTest 1

    2 – FAIL – Shiliang – 21:46 30/5
    Problem: Decimals are still different
    Reason: BigDecimal requires accurate numbers
    Traceability: addExpenseTest 2

    3 – PASS – Shiliang – 21:55 30/5
    Problem: /
    Reason: Only String can be accurate numbers for a BigDecimal constructor
    Traceability: addExpenseTest 3

    4 – PASS – Shiliang – 22:35 30/5
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
    1 – PASS – Shiliang – 23:44 30/4
    Problem: /
    Reason: /
    Traceability: removeExpenseTest 1, 2, 3, 4

    2 – FAIL – Shiliang – 23:44 30/4
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
        BigDecimal temp = sum.subtract(bd1);

        try {
            sum = sum.subtract(bd1);
            cat1.removeExpense(bd1);
            assertEquals(sum, cat1.CategorySpend());
            System.out.println(cat1.CategorySpend());

        }
        catch (Exception e){
            assertThrows(Exception.class, ()->{cat1.removeExpense(bd1);System.out.println(cat1.CategorySpend());});
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
