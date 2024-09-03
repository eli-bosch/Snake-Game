import java.awt.Graphics;

public abstract class Sprite
{
    //Protected variables for Sprite class

    protected int X,Y,W,H;
    protected boolean Destroy;
    protected boolean Collidable;

    public Sprite(int x, int y, int w, int h)
    {
        X = x;
        Y = y;
        W = w;
        H = h;
    }

    //Setter Methods

    public void setCollidable(boolean collidable)
    {
        Collidable = collidable;
    }

    public void setX(int x)
    {
        X = x;
    }

    public void setY(int y)
    {
        Y = y;
    }

    public void setCordinate(int x, int y)
    {
        X = x;
        Y = y;
    }

    public void setW(int w)
    {
        W = w;
    }

    public void setH(int h)
    {
        H = h;
    }

    public void setDestroy()
    {
        Destroy = true;
    }

    //Getter Methods

    public boolean getCollidable()
    {
        return Collidable;
    }

    public int getX()
    {
        return X;
    }

    public int getY()
    {
        return Y;
    }

    public int getW()
    {
        return W;
    }

    public int getH()
    {
        return H;
    }

    public int getRight()
    {
        return (X + ((3 * W) / 4));
    }

    public int getBottom()
    {
        return (Y + ((3 * H) / 4));
    }

    public int getLeft()
    {
        return (X + (W/4));
    }

    public int getTop()
    {
        return ((Y + H/4));
    }

    public boolean isDestroy()
    {
        return Destroy;
    }

    public int getSquareIndex()
    {
        int x = X / Game.GRID_SIZE;
        int y = Y / Game.GRID_SIZE;
        int index = x + y*10;

        return index;
    }

    //Type of Subclass

    public boolean isSnake()
    {
        return false;
    }

    public boolean isFruit()
    {
        return false;
    }

    //Abstract Methods

    abstract void draw(Graphics g);
    abstract void update();
}