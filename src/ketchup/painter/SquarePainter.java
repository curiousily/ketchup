package ketchup.painter;

import ketchup.KetchupConfig;
import ketchup.drawable.Drawable;
import ketchup.drawable.Square;
import ketchup.gui.CanvasPanel;

import static ketchup.KetchupConfig.*;

public class SquarePainter extends ShapePainter {

  public static final int SQUARE_WIDTH = 100;
  public static final int SQUARE_HEIGHT = 200;

  private int x, y;

  public SquarePainter(CanvasPanel canvasPanel, int restAtEdgeSeconds) {
    super(canvasPanel, restAtEdgeSeconds);
    x = ((CANVAS_WIDTH - EDGE_SHAPE_COUNT * (SQUARE_WIDTH + SQUARE_OFFSET)) / 2) - (SQUARE_WIDTH + SQUARE_OFFSET);
    y = 20;
  }

  @Override
  protected Drawable nextShape() {
    if (isNextShapeHorizontal())
      x += SQUARE_WIDTH + KetchupConfig.SQUARE_OFFSET;
    else
      y += SQUARE_HEIGHT + KetchupConfig.SQUARE_OFFSET;
    return new Square(x, y, SQUARE_WIDTH, SQUARE_HEIGHT);
  }
}
