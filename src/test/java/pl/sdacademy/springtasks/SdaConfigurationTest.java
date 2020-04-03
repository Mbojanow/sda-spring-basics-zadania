package pl.sdacademy.springtasks;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class SdaConfigurationTest {

  @Autowired
  private SdaConfiguration sdaConfiguration;

  private SdaConfiguration noProxySdaConfiguration;

  @BeforeEach
  void setUp() {
    noProxySdaConfiguration = new SdaConfiguration();
    noProxySdaConfiguration.setKey(sdaConfiguration.getKey());
    noProxySdaConfiguration.setValue(sdaConfiguration.getValue());
    noProxySdaConfiguration.setCount(sdaConfiguration.getCount());
    noProxySdaConfiguration.setEnabled(sdaConfiguration.getEnabled());
  }

  @Test
  void shouldGetConfigurationProperties() throws IllegalAccessException {
    final Field[] fields = SdaConfiguration.class.getDeclaredFields();

    assertFieldHasValueAndType(fields, "enabled", true, Boolean.class);
    assertFieldHasValueAndType(fields, "key", "magic_test_key", String.class);
    assertFieldHasValueAndType(fields, "value", "some_magic_test_value", String.class);
    assertFieldHasValueAndType(fields, "count", 8, Integer.class);
  }

  private void assertFieldHasValueAndType(final Field[] fields, final String fieldName, final Object expectedValue, final Class<?> expectedType) throws IllegalAccessException {
    final Optional<Field> optionalField = Stream.of(fields).filter(field -> field.getName().equals(fieldName))
        .findFirst();
    assertThat(optionalField).isPresent();
    final Field field = optionalField.get();
    field.setAccessible(true);
    assertThat(field.getType()).isEqualTo(expectedType);
    assertThat(field.get(noProxySdaConfiguration)).isEqualTo(expectedValue);
  }

  @Test
  void shouldBeValidatedOnStartup() {
    final Validated annotation = SdaConfiguration.class.getDeclaredAnnotation(Validated.class);

    assertThat(annotation).isNotNull();
  }

  @Nested
  class SdaConfigurationValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
      validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void shouldHaveErrorWhenKeyTooShort() {
      noProxySdaConfiguration.setKey("a");
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

      final Set<ConstraintViolation<SdaConfiguration>> errors = validator.validate(noProxySdaConfiguration);

      assertSingleErrorOnFieldWithMessage(errors, "length must be between 3 and 2147483647", "key");
    }

    @Test
    void shouldHaveErrorWhenValueTooShort() {
      noProxySdaConfiguration.setValue("");
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

      final Set<ConstraintViolation<SdaConfiguration>> errors = validator.validate(noProxySdaConfiguration);

      assertSingleErrorOnFieldWithMessage(errors, "length must be between 1 and 25", "value");
    }

    @Test
    void shouldHaveErrorWhenCountIsNull() {
      noProxySdaConfiguration.setCount(null);
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

      final Set<ConstraintViolation<SdaConfiguration>> errors = validator.validate(noProxySdaConfiguration);

      assertSingleErrorOnFieldWithMessage(errors, "count cannot be null", "count");
    }

    @Test
    void shouldHaveErrorWhenCountIsTooLow() {
      noProxySdaConfiguration.setCount(2);
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

      final Set<ConstraintViolation<SdaConfiguration>> errors = validator.validate(noProxySdaConfiguration);

      assertSingleErrorOnFieldWithMessage(errors, "must be greater than or equal to 3", "count");
    }

    private void assertSingleErrorOnFieldWithMessage(final Set<ConstraintViolation<SdaConfiguration>> errors,
                                                     final String expectedMessage, final String expectedField) {
      assertThat(errors).hasSize(1);
      assertThat(errors.stream()).allMatch(x -> x.getMessage().equals(expectedMessage) &&
          ((PathImpl)x.getPropertyPath()).getLeafNode().getName().equals(expectedField));
    }

  }


}