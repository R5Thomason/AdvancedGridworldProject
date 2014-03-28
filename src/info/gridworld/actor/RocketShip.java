package info.gridworld.actor;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class RocketShip extends Actor
{
    private SpaceWhale saveTheWhale;

    public RocketShip()
    {
	int red = (int) (Math.random() * 255);
	int blue = (int) (Math.random() * 255);
	int green = (int) (Math.random() * 255);
	this.setColor(new Color(red, green, blue));
	saveTheWhale = new SpaceWhale();
    }

    public void act()
    {
	turnTowardsWhale();
	move();
    }

    public void turnTowardsWhale()
    {
	Location whaleLocation = processActors(getActor());
	if (saveTheWhale == null)
	{
	    setDirection(this.getLocation().getDirectionToward(new Location(0,0)));
	}
	else
	{
	    setDirection(this.getLocation().getDirectionToward(whaleLocation));
	}
    }

    public void move()
    {
	Grid<Actor> gr = getGrid();
	if (gr == null)
	    return;
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	if (gr.isValid(next))
	    moveTo(next);
	else
	    removeSelfFromGrid();
    }
    
    public ArrayList<Actor> getActor()
    {
	ArrayList<Actor> allActors = new ArrayList<Actor>();
	for(Location temp : getGrid().getOccupiedLocations())
	{
	    if (getGrid().get(temp) instanceof SpaceWhale)
	    {
		allActors.add(getGrid().get(temp));
	    }
	}
	return allActors;
    }
    
    public Location processActors(ArrayList<Actor> actors)
    {
	Location whaleLocation;
	whaleLocation = null;
	for (Actor a : actors)
	{
	    if (a instanceof SpaceWhale)
	    {
		whaleLocation = a.getLocation();
	    }
	}
	
	return whaleLocation;
    }
}
