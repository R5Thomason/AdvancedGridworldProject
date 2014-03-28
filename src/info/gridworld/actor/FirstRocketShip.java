package info.gridworld.actor;

import info.gridworld.grid.Location;

import java.awt.Color;

public class FirstRocketShip extends Actor
{

	public FirstRocketShip()
	{
		int red = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		this.setColor(new Color(red, green, blue));

	}

	public void act()
	{

	}
}
