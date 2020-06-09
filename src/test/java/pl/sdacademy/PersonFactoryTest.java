package pl.sdacademy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonFactoryTest {

  private static final String MALE_NAME = "Andrzej";
  private static final String FEMALE_NAME = "Ala";
  private static final String SURNAME = "Nowak";
  private static final String MALE_PREFIX = "Mr";
  private static final String FEMALE_PREFIX = "Ms";

  private final PersonFactory personFactory = new PersonFactory();

  @Test
  void shouldCreateMalePerson() {
    final Person person = personFactory.createPerson(MALE_NAME, SURNAME);

    assertThat(person).isNotNull()
        .extracting(Person::getPrefix)
        .isNotNull()
        .isEqualTo(MALE_PREFIX);
  }

  @Test
  void shouldCreateFemalePerson() {
    final Person person = personFactory.createPerson(FEMALE_NAME, SURNAME);

    assertAll(
        () -> assertEquals(SURNAME, person.getLastName()),
        () -> assertEquals(FEMALE_NAME, person.getFirstName()),
        () -> assertEquals(FEMALE_PREFIX, person.getPrefix())
    );
  }
}