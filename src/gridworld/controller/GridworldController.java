package gridworld.controller;

import info.gridworld.actor.ActorWorld;
import info.gridworld.gui.GridPanel;

public class GridworldController
{
    private GridPanel basePanel;

    public void start()
    {
	
	ActorWorld myWorld = new ActorWorld();
	myWorld.show();
    }

}