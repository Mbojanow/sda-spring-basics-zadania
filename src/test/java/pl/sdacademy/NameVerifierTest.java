package pl.sdacademy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NameVerifierTest {

  private NameVerifier nameVerifier;

  @BeforeEach
  void setUp() {
    nameVerifier = new NameVerifier();
  }

  @Test
  void shouldValidateName() {
    String name = "Andrzej";

    final boolean validationResult = nameVerifier.isNameValid(name);

    assertTrue(validationResult);
  }

  @Test
  void shouldNotValidateNameWhenAllLettersAreLowerCase() {
    String name = "andrzej";

    final boolean validationResult = nameVerifier.isNameValid(name);

    assertFalse(validationResult);
  }

  @Test
  void shouldNotValidateEmptyName() {
    String emptyName = "";

    final boolean validationResult = nameVerifier.isNameValid(emptyName);

    assertFalse(validationResult);
  }

  @Test
  void shouldNotValidateNullName() {
    String nullName = null;

    final boolean validationResult = nameVerifier.isNameValid(nullName);

    assertFalse(validationResult);
  }
}