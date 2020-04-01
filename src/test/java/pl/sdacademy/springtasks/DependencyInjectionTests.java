package pl.sdacademy.springtasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DependencyInjectionTests {

  @Autowired
  private DummyLogger dummyLogger;

  @Autowired
  private List<SimpleLogger> simpleLoggers;

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  void shouldHaveThreeLoggers() {
    assertThat(simpleLoggers).hasSize(3);
  }

  @Test
  void dummyLoggerShouldBeCreatedViaConfiguration() {
    final Annotation[] declaredAnnotations = DummyLogger.class.getDeclaredAnnotations();

    assertThat(declaredAnnotations).isEmpty();
  }

  @Test
  void dummyLoggerConfigurationShouldBeConfiguration() {
    final Annotation[] declaredAnnotations = DummyLoggerConfiguration.class.getDeclaredAnnotations();

    assertThat(declaredAnnotations).hasSize(1);
    assertThat(declaredAnnotations[0].annotationType()).isEqualTo(Configuration.class);
  }
}