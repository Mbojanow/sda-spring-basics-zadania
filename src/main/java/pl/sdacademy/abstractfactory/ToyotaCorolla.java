package pl.sdacademy.abstractfactory;

public abstract class ToyotaCorolla extends AbstractCar {
  @Override
  public String getModelName() {
    return "Corolla";
  }

  @Override
  public String getProducer() {
    return "Toyota";
  }
}
