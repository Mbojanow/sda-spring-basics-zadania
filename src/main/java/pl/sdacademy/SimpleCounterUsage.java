package pl.sdacademy;

public class SimpleCounterUsage {
  public static void main(String[] args) {
    SimpleCounter simpleCounterA = SimpleCounter.INSTANCE;
    SimpleCounter simpleCounterB = SimpleCounter.INSTANCE;
    System.out.println(simpleCounterA == simpleCounterB); // również true

    simpleCounterA.increment();
    simpleCounterB.increment();
    System.out.println(simpleCounterA.getCurrentCount()); // 2
  }
}
