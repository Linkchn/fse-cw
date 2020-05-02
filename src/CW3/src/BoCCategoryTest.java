import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BoCCategoryTest {

    static BoCCategory cat1;
//    static BoCCategory catName;
//    static BoCCategory catBudget1;
//    static BoCCategory catBudget2;
//    static BoCCategory catSpend;
    static String Name;
    static BigDecimal Budget1;
    static BigDecimal Budget2;
    static BigDecimal Spend;
    static BigDecimal bd1;
    static BigDecimal sum;

    @BeforeAll
    static void set() {	
        cat1 = new BoCCategory();
//        catName = new BoCCategory();
//        catBudget1 = new BoCCategory();
//        catBudget2 = new BoCCategory();
//        catSpend = new BoCCategory();
//        
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
    1- PASS - Shiliang - 16:13 1/5
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

    @Order(5)
    @Test
    @DisplayName("testToString")
    @ParameterizedTest
    @ValueSource(strings = {"TestCategoryName", "5.00", "7.00"})
    void testToString(String string1) {
    	 Name = string1;
    	 cat1.setCategoryName(Name);
    	 Budget1 = new BigDecimal(string1);
    	 cat1.setCategoryBudget(Budget1);
    	 Spend = new BigDecimal(str);
    	 cat1.setCategorySpend(Spend);
    	 assertEquals("TestCategoryName(¥5.00) - Est. ¥6.00 (¥1.00 Overspent)", cat1.toString());
    	 catBudget2 = new BigDecimal(string1);
    	 
    	 
    	
    }
}
