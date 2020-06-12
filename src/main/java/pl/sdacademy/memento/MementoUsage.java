package pl.sdacademy.memento;

import org.springframework.boot.autoconfigure.quartz.QuartzProperties;

import java.sql.Connection;
import java.util.ArrayList;

public class MementoUsage {
  public static void main(String[] args) {
    final GameState gameState = new GameState(100, 80, new ArrayList<>());

    final GameStateManager gameStateManager = new GameStateManager();
    gameStateManager.saveGame(gameState);
    System.out.println(gameState);

    gameState.addItem("Basic Sword");
    gameState.takeDamage(10);
    System.out.println(gameState);

    gameStateManager.saveGame(gameState);

    gameState.takeDamage(50);
    gameState.addItem("Shield");
    System.out.println(gameState);

    gameStateManager.saveGame(gameState);

    // decided to load
    gameStateManager.restorePreviousCheckpoint();
    final GameStateSnapshot gameStateSnapshot = gameStateManager.restorePreviousCheckpoint();
    gameState.restoreFromSnapshot(gameStateSnapshot);
    System.out.println(gameState);
  }
}
