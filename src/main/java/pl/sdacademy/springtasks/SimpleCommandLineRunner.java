package pl.sdacademy.springtasks;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

public class SimpleCommandLineRunner implements CommandLineRunner {

  private final SimpleLogger simpleLogger;
  private final DummyLogger dummyLogger;

  public SimpleCommandLineRunner(@Qualifier("simpleLoggerB") final SimpleLogger simpleLogger, final DummyLogger dummyLogger) {
    this.simpleLogger = simpleLogger;
    this.dummyLogger = dummyLogger;
  }


  @Override
  public void run(final String... args) throws Exception {

  }
}
