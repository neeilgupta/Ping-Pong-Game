//Name - Neeil Gupta
//Date - 06/17/2024
//Lab  - Pong Lab

import java.awt.Color;
import java.awt.Graphics;

/*
   This class is a basic class that the paddles and ball classes will access in order to build basic shapes.
   The global class variables used are xPos, yPos, width, height, and color.
*/
public class BlockGupta implements LocatableGupta {
   private int xPos;
   private int yPos;
   private int width;
   private int height;
   private Color color;

   // Constructor with default color as white
   public BlockGupta(int xPos, int yPos, int width, int height) {
      this.xPos = xPos;
      this.yPos = yPos;
      this.width = width;
      this.height = height;
      color = Color.WHITE;
   }

   // Default constructor
   public BlockGupta() {
      xPos = 50;
      yPos = 50;
      width = 50;
      height = 50;
      color = Color.WHITE;
   }

   // Constructor that sets xPos, yPos, width, height, and color
   public BlockGupta(int xPos, int yPos, int width, int height, Color col) {
      this.xPos = xPos;
      this.yPos = yPos;
      this.width = width;
      this.height = height;
      color = col;
   }

   // Constructor with only xPos and yPos
   public BlockGupta(int xPos, int yPos) {
      this.xPos = xPos;
      this.yPos = yPos;
      width = 20;
      height = 50;
      color = Color.WHITE;
   }

   // Sets the x and y position
   public void setPos(int x, int y) {
      xPos = x;
      yPos = y;
   }

   // Sets xPos
   public void setX(int x) {
      xPos = x;
   }

   // Sets yPos
   public void setY(int y) {
      yPos = y;
   }

   // Sets width
   public void setWidth(int wid) {
      width = wid;
   }

   // Sets height
   public void setHeight(int hei) {
      height = hei;
   }

   // Getter for xPos
   public int getX() {
      return xPos;
   }

   // Getter for yPos
   public int getY() {
      return yPos;
   }

   // Getter for width
   public int getWidth() {
      return width;
   }

   // Getter for height
   public int getHeight() {
      return height;
   }

   // Getter for color
   public Color getColor() {
      return color;
   }

   // Sets color
   public void setColor(Color col) {
      color = col;
   }

   // Draw a rectangle
   public void drawRect(Graphics window) {
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   // Draw a circle
   public void drawCircle(Graphics window, Color col) {
      window.setColor(col);
      window.fillOval(getX(), getY(), getWidth(), getHeight());
   }

   // Repaint the rectangle by changing positions
   public void repaintUp(Graphics window) {
      window.fillRect(getX(), getY(), getWidth(), getHeight());
      window.setColor(color);
   }

   // Checks equality based on positions and dimensions
   public boolean equals(Object obj) {
      if (!(obj instanceof BlockGupta))
         return false;
      BlockGupta otherBlockGupta = (BlockGupta) obj;
      return (xPos == otherBlockGupta.getX() && yPos == otherBlockGupta.getY() &&
              width == otherBlockGupta.getWidth() && height == otherBlockGupta.getHeight());
   }

   // toString method
   public String toString() {
      return "X: " + getX() + " Y: " + getY() + " Width: " + getWidth() + " Height: " + getHeight() + " Color: " + getColor();
   }
}
