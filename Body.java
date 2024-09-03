import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Body extends Snake
{
    //Member variables for Body class

    protected static BufferedImage bodyImage = null;

    //Constructor

    public Body(Snake next)//Passes with single declared tail variable
    {
        super(0,0);
        X = next.getX();
        Y = next.getY();
        this.startDirections(next);
    }

    public Body(int x, int y)
    {
        super(0,0);
        X = x;
        Y = y;

        bodyImage = (bodyImage == null)? View.OPEN_IMAGE("Images\\snakeImages\\Body.png") : bodyImage;
    }

    private void startDirections(Snake next)
    {
        for(int i = 0; i < 16; i++)
        {
            directions.add(new Direction(next));
        }
    }

    //Required Snake methods

    public void draw(Graphics g)
    {
        g.drawImage(bodyImage, X + 16, Y + 16, W/2, H/2, null);
    }   

    public void update()
    {

    }

    //For Parent class

    @Override
    public boolean isBody()
    {
        return true;
    }

    //Debugging

    @Override
    public String toString()
    {
        return "Body (x,y), Direction, Turn (x,y) = (" + X + ", " + Y + "), " + Direction;
    }
}
