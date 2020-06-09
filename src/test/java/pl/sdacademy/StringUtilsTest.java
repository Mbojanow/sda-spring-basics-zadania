package pl.sdacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class StringUtilsTest {

  private StringUtils stringUtils;

  @BeforeEach
  void setUp() {
    stringUtils = new StringUtils();
  }

  @Test
  void shouldUpperCaseInputs() {
    final List<String> inputs = List.of("Hello", "From", "sda");
    final List<String> exepectedOutput = List.of("HELLO", "FROM", "SDA");

    final List<String> actualOutputs = stringUtils.toUpperCase(inputs);

    assertLinesMatch(exepectedOutput, actualOutputs);
  }

  @Test
  @DisplayName("Test that checks toLowerCase method behavior")
  void shouldLowerCaseInputs() {
    final List<String> inputs = List.of("Hello", "From", "SDA");
    final List<String> exepectedOutput = List.of("hello", "from", "sda");

    final List<String> actualOutputs = stringUtils.toLowerCase(inputs);

    assertLinesMatch(exepectedOutput, actualOutputs);
  }

  @Test
  @Disabled("waiting for actual method implementation. TDD approach")
  void shouldSnakeCaseInputs() {
    final List<String> inputs = List.of("helloFrom", "testExamples");
    final List<String> exepectedOutput = List.of("hello_from", "test_example");

    final List<String> actualOutputs = stringUtils.toLowerCase(inputs);

    assertLinesMatch(exepectedOutput, actualOutputs);
  }

}