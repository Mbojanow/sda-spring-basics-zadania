package pl.sdacademy.abstractfactory;

public class AbstractFactoryUsage {
  public static void main(String[] args) {
    CarType carType = CarType.valueOf(args[0]);
    System.out.println("User wants to produce a " + carType);

    CarFactory factory = new FactoryProvider().createFactory(carType);
    Car combi = factory.createCombi();

    System.out.println("There is your combi " + combi);
  }
}
