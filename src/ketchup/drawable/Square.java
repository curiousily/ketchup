package ketchup.drawable;

import ketchup.KetchupConfig;

import java.awt.*;

public class Square implements Drawable {
  private int x;
  private int y;
  private int width;
  private int height;

  public Square(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void draw(Graphics2D graphics) {
    graphics.setColor(KetchupConfig.SQUARE_COLOR);
    graphics.drawRect(x, y, width, height);
  }
}
