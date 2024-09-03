import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tail extends Snake
{


    protected static BufferedImage tailImage = null;

    //Constructor

    public Tail(Snake next)
    {
        super(0,0);
        X = next.getX() - 64;
        Y = next.getY();
        Direction = next.getDirection();
        directions.addAll(next.getAllDirections());

        tailImage = (tailImage == null)? View.OPEN_IMAGE("Images\\snakeImages\\Tail.png") : tailImage;
    }

    public Tail(int x, int y)
    {
        super(x, y);
    }

    //Required Snake methods

    public void draw(Graphics g)
    {
        g.drawImage(tailImage, X + 16, Y + 16, W/2, H/2, null);
    }

    public void update()
    {
        
    }

    //For Parent class

    @Override
    public boolean isTail()
    {
        return true;
    }
    
    //Debugging

    @Override
    public String toString()
    {
        return "Tail (x,y), Direction, Turn (x,y) = (" + X + ", " + Y + "), " + Direction;
    }
}
