package pl.sdacademy.template;

public class TemplateMethodUsage {
  public static void main(String[] args) {
    PerformanceTestTemplate testTemplate = new RandomListSortingPerformanceTest();
    testTemplate.run();

    testTemplate = new StringBuilderAppendPerformanceTest();
    testTemplate.run();
  }
}
