import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

class BoCCategoryTest {

    static BoCCategory cat1;
    static BigDecimal bd1;
    static BigDecimal sum;

    @BeforeAll
    static void set() {
        cat1 = new BoCCategory();
        bd1 = new BigDecimal("100");
        sum = new BigDecimal("0.00");
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }


    @DisplayName("addExpenseTest")
    @ParameterizedTest
    @ValueSource(strings = {"0.00", "100.00", "111.50", "10000000000.00"})
    void addExpenseTest(String num) {

        bd1 = new BigDecimal(num);
        sum = sum.add(bd1);
        cat1.addExpense(bd1);
        assertEquals(sum, cat1.CategorySpend());

    }


    @DisplayName("removeExpenseTest")
    @ParameterizedTest
    @ValueSource(strings = {"0.00", "10000000000.00", "111.50", "100.00", "100.00"})
    void removeExpenseTest(String num) {
        bd1 = new BigDecimal(num);
        sum = cat1.CategorySpend();
        BigDecimal temp = sum.subtract(bd1);

        if (temp.compareTo(BigDecimal.ZERO) != -1){
            sum = sum.subtract(bd1);
            cat1.removeExpense(bd1);
            assertEquals(sum, cat1.CategorySpend());
        }
        else{
            assertThrows(Exception.class, ()->{cat1.removeExpense(bd1);});
        }
    }

    @Test
    void resetBudgetSpendTest() {
    }

    @Test
    void getRemainingBudgetTest() {
    }

    @Test
    void testToString() {
    }
}