package pl.sdacademy.springtasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LoggingCommandLineRunnerTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  @Autowired
  private LoggingCommandLineRunner loggingCommandLineRunner;

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  void shouldPrintHelloFromFirstTask() throws Exception {
    loggingCommandLineRunner.run();

    assertThat(outContent.toString()).startsWith("hi from first task");
  }

  @Test
  void shouldHaveComponentAnnotation() {
    final Annotation[] annotations = LoggingCommandLineRunner.class.getDeclaredAnnotations();

    assertThat(annotations).hasSize(1);
    assertThat((annotations[0]).annotationType()).isEqualTo(Component.class);
  }

}
