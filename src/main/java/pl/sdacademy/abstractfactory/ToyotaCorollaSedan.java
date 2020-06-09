package pl.sdacademy.abstractfactory;

public class ToyotaCorollaSedan extends ToyotaCorolla {
  @Override
  public Type getType() {
    return Type.SEDAN;
  }

  @Override
  public Integer getCylindersNum() {
    return 4;
  }

  @Override
  public Float getEngineVolume() {
    return 1.8F;
  }

  @Override
  public Integer getTrunkSize() {
    return 480;
  }
}
