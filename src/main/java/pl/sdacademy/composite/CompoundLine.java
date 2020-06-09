package pl.sdacademy.composite;

import java.util.ArrayList;
import java.util.List;

// this class can draw 7 perpendicular lines in a 2d space (and on line can be transparent in a shape of a kitten ;)
public class CompoundLine implements Line {

  private final List<Line> lines = new ArrayList<>();

  @Override
  public void draw(final double lengthInPixels) {
    lines.forEach(line -> line.draw(lengthInPixels));
  }

  @Override
  public void setStartingPosition(final Point position) {
    lines.forEach(line -> line.setStartingPosition(position));
  }

  @Override
  public Point getStartingPoint() {
    if (lines.isEmpty()) {
      return new Point(0, 0);
    }
    return lines.get(0).getStartingPoint();
  }

  public void addLine(final Line line) {
    lines.add(line);
  }

  public void removeLine(final Line line) {
    lines.remove(line);
  }

}
