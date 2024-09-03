// Eli Bosch, 3/12/24, Controls what is viewed

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.Iterator;


public class View extends JPanel
{
	/*Private variables in the View Class */

	private Model model;

	private BufferedImage backgroundImage;

	/*Constructor for View Class */

	public View(Model m)
	{
		model = m;
		backgroundImage = OPEN_IMAGE("Images\\Background.png");
	}

	public static BufferedImage OPEN_IMAGE(String path)
	{	
		try
		{
			return ImageIO.read(new File(path)); 
		} 
		catch (Exception e)
		{
			e.printStackTrace(System.err);
    		System.exit(1);
		}

		return null;
	}

	/*Jframe Painting Method */

	public void paintComponent(Graphics g) 
	{	
		g.drawImage(backgroundImage, 0, 0, Game.FRAME_SIZE, Game.FRAME_SIZE, null);

		for(Iterator<Sprite> it = model.getSprites().iterator(); it.hasNext();)
		{
			Sprite temp = it.next();
			temp.draw(g);
		}
	}
}
