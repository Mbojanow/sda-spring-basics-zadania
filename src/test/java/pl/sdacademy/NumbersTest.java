package pl.sdacademy;

import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumbersTest {

  private Numbers numbers = new Numbers();

  @Test
  void shouldFindFirstDigitInString() {
    final OptionalInt firstDigit = numbers.findFirstDigit("Hello!!112");

    assertThat(firstDigit).isPresent()
        .hasValue(1);
  }

  @Test
  void shouldNotFindAnyDigitWhenThereAreNone() {
    final OptionalInt firstDigit = numbers.findFirstDigit("SDA");

    assertThat(firstDigit).isEmpty();
  }

  @Test
  void shouldThrowException() {
    try {
      numbers.findFirstDigit("");
      final int digit = 5;
      fail("Exception was not thrown");
    } catch (final IllegalArgumentException exp) {
      assertEquals("Input cannot be empty", exp.getMessage());
    }
  }
}