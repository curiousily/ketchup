package ketchup.drawable;

import ketchup.KetchupConfig;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle implements Drawable {

  private int x;
  private int y;
  private int radius;

  public Circle(int x, int y, int radius) {
    this.x = x;
    this.y = y;
    this.radius = radius * 2;
  }

  public void draw(Graphics2D graphics) {
    graphics.setColor(KetchupConfig.CIRCLE_COLOR);
    graphics.fill(new Ellipse2D.Double(x, y, radius * 2, radius * 2));
  }
}
