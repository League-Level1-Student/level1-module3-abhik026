package _06_gridworld;

import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class grid {

	public void run() {

		World world = new World();
		world.show();

		Bug buggo = new Bug();
		Location loc = new Location(2, 4);

		world.add(loc, buggo);
		Random ran = new Random();
		int x = ran.nextInt(9) + 1;
		int y = ran.nextInt(9) + 1;

		Location loc1 = new Location(x, y);
		world.add(loc1, buggo);
		buggo.setColor(null);
		buggo.turn();
		buggo.turn();
		Location loc2 = new Location(x, y - 1);
		Location loc3 = new Location(x, y + 1);

		Flower flo = new Flower();
		world.add(loc2, flo);
		world.add(loc3, flo);
		for (int h = 0; h < 10; h++) {
			for (int i = 0; i < 10; i++) {
				Location lo = new Location(i, h);
				world.add(lo, flo);
			}
		}

	}
}
