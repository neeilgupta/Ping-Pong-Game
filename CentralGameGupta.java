//Name - Neeil Gupta
//Date - 06/17/2024
//Lab  - Pong Lab
/*
      These are the imports that are needed for the lab. Color will allow us to set color and change colors on objects. Graphics allow us to draw objects, and use them accordingly
      Canvas allows us to draw stuff and objects in a basic black rectangular. Also, ActionEvent and KeyListener are interfsaces that implemented as this will 
      allow us to move the our paddle up and down with the user. BufferedImage allows us to produce a visual proof of the ball and paddle moves it up and down.
      ActionListener checks to see if something has occured when someone has pressed a button. Timer is imported is because a thread is used in order for the program to sleep 
      every x amount of milseconds. Font is imported as the game customizes from the default font on the text used.
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Font;
/*
   This class is the main class that controls the game and paints the game's scene accordingly. The class extends Canvas as we will using much of their
   methods like draw and much more to paint what is on the screen. We will implement KeyListener and ActionListener so that the program reacts when certain buttons 
   are pressed. We also create the objects of a left paddle, right paddle, and ball as they will be used in the game. Additionally we will need to create a 
   Graphics object in order to draw and control what we put on a screen. Keys keeps track of what keys are pressed. 
*/
public class CentralGameGupta extends Canvas implements KeyListener, ActionListener
{
   BallGupta run = new BallGupta(50,50,10,10, this);
   PaddleLeftGupta left = new PaddleLeftGupta(10,50,0,50, this);
   PaddleRightGupta right = new PaddleRightGupta(989,50,20,50, this, run);
   Graphics window;
	private boolean[] keys;
   /*
      This is the constructor for the class. Keys is instiated as a new array of boolean with length 5. Then the Canvas is set up. Then, the background 
      is set black at default. Then, afterwards the canvas is set visible to true. And a keyListerener is added onto this class that detects what keys are pressed 
      Then, setFocusable is added so that the player does not need to touch the object on the canvas window for it to start operating. Then, Timer is called so that a thread will allow the program to 
      rest/sleep every 50 mileconds on this class and it then started. 
   */
	public CentralGameGupta()
	{
		keys = new boolean[5];
      //set up the Canvas
		setBackground(Color.BLACK);
		setVisible(true);
		this.addKeyListener(this);
      // Set focus on canvas window
      this.setFocusable(true);
      //PaddleTestGupta is running constantly in a timer thread with a delay/sleep every 950 milseconds.
      Timer time = new Timer(50, this);
      time.start();
	}
   // This is a getter method to get the ball class called 
	public BallGupta getBall()
   {
      return run;
   }
   // This is a getter method to get the left paddle class called
   public PaddleLeftGupta getLeftPaddle()
   {
      return left;
   }
   //This is a getter method to get the right paddle class called
   public PaddleRightGupta getRightPaddle()
   {
      return right;
   }
   // Update allows us to change the position of the ball & paddles by alowing us to call the paint method 
	public void update(Graphics window)
	{
		paint(window);
	}
   // Getter method for the left paddle's Y 
   public int getY()
   {
      return getLeftPaddle().getY();
   }
   /*
      This method paints the main screen and canvas. It starts by setting the background to blue and then fill the background with a rectangle to do so
      Then, I created the my game logo in the center.Afterwards, we change the color to green and set the font to Monospaced Bold size 40  as it is the font I wanted.
      Then, I draw the String. Afterwards, I proceed to create the Computer and Game Score by changing the size of the text and positioning it accordingly.
      Afterwards, I draw the Player and Comp Score using the getter methods for that as the score will constantly change during the game, and the score will repainted when the 
      update is excuted. Then, I proceed to draw the ball at the current position and speed it is at. After that I do the same with the left and right paddles
      Then I check to see if the ball is collide with the either of the x boundaries. If true I set the speed to the opposite of the normal speed.
      I do the same with y. Then, if the up key is pressed I draw the left paddle up and vice versa if it goes down. 
   */
	public void paint(Graphics window)
	{
      window.setColor(Color.BLUE);
      window.fillRect(0, 0, 1024, 720);
      window.setColor(Color.yellow);
      window.fillOval(375,270, 350, 100);
      window.setColor(Color.green);
      window.setFont(new Font("Monospaced Bold",Font.PLAIN,40));
      window.drawString("INFINITE PONG", 400, 330);
      window.setFont(new Font("Monospaced Bold",Font.PLAIN,20));
      window.drawString("PLAYER", 80, 45);
      window.drawString("CPU", 880, 45);
      window.setFont(new Font("Monospaced Bold",Font.PLAIN,60));
      window.drawString(""+run.getPlayerScore()+"", 100,100);
      window.drawString(""+run.getComputerScore()+"", 900, 100);
		run.moveAndDraw(window);
		left.draw(window);
      right.draw(window);
		if(!(run.getX()>=10 && run.getX()<=1014))
		{
			run.setXspeed(-run.getXspeed());
		}

		if(!(run.getY()>=10 && run.getY()<=710))
		{
			run.setYspeed(-run.getYspeed());
		}

		if(keys[0] == true)
		{
			//move left paddle up and draw it on the window
			left.moveUpAndDraw(window);
		}
		if(keys[1] == true)
		{
			//move left paddle down and draw it on the window
         left.moveDownAndDraw(window);

		}
	}
   // This fixes any gilthches the paddle or ball may have
   public void actionPerformed(ActionEvent e) {
        run.update();
        right.update();
        left.update();
        repaint();
    }
   /*
   This void is called when a key is pressed it reads based off the key code for each. if the int key that is pressed equals up then then the left paddle is moved up 
   and drawn. Same for the down button.
   */
	public void keyPressed(KeyEvent e)
	{
      int key = e.getKeyCode();
      if (key == KeyEvent.VK_UP) 
      {
         left.moveUpAndDraw(window);
      }
      if (key == KeyEvent.VK_DOWN) 
      {
         left.moveDownAndDraw(window);       
      }
	   
	}
   // We cannot delete this method as it is part of the interface that we implemented 
	public void keyReleased(KeyEvent e)
	{
      //no code needed here
	}
   // We cannot delete this method as it is part of the interface that we implemented 
	public void keyTyped(KeyEvent e)
	{
		//no code needed here
	}
		
}