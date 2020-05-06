import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {

    @Disabled
    @DisplayName("mainTest")
    @ParameterizedTest
    @MethodSource
    void mainTest(String a, String b) {
        String input = a;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        BoCApp.main(new String[]{""});
    }
    static List<Arguments> mainTest() {
        return List.of( // arguments:
                Arguments.arguments("X", "")
//                Arguments.arguments(""),
//                Arguments.arguments("")
        );
    }
}
