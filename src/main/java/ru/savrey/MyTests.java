package ru.savrey;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static ru.savrey.Calculator.Calculator.*;

public class MyTests {

    /**
     * Homework: Task 1
     */
    @Test
    public void testCalculatingDiscountPositive() {
        assertThat(calculatingDiscount(500, 10)).isEqualTo(450.0);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculatingDiscountNegativePurchase() {
        calculatingDiscount(-500.0, 10);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculatingDiscountNegativeDiscount() {
        calculatingDiscount(500, -20);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculatingDiscountBigger100() {
        calculatingDiscount(500, 120);
    }

    /**
     * LectureTasks
     */
    @Test
    public void testSquareRootPositive() {
        assertThat(squareRootExtraction(25.0)).isEqualTo(5.0);
    }

    @Test
    public void testSquareRootZero() {
        assertThat(squareRootExtraction(0.0)).isEqualTo(0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSquareRootNegative() {
        squareRootExtraction(-5.0);
    }


}
