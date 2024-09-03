//Used to store the general information for where the snake is going

public class Direction 
{
    private int X,Y,Direction,Turning;

    //Constructors

    public Direction(int x, int y, int direction, int turning) //For the starting the ArrayList off
    {
        X = x;
        Y = y;
        Direction = direction;
        Turning = turning;
    }

    public Direction(Snake head) //Used to update the Snake location
    {
        X = head.getX();
        Y = head.getY();
        Direction = head.getDirection();
    }

    //Getter Methods

    public int getX()
    {
        return X;
    }

    public int getY()
    {
        return Y;
    }

    public int getDirection()
    {
        return Direction;
    }

    public int getTurning()
    {
        return Turning;
    }
}
