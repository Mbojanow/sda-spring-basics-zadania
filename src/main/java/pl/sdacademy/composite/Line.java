package pl.sdacademy.composite;

import java.util.Optional;

public interface Line {
  void draw(double lengthInPixels);
  void setStartingPosition(Point position);
  Point getStartingPoint();
}
