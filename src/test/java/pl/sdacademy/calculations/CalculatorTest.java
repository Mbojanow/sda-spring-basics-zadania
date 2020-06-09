package pl.sdacademy.calculations;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldAddTwoNumbers() {
        double valueA = 5.2;
        double valueB = 3.1;

        double actualResult = calculator.add(valueA, valueB);

        assertEquals(8.3, actualResult);
        assertTimeout(Duration.ofMillis(200), () -> {
            Thread.sleep(100);

        });
    }
}