package pl.sdacademy.factorymethod;

public class MonopolyGameCreator implements GameFactory {
  @Override
  public Game create() {
    return new BoardGame("Monopoly", "Family Game", 4);
  }
}
