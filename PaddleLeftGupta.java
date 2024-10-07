//Name - Neeil Gupta
//Date - 06/17/2024
//Lab  - Pong Lab
/* These are the imports that are needed for the class. Color is used to color the object, and graphics will be needed to draw the object. 
   Additionally, ActionEvent,KeyEvent and Listener are needed as we implement KeyListener 
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
/*
   This class controls the left or player paddle of the class and extends Block GUpta as it is drawn by BLockGupta and implements the 
   KeyListener method as we will moving the keys up and down. The graphics window is made as we need to draw and color is made as we need to animate and
   color the color the box. Speed is used to set the speed of the paddle. And the xPos , yPos, and width and height is set to default nums. And the central is called
   in order to access the central class.
*/
public class PaddleLeftGupta extends BlockGupta implements KeyListener
{
   Graphics window;
   Color color;
   private int speed;
   int xPos = 10;
   int yPos = 10;
   int width = 20;
   int height = 20;
   CentralGameGupta central;
   /* This is the constructor in which the left class is callled. The x and y are passed to BlockGupta while the other are set accordingly to there 
      there variables, and speed is default is 5 and the central class is intitalized
   */
   public PaddleLeftGupta(int x, int y, int width, int height, CentralGameGupta hub)
   {
      super(x,y);
      this.width = width;
      this.height = height;
      speed = 5;
      central = hub;
   }
   // Returns centralGame class
   public CentralGameGupta getParent()
   {
      return central;
   }
   // Returns xPos 
   public int getX()
   {
      return xPos;
   }
   // Sets speed of paddle
   public void setSpeed(int speed)
   {
      this.speed = speed;
   }
   //Draws rect/ paddle
   public void draw(Graphics window)
   {
      drawRect(window);
   }
   // Draws paddles Up as long as it is not near the bounds 
   public void moveUpAndDraw(Graphics window)
   {
      if (getY() > 10)
      {
         setY(getY()-5);
      }
   }
   // Draws paddle down as long as it not near bounds 
   public void moveDownAndDraw(Graphics window)
   {
      if (getY() < 625)
      {
         setY(getY()+5);
      }
   }
   //Used to detect wheteher the user has pressed the up or down keys and accordingly moves up or moves down paddle based off key code
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();

      if (key == KeyEvent.VK_UP)
      {
         moveUpAndDraw(window);
      }
      if (key == KeyEvent.VK_DOWN)
      {
         moveDownAndDraw(window);
      }

   }
   // not needed but can't be deleted as interface is implemented
   public void keyReleased(KeyEvent e)
   {

   }
   // not needed but can't be deleted as interface is implemented 
   public void keyTyped(KeyEvent e)
   {
      //no code needed here
   }
   //Returns speed 
   public int getSpeed()
   {
      return speed;
   }
   // Updates to see is paddle is touching boundaries. If so, then the speed is set in the negative of the current
   public void update()
   {
      if(yPos < 0)
      {
         speed = -7;
      }else if(yPos + height > 1018)
      {
         speed = 7;
      }
   }
}