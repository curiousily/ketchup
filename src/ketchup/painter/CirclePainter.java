package ketchup.painter;

import ketchup.drawable.Circle;
import ketchup.drawable.Drawable;
import ketchup.gui.CanvasPanel;

import static ketchup.KetchupConfig.CANVAS_WIDTH;

public class CirclePainter extends ShapePainter {

  private int x, y;
  private static final int CIRCLE_RADIUS = 30;

  public CirclePainter(CanvasPanel canvasPanel, int restAtEdgeSeconds) {
    super(canvasPanel, restAtEdgeSeconds);
    x = ((CANVAS_WIDTH - 4 * ((CIRCLE_RADIUS * 2) + 105)) / 2);
    y = 120;
  }

  @Override
  protected Drawable nextShape() {
    if (isNextShapeHorizontal())
      y += CIRCLE_RADIUS + 100;
    else
      x += CIRCLE_RADIUS + 130;

    return new Circle(x, y, CIRCLE_RADIUS);
  }
}
