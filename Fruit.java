import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class Fruit extends Sprite
{
    static BufferedImage fruitImage = null;


    public Fruit(int x, int y, boolean collidable)
    {
        super(x,y,Game.GRID_SIZE/4, Game.GRID_SIZE/4);
        fruitImage = (fruitImage == null) ? View.OPEN_IMAGE("Images\\Fruit.png") : fruitImage;
        Collidable = collidable;
    }

    @Override
    public int getRight()
    {
        return (X+25+W);
    }

    @Override
    public int getBottom()
    {
        return (Y+24+H);
    }

    @Override
    public int getLeft()
    {
        return (X+24);
    }

    @Override
    public int getTop()
    {
        return (Y+24);
    }

    public void draw(Graphics g)
    {
       // g.drawImage(fruitImage, X + 16, Y + 16, W, H, null);

       if(Collidable)
        {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(X + 24, Y + 24, W, H);
        }
    }   

    public void update()
    {

    }

    @Override
    public boolean isFruit()
    {
        return true;
    }
}
