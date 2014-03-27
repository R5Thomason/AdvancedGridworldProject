package info.gridworld.actor;

import java.util.ArrayList;

public class BlackHole extends Rock 
{
	public BlackHole()
	{
		
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

	public void processActors(ArrayList<Actor> otherActors)
	{
		for (Actor neighbor : otherActors)
		{
			neighbor.removeSelfFromGrid();
		}
	}

	public ArrayList<Actor> getActors()
	{
		return getGrid().getNeighbors(getLocation());
	}
}
