package pl.sdacademy.wzorce.zad6;

public interface PCGame {
  String getTitle();
  Integer getPegiAllowedAge();
  boolean isTripleAGame();
  Requirements getRequirements();
}
