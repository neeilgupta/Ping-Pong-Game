//Name - Neeil Gupta
//Date - 06/17/2024
//Lab  - Pong Lab 
/*
   In order for this class to successfully operate, we will need these lists of imports.JFrame will provide the basic "frame" to play the game on. Color will 
   allow the game to contain color and a varitety of it.  
   JOptionPane allows us to communicate with the user prior to the start of the game. 
*/
import javax.swing.JFrame;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JOptionPane;
/*
   This is the Runner Class. This class is where the user/client will be able to run the game and it is simple for the user's convience
   RunnerGupta extends JFrame as it is creating a certain type of JFrame. Thus, many proprties of JFrame are required so we will inherit JFrame.
   The size of our frame will be 1024 X 720 as noted by the static final width & height, and will be used throughout the class.
*/
public class RunnerGupta extends JFrame
{
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 720;
  /*
      This is the public constructor in which the JFrame will be set up in order to run the game. First, the super is called to name the Frame we 
      are using Infinite Pong as that is the offical game, and the name of the game will be displayed in the top left corner. Next, we will set the size of the
      JFrame to the desired width and height of 1024 X 720. Since, rules of inheritance we do not need to call JFrame sperepartely. Then, we will get
      the content we want to display on the screen using getContentPane().add from CentralGameGupta(). Afterwards, we will make the JFrame visible by
      setting setVisible to true. And finally, in order to close out of the JFrame with ease we will add adefault close operation when the user presses 
      the x button.
  */
	public RunnerGupta()
	{
		super("Infinite Pong");
		setSize(WIDTH,HEIGHT);
      getContentPane().add(new CentralGameGupta());
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
   /*
      This is main method in which the game is offically run out of. First, a JOptionPane appears to welcome in the user of the game and tell them 
      how to close out of the game. THen, another one of these boxes is opened to tell tell the rules of the game. Finally, a third box appears to wish 
      the user good luck. Finally, then RunnerGupta is called and that then sets up the game. 
   */
	public static void main( String args[] )
	{
      JOptionPane.showMessageDialog(null,"Hello, Gamer Welcome to Infinite Pong \n To End Game Press the Close Button on Top");
      JOptionPane.showMessageDialog(null,"This is a non-stop pong,even when a point is scored the game does not stop\n So pay Attention");
      JOptionPane.showMessageDialog(null, "Good Luck!!!!!!");
		RunnerGupta run = new RunnerGupta();
	}
}