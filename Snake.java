import java.awt.Graphics;
import java.util.ArrayList;

public abstract class Snake extends Sprite
{
    protected int Direction;
    protected ArrayList<Direction> directions;

    //Snake Constructor

    public Snake(int x, int y)
    {
        super(x, y, 64, 64);
        Direction = 0;
        Collidable = true;
        directions = new ArrayList<Direction>();
    }

    public Snake(Direction direction)
    {
        super(0, 0, 64, 64);
        this.setDirections(direction);
    }

    //Getter Methods

    public int getDirection()
    {
        return Direction;
    }

    protected Direction getDirections()
    {
        return directions.get(0);
    }

    protected ArrayList<Direction> getAllDirections()
    {
        return directions;
    }

    //Setter Methods

    protected void setDirections(Direction direction)
    {
        X = directions.get(0).getX();
        Y = directions.get(0).getY();
        Direction = directions.get(0).getDirection();

        directions.remove(0);
        directions.add(direction);
    }

    //Abstract methods for the Snake class

    public abstract void draw(Graphics g);
    public abstract void update();

    //Checks the type of Snake Subclass

    public boolean isHead()
    {
        return false;
    }

    public boolean isBody()
    {
        return false;
    }
    
    public boolean isTail()
    {
        return false;
    }

    //For parent class

    @Override
    public boolean isSnake() 
    {
        return true;
    }
}
