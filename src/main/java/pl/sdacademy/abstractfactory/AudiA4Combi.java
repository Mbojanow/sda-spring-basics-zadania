package pl.sdacademy.abstractfactory;

public class AudiA4Combi extends AudiA4 {

  @Override
  public Type getType() {
    return Type.COMBI;
  }

  @Override
  public Integer getCylindersNum() {
    return 6;
  }

  @Override
  public Float getEngineVolume() {
    return 2.7F;
  }

  @Override
  public Integer getTrunkSize() {
    return 540;
  }
}
