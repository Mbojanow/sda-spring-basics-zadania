package pl.sdacademy.flyweight;

import lombok.Data;

@Data
public class Engine {

  public static int instances = 0;

  private String identifier;
  private Double volume;
  private EngineType engineType;

  public Engine(final String identifier, final Double volume, final EngineType engineType) {
    instances++;
    this.identifier = identifier;
    this.volume = volume;
    this.engineType = engineType;
  }
}
