package pl.sdacademy.wzorce.zad7;

import java.util.List;

public interface StatisticsLogger {
  void displayStatistics();
  List<Double> getExecutionTimes();
}
