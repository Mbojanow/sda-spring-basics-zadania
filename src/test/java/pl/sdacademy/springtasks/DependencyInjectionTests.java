package pl.sdacademy.springtasks;

import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DependencyInjectionTests {

  @Autowired
  private CommandLineRunnerWithConstructorInjection commandLineRunnerWithConstructorInjection;

  @Autowired
  private CommandLineRunnerWithFieldInjection commandLineRunnerWithFieldInjection;

  @Autowired
  private CommandLineRunnerWithSetterInjection commandLineRunnerWithSetterInjection;

  @Test
  void shouldInjectViaConstructor() {
    final Constructor<?>[] declaredConstructors = CommandLineRunnerWithConstructorInjection.class.getDeclaredConstructors();

    assertThat(declaredConstructors).hasSize(1);
    assertThat(declaredConstructors[0].getParameterTypes()).hasSize(1).containsExactly(DummyLogger.class);
  }

  @Test
  void shouldInjectViaField() {
    final Constructor<?>[] declaredConstructors = CommandLineRunnerWithFieldInjection.class.getDeclaredConstructors();
    final Field[] declaredFields = CommandLineRunnerWithFieldInjection.class.getDeclaredFields();

    assertThat(declaredFields).hasSize(1);
    assertThat(declaredFields[0].getType()).isEqualTo(DummyLogger.class);
    assertThat(declaredFields[0].getDeclaredAnnotations()).hasSize(1);
    assertThat(declaredFields[0].getDeclaredAnnotations()[0].annotationType()).isEqualTo(Autowired.class);
    assertThat(declaredConstructors).hasSize(1);
    assertThat(declaredConstructors[0].getParameterCount()).isEqualTo(0);
  }

  @Test
  void shouldInjectViaSetter() {
    final Method[] declaredMethods = CommandLineRunnerWithSetterInjection.class.getDeclaredMethods();

    assertThat(declaredMethods).hasSize(2);
    final Optional<Method> setter = Stream.of(declaredMethods)
        .filter(method -> method.getName().equals("setDummyLogger"))
        .findFirst();
    assertThat(setter)
        .isPresent()
        .hasValueSatisfying(new Condition<>(method -> method.getParameterTypes()[0].equals(DummyLogger.class), null));
  }

}