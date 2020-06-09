package pl.sdacademy.factorymethod;

public interface Game {
  String getName();
  String getType();
  int getMinNumberOfPlayers();
  int getMaxNumberOfPlayers();
  boolean canBePlayedRemotely();
}
