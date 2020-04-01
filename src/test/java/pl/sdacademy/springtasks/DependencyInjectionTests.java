package pl.sdacademy.springtasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;

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

}