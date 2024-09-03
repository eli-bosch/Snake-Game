import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Head extends Snake
{
    //Private Head class variables

    private  BufferedImage headImage;
    private int nextDirection = 0;
    private Direction Current;
    private final int Speed = 4;

    //Constructor for Head class

    public Head(int x, int y)
    {
        super(x, y);
        headImage = View.OPEN_IMAGE("Images\\snakeImages\\Head.png");
        this.startDirections();
    }

    private void startDirections()
    {
        if(directions.size() < 17)
        {
            for(int i = 0; i < 16; i++)
            {
                directions.add(new Direction(Game.GRID_SIZE*2 + (4*i), Game.GRID_SIZE*5, Direction, -1));
            }
        } 
        
    }

    //Setter Methods

    public void setNextDirection(int direction)
    {
        if((direction + 2) % 4 != Direction)
            nextDirection = direction;
    }

    //Update Methods

    private void updateDirection()
    {
        if((nextDirection == 0 || nextDirection == 2) && (Y % Game.GRID_SIZE) == 0)
            Direction = nextDirection;
        else if((nextDirection == 1 || nextDirection == 3) && (X % Game.GRID_SIZE) == 0)
            Direction = nextDirection;
    }

    private void updateMovement() //Calls in update for constant speed
    {
        switch(Direction)
        {
            case 0: this.X += this.Speed; break; //Right
            case 1: this.Y += this.Speed; break; //Down
            case 2: this.X -= this.Speed; break; //Left
            case 3: this.Y -= this.Speed; break; //Up
            default: break;
        }
    }

    @Override
    protected Direction getDirections()
    {
        Current = (new Direction(this));

        return Current;
    }   

    //Required Snake Methods

    public void draw(Graphics g)
    {
        g.drawImage(headImage, X + 16, Y + 16, W/2, H/2, null); //Draws Head in center of cordinates and halves the size
    }

    public void update() //Constantly gets called through Model class
    {
        this.updateDirection();
        this.updateMovement();
    }

    //For Parent class
    
    @Override
    public boolean isHead()
    {
        return true;
    }

    //Debugging

    @Override
    public String toString()
    {
        return "Head (x,y), Direction, Turn(x,y) = (" + X + ", " + Y + "), " + Direction + ", " + nextDirection;
    }
}