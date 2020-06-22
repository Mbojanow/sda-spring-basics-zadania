package pl.sdacademy.wzorce.zad7;

import java.util.List;

public class WithMeanStatisticsLogger implements StatisticsLogger {

  private final StatisticsLogger statisticsLogger;

  public WithMeanStatisticsLogger(final StatisticsLogger statisticsLogger) {
    this.statisticsLogger = statisticsLogger;
  }

  @Override
  public void displayStatistics() {
    final double mean = getExecutionTimes().stream().mapToDouble(x -> x).sum() / getExecutionTimes().size();
    System.out.println("Mean is " + mean);
    statisticsLogger.displayStatistics();
  }

  @Override
  public List<Double> getExecutionTimes() {
    return statisticsLogger.getExecutionTimes();
  }
}
