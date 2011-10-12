package ketchup.painter;

import ketchup.KetchupConfig;
import ketchup.drawable.Drawable;
import ketchup.gui.CanvasPanel;

public abstract class ShapePainter implements Runnable {

  private final CanvasPanel canvasPanel;
  private final int restAtEdgeSeconds;
  private final Thread workerThread;
  protected int paintedShapes = 0;

  public ShapePainter(CanvasPanel canvasPanel, int restAtEdgeSeconds) {
    this.canvasPanel = canvasPanel;
    this.restAtEdgeSeconds = restAtEdgeSeconds - KetchupConfig.REST_SECONDS;
    this.workerThread = new Thread(this);
  }

  public void restFor(int seconds) {
    if(seconds < 1) return;
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void paint(Drawable drawable) {
    canvasPanel.add(drawable);
  }

  public void start() {
    workerThread.start();
  }

  public void run() {
    while (hasMoreToPaint()) {
      if (isOnTheEdge())
        onEdgeShapeDrawn();
      paintedShapes++;
      restFor(KetchupConfig.REST_SECONDS);
      paint(nextShape());
    }
  }

  private boolean isOnTheEdge() {
    return paintedShapes == 4;
  }

  protected void onEdgeShapeDrawn() {
    restFor(restAtEdgeSeconds);
  }

  protected abstract Drawable nextShape();

  private boolean hasMoreToPaint() {
    return paintedShapes < KetchupConfig.TOTAL_SHAPES;
  }

  protected boolean isNextShapeHorizontal() {
    return paintedShapes <= KetchupConfig.EDGE_SHAPE_COUNT;
  }
}
