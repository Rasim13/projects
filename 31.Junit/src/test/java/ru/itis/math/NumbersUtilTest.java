package ru.itis.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "NumbersUtils is working when")
public class NumbersUtilTest {
    // объект класса, который будем тестировать
    private NumbersUtil numbersUtil = new NumbersUtil();

    @Nested
    @DisplayName("isPrime() is working")
    class ForIsPrime {
        @ParameterizedTest(name = "throws exception on {0}")
        @ValueSource(ints = {0, 1})
        public void on_problems_number_throws_exception(int number) {
            assertThrows(IncorrectNumberException.class, () -> numbersUtil.isPrime(number));
        }

        @ParameterizedTest(name = "return true on {0}")
        @ValueSource(ints = {2, 3, 7, 113, 31, 41})
        public void on_prime_numbers_returns_true(int number) {
            assertTrue(numbersUtil.isPrime(number));
        }

        @ParameterizedTest(name = "return false on {0}")
        @ValueSource(ints = {121, 169})
        public void on_prime_numbers_with_sqrt_returns_false(int number) {
            assertFalse(numbersUtil.isPrime(number));
        }

        @ParameterizedTest(name = "return false on {0}")
        @ArgumentsSource(value = CompositeNumberProvider.class)
        public void on_prime_composite_numbers_returns_false(int number) {
            assertFalse(numbersUtil.isPrime(number));
        }
    }

    @Nested
    @DisplayName("gcd() is working")
    class ForGcd{
        @ParameterizedTest(name = "return {2} on a = {0} and b = {1}")
        @CsvFileSource(delimiter = ',', files = {"src\\test\\resources\\gcd.csv"})
        public void on_numbers_returns_gcd(int a, int b, int gcd) {
            assertEquals(gcd, numbersUtil.gcd(a, b));
        }

    }
}
