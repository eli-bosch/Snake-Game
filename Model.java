import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Model
{
	//Private variables for Model class
	
	private ArrayList<Sprite> sprites, spritesBuffer;
	private boolean addFruit;
	private int Length, Random;
	private Head head;
	private Tail tail;

	//Constructor Method
	
	public Model()
	{
		head = new Head(Game.GRID_SIZE*(3), Game.GRID_SIZE*(5));
		tail = new Tail(head);

		spritesBuffer = new ArrayList<Sprite>();
		sprites = new ArrayList<Sprite>();
		addFruit = false;
		sprites.add(tail);
		sprites.add(head);
		this.setFruits();
		Length = 1;
		Random = -1;
	}

	//Setter Methods

	private void setSprites()
	{
		for(int i = 0; i < spritesBuffer.size(); i++)
		{
			Sprite temp = spritesBuffer.get(i);

			if(temp.isDestroy())
				sprites.remove(temp);
			else if(temp.isSnake())
			{
				sprites.add(1, new Body(((Snake)sprites.get(1))));
				Length++;
				System.out.println(temp.toString());
			}

			spritesBuffer.clear();
		}
	}

	private void setFruits()
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{

				if(i == 6 && j == 5)
					sprites.add(new Fruit(i*Game.GRID_SIZE, j*Game.GRID_SIZE, true));
				else
					sprites.add(new Fruit(i*Game.GRID_SIZE, j*Game.GRID_SIZE, false));
			}
		}
	}

	private void setNewFruit()
	{
			if(Random == -1)
			{
				Random rand = new Random();
				Random = rand.nextInt(1,100);
			}

			Sprite fruit = sprites.get(Length + Random);
			fruit.setCollidable(true);

			for(int i = 0; i <= Length; i++)
			{

				Snake temp = ((Snake)sprites.get(i));
				
				if(Collision(fruit, temp))
				{
					Random = (Random + 1) % 101;
					Random = (Random == 0) ? 1 : Random;
					fruit.setCollidable(false);
					setNewFruit();
				} else
				{
					Random rand = new Random();
					Random = rand.nextInt(1, 100);
					return;
				}
			}
	
	}

	public void setNewSegment()
	{
		spritesBuffer.add(new Body(0, 0));
	}

	//Methods that handle the Sprites
	
	public void handleSnakeDirection(int direction)
	{
		head.setNextDirection(direction);
	}

	//Methods that need to be updated every frame

	private void updateSnake()
	{
		head.update();
		Snake previous = null;

		for(Iterator<Sprite> it = sprites.iterator(); it.hasNext();)
		{
			Sprite temp = it.next();

			if(temp.isSnake())
			{
				Snake current = ((Snake)temp);

				if(previous != null)
					previous.setDirections(current.getDirections());
				previous = current;
			}

			if(previous == head)
				return;
		}
	}	

	private void updateCollision()
	{
		if(head.getRight() > 640)
		{
			System.out.print("Game Over");
		} else if(head.getLeft() < 0)
		{
			System.out.print("Game Over");
		} else if(head.getTop() < 0)
		{
			System.out.print("Game Over");
		} else if(head.getBottom() > 640)
		{
			System.out.print("Game Over");
		}

		for(Iterator<Sprite> it = sprites.iterator(); it.hasNext();)
		{
			Sprite temp = it.next();

			if(Collision(head, temp))
			{	
				if(temp.isFruit())
				{
					temp.setCollidable(false);
					this.setNewSegment();
					this.setNewFruit();
				} else if(sprites.indexOf(temp) < Length - 4)
				{
					System.out.println("Game Over");
				}
			}
		}
	}

	//Default collision Method

	private boolean Collision(Sprite temp, Sprite temp2)
	{
		if(temp == temp2)
			return false;
		if(!temp.getCollidable() || !temp2.getCollidable())
			return false;
		if(temp2.getRight() < temp.getLeft())
			return false;
		if(temp2.getBottom() < temp.getTop())
			return false;
		if(temp2.getLeft() > temp.getRight())
			return false;
		if(temp2.getTop() > temp.getBottom())
			return false;
		return true;
	}

	//Getter Methods

	public ArrayList<Sprite> getSprites()
	{
		return sprites;
	}

	//Update Method called in Game


	public void update()
	{
		this.updateSnake();
		this.updateCollision();
		this.setSprites();
	}
}