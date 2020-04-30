import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class BoCCategoryTest {

    static BoCCategory cat1;
    static BigDecimal bd1;

    @BeforeAll
    static void set() {
        cat1 = new BoCCategory();
        bd1 = new BigDecimal("1000.00");
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("addExpenseTest")
    @Test
    void addExpenseTest() {
        cat1.addExpense(bd1);
        assertEquals(bd1, cat1.CategorySpend());
    }

    @Test
    void removeExpenseTest() {
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