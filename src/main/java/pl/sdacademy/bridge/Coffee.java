package pl.sdacademy.bridge;

import static pl.sdacademy.bridge.Taste.BITTER;

public class Coffee implements Drink {

  @Override
  public String getVolume() {
    return "500ml";
  }

  @Override
  public boolean isAddictive() {
    return true;
  }

  @Override
  public int getNumberOfSugarLumps() {
    return 0;
  }

  @Override
  public Taste getTaste() {
    return BITTER;
  }
}
