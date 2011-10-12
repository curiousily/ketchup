package ketchup;

import ketchup.gui.CanvasPanel;
import ketchup.painter.CirclePainter;
import ketchup.painter.SquarePainter;

import javax.swing.*;

public class KetchupApplet extends JApplet {

  @Override
  public void init() {
    super.init();

    try {
      SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
          createGui();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void createGui() {
    setSize(KetchupConfig.CANVAS_WIDTH, KetchupConfig.CANVAS_HEIGHT);
    CanvasPanel contentPane = new CanvasPanel();
    setContentPane(contentPane);
    new SquarePainter(contentPane, 0).start();
    new CirclePainter(contentPane, 10).start();
  }
}

