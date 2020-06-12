package pl.sdacademy.iterator;

import lombok.ToString;

@ToString
public class SimpleCar implements Car {

  private static int index = 0;
  private final String info;

  public SimpleCar() {
    info = "Mazda 6 with id " + ++index;
  }

  @Override
  public String getVehicleInfo() {
    return info;
  }
}
