package pl.sdacademy;

public class PersonFactory {

  public Person createPerson(final String firstName, final String lastName) {
    final String prefix = firstName.endsWith("a") ? "Ms" : "Mr";
    return new Person(prefix, firstName, lastName);
  }
}
