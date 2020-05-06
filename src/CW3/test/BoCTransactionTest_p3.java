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

import static org.junit.jupiter.api.Assertions.*;

class BoCTransactionTest_p3 {

    static BoCTransaction tran1;
    static BoCTransaction tran2;
    static BoCTransaction tran3;
    static BoCTransaction tran4;

    @BeforeAll
    static void setUp() {
        tran1 = new BoCTransaction();
        tran2 = new BoCTransaction(null, new BigDecimal("850.00"), 0);
        tran3 = new BoCTransaction("Rent", null, 0);
        tran4 = new BoCTransaction("Rent", new BigDecimal("850.00"), 0);
    }

    @AfterEach
    void tearDown() {
    }


    /*
    1 – ERROR – Shiliang – 21:43 1/5
    Problem: isComplete () does not exist
    Reason: java reported error, cant invoke a non-exist method
    Traceability: isCompleteTest 1

    2 – PASS – Shiliang – 22:37 1/5
    Problem: /
    Reason: /
    Traceability: isCompleteTest 2

     */
    @DisplayName("isCompleteTest")
    @ParameterizedTest
    @MethodSource
    void isCompleteTest(BoCTransaction tran) {
    assertEquals((tran.transactionName()) != null && (tran.transactionValue() != null), tran.isComplete());
    }

    static List<Arguments> isCompleteTest() {
        return List.of( // arguments:
                Arguments.arguments(tran1),
                Arguments.arguments(tran2),
                Arguments.arguments(tran3),
                Arguments.arguments(tran4)
        );
    }

}
