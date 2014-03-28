package info.gridworld.actor;

import info.gridworld.world.World;

import java.awt.Color;
import java.util.ArrayList;

public class SpaceWhale extends Rock
{
	public SpaceWhale()
	{
		int red = (int)(Math.random()*255);
		int blue = (int)(Math.random()*255);
		int green = (int)(Math.random()*255);
		this.setColor(new Color(red, green, blue));
	}
	
	public ArrayList<Actor> getActors()
	{
		return getGrid().getNeighbors(getLocation());
	}
	
	
	
	public void processActors(ArrayList<Actor> otherActors)
	{
		FirstRocketShip ship = new FirstRocketShip();
		SecondRocketShip shipTwo = new SecondRocketShip();
		int numberOfNeighborShips = 0;
		for (Actor neighbor : otherActors)
		{
			if(otherActors.contains(ship))
			{	
				numberOfNeighborShips++;
				if(numberOfNeighborShips == 2)
				{
					
				}
			}
		}
	}
	
	public void act()
	{
		if (getGrid() == null)
		{
			return;
		}
		ArrayList<Actor> neighbors = getActors();
		processActors(neighbors);
	}
}
