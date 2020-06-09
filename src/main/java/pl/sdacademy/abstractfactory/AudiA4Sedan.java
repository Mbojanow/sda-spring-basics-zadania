package pl.sdacademy.abstractfactory;

public class AudiA4Sedan extends AudiA4 {
  @Override
  public Type getType() {
    return Type.SEDAN;
  }

  @Override
  public Integer getCylindersNum() {
    return 6;
  }

  @Override
  public Float getEngineVolume() {
    return 2.5F;
  }

  @Override
  public Integer getTrunkSize() {
    return 460;
  }
}
