package gridworld.controller;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.BlackHole;
import info.gridworld.actor.RocketShip;
import info.gridworld.actor.SpaceWhale;
import info.gridworld.grid.Location;
import info.gridworld.gui.GridPanel;

public class GridworldController
{
    private GridPanel basePanel;

    public void start()
    {
	
	ActorWorld myWorld = new ActorWorld();
	myWorld.add(new SpaceWhale());
	myWorld.add(new RocketShip());
	myWorld.add(new RocketShip());
	myWorld.add(new BlackHole());
	
	myWorld.show();
    }

}
