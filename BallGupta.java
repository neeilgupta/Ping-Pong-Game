//Name - Neeil Gupta
//Date - 06/17/2024
//Lab  - Pong Lab
/*
   The imports Color that is used to animate objects. The graphics is imported to draw objects. And we then we imported the entire java awt package 
   in order to to access to the entire class. We import Math so that we can use the random method
*/
import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import static java.lang.Math.*;
/*
   This class is controlling the ball and its properties, and extends BlockGupta as it is drawn from block class. Xspeed and Yspeed are set to the base speed of 3
   and the base position of the ball is (0,0) and the width and height is set at 20 in order to make it small yet seeable ball. Also, color is called as we will use 
   it and the size is set at base of 5.PlayerScore and Computer Score are also controlled by the ball class and the centralgame class is called as we will interact with that class as well  
*/
public class BallGupta extends BlockGupta
{
	private int xSpeed = 3;
	private int ySpeed = 3;
   int xPos = 0;
   int yPos = 0;
   int width = 20; 
   int height = 20;
   private Color color;
   private int size = 5;
   int playerScore;
   int computerScore;
   CentralGameGupta central;
   /*
   This is the constructor for the class it passes the xPos, yPos, width, and height to the super BlockGupta. 
   Then we set the ints in the parameter into the variables and set the central to hub
   */
   public BallGupta(int xPos, int yPos, int width, int height, CentralGameGupta hub)
   {
      super(xPos, yPos, width, height);
      this.xPos = xPos;
      this.yPos = yPos;
      this.width = width;
      this.height = height;
      central = hub;
   }
	// Setter for color of ball
	public void setColor( Color color)
   {
      setColor(color);
   }
   // Sets xPos and yPos 
	public void setPos( int x, int y)
   {
      xPos = x;
      yPos = y;
   }
   // Set X position
   public void setX( int x )
   {
      xPos = x;
   }
   // Set Y position 
   public void setY( int y )
   {
      yPos = y;
   }
   // Set x Speed
   public void setXspeed(int x)
   {
      xSpeed = x;
   }
   // Set Y Speed 
   public void setYspeed(int y)
   {
      ySpeed = y;
   }
   //Gets x Speed 
   public int getXspeed()
   {
      return xSpeed;
   }
   // Gets y Speed 
   public int getYspeed()
   {
      return ySpeed;
   }
   // Gets X pos 
   public int getX()
   {
      return xPos;
   }
   // Gets Y pos 
   public int getY()
   {
      return yPos;
   }
   // Getter for CPU Score
   public int getComputerScore()
   {
      return computerScore;
   }
   // Getter for Player Score 
   public int getPlayerScore()
   {
      return playerScore;
   }
   // Getter for Central Game class Class
   public CentralGameGupta getParent()
   {
      return central; 
   }
   /*
    This returns a boolean to see if a collison has occured.It is true when the ball is within 50 as that is the length of 
    rectangle of the paddle ypos else it is false  
    */
   public boolean checkcollison()
   {
      if(Math.abs(yPos-central.getY()) <= 50)
      {
         return true;
      }
      return false;
   }
   /*
      Update is used to change position of the ball according to situations. First, the xPos is upadate based off the speed and the same for the ySpeed 
      Then , we check if a score has occured. If the xPos is less than 20 of the boundary and is further than 50 from the paddle then the computer
      Score scores a point, and the xSpeed is randomly set between 2- 12. And then it checks if the ball has crossed the the right boundary and paddle
      and the player score a point. Also, it checks to see if the ball hits yPos on the boundary if so its changes the ySpeed randomly from 2-12
   */
	public void update()
	{
		  
        xPos = xPos + xSpeed;
        yPos = yPos + ySpeed;
        if (xPos <= 20 && checkcollison() == false){
               computerScore++;
            
            xSpeed = (int)(10*Math.random()+2);
            
        } else if (xPos + size > 994 && checkcollison() == false) {
            xSpeed = -(int)(10*Math.random()+2);
            playerScore++;
        }

        if (yPos < 0) {
            ySpeed = (int)(10*Math.random()+2);
        } else if (yPos + size > 692) {
            ySpeed = -(int)(10*Math.random()+2);
        }
     }
	/*
      MoveAndDraw uses window by drawing an Orange ball and Setting X and Y Position and then drawing a circle at new location 
   */
   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
      
      drawCircle(window,Color.ORANGE);

      setX(getX()+xSpeed);
		//setY
      setY(getY()+ySpeed);
		//draw the ball at its new location
      drawCircle(window,color);
   }
   /*
      Checks to see if two balls are the same object. First it compatres the instance of to see if the obj is even a Ball obkect if so the  characteristocs
      are checked to see if they are the same if so then it is returned true else not false.
   */
	public boolean equals(Object obj)
	{

      if(!(obj instanceof BallGupta) )
         return false;
        
      BallGupta otherBallGupta = (BallGupta) obj;

      if(xPos == otherBallGupta.getX() && yPos == otherBallGupta.getY() && width == otherBallGupta.getWidth() && height == otherBallGupta.getHeight())
      {
         return true;
      }
      return false;
	}   
}