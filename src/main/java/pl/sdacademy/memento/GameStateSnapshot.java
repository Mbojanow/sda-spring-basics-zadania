package pl.sdacademy.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameStateSnapshot {

  private Integer health;
  private Integer mana;
  private List<String> items;

  public GameStateSnapshot(final GameState gameState) {
    this.health = gameState.getHealth();
    this.mana = gameState.getMana();
    this.items = List.copyOf(gameState.getItems()); // deep copy!
  }
}
