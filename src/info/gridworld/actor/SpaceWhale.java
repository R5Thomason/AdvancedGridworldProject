package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;
import java.util.ArrayList;

public class SpaceWhale extends Rock
{

    private int directionOfWhale;

    public SpaceWhale()
    {
	int red = (int) (Math.random() * 255);
	int blue = (int) (Math.random() * 255);
	int green = (int) (Math.random() * 255);
	this.setColor(new Color(red, green, blue));
    }

    public Location getSpaceWhaleLocation()
    {
	return this.getLocation();
    }

    public ArrayList<Actor> getNeighbors()
    {
	return getGrid().getNeighbors(getLocation());
    }

    public void processActors(ArrayList<Actor> otherActors)
    {
	BlackHole blackHole = new BlackHole();
	for (Actor neighbor : otherActors)
	{
	    if (otherActors.size() == 2 && !otherActors.contains(blackHole))
	    {
		moveTo(findRandomEmptyLocation());
	    }
	}
    }

    public Location findRandomEmptyLocation()
    {
	Grid<Actor> currentGrid = getGrid();

	if (currentGrid == null)
	{
	    return null;
	}

	if (currentGrid.getNumCols() == -1)
	{
	    int randomX = (int) (Math.random() * 100);
	    int randomY = (int) (Math.random() * 100);
	    Location newSpot = new Location(randomX, randomY);

	    while (currentGrid.get(newSpot) != null)
	    {
		randomX = (int) (Math.random() * 100);
		randomY = (int) (Math.random() * 100);
		newSpot = new Location(randomX, randomY);
	    }

	    return newSpot;
	}
	else
	{
	    int randomX = (int) (Math.random() * 100) % currentGrid.getNumRows();
	    int randomY = (int) (Math.random() * 100) % currentGrid.getNumCols();

	    Location newSpot = new Location(randomX, randomY);

	    while (currentGrid.get(newSpot) != null)
	    {
		randomX = (int) (Math.random() * 100) % currentGrid.getNumRows();
		randomY = (int) (Math.random() * 100) % currentGrid.getNumCols();
		newSpot = new Location(randomX, randomY);
	    }

	    return newSpot;
	}

    }

    public void act()
    {
	if (getGrid() == null)
	{
	    return;
	}

	ArrayList<Actor> neighbors = getNeighbors();
	processActors(neighbors);
    }
}
