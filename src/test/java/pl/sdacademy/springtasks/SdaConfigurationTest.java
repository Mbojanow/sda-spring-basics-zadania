package pl.sdacademy.springtasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("/application-test.properties")
class SdaConfigurationTest {

  @Autowired
  private SdaConfiguration sdaConfiguration;

  @Test
  void shouldGetConfigurationProperties() throws IllegalAccessException {
    final Field[] fields = SdaConfiguration.class.getDeclaredFields();

    assertFieldHasValueAndType(fields, "enabled", true, Boolean.class);
    assertFieldHasValueAndType(fields, "key", "magic_test_key", String.class);
    assertFieldHasValueAndType(fields, "value", "some_magic_test_value", String.class);
  }

  private void assertFieldHasValueAndType(final Field[] fields, final String fieldName, final Object expectedValue, final Class<?> expectedType) throws IllegalAccessException {
    final Optional<Field> optionalField = Stream.of(fields).filter(field -> field.getName().equals(fieldName))
        .findFirst();
    assertThat(optionalField).isPresent();
    final Field field = optionalField.get();
    field.setAccessible(true);
    assertThat(field.getType()).isEqualTo(expectedType);
    assertThat(field.get(sdaConfiguration)).isEqualTo(expectedValue);
  }
}