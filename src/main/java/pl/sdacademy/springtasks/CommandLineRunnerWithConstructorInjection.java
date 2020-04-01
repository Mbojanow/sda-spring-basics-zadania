package pl.sdacademy.springtasks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerWithConstructorInjection implements CommandLineRunner {

  private DummyLogger dummyLogger;

  @Override
  public void run(final String... args) throws Exception {
    dummyLogger.logSomething();
  }
}
