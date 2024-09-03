
// Eli Bosch, 3/12/24, Main java class for Assignment 5 (The og class \_|-o-|_/)
//Works but you have to adjust wdith and the tail set new

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Game extends JFrame
{
	//Class references 
	Model model = new Model(); 
	View view = new View(model);
	Controller controller = new Controller(model);

	static final int FRAME_SIZE = 640;
	//static int AMOUNT_SQUARE = 10;
	static final int GRID_SIZE = FRAME_SIZE/10;

	public Game()
	{
		//creates the jframe and tells the view that controller is in charge of mouse and key clicks
		this.setTitle("concept");
		view.setPreferredSize(new Dimension(FRAME_SIZE, FRAME_SIZE));
		this.setFocusable(true);
		this.getContentPane().add(view);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		view.addMouseListener(controller);
		this.addKeyListener(controller);		
	}

	public static void main(String[] args) // Just the main method
	{
		Game g = new Game();
		g.run();
	}

	public void run() // a while loop that constantly runs in the main method 
	{
		while(true)
		{
			//The updates is repeated waiting for inputs
			controller.update();
			model.update();
			view.repaint(); // This will indirectly call View.paintComponent
			Toolkit.getDefaultToolkit().sync(); // Updates screen

			// Go to sleep for 40 milliseconds - 25 fps
			try
			{
				Thread.sleep(25); // sets the frame rate to 25 fps
			} catch(Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
			
		}
	}
}
