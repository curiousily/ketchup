package ketchup.gui;

import ketchup.drawable.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class CanvasPanel extends JPanel {

  private Queue<Drawable> drawables = new LinkedList<Drawable>();

  public synchronized void add(Drawable drawable) {
    drawables.add(drawable);
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    synchronized (this) {
      Graphics2D graphics = (Graphics2D) g;
      for (Drawable drawable : drawables) {
        drawable.draw(graphics);
      }
    }
  }
}
