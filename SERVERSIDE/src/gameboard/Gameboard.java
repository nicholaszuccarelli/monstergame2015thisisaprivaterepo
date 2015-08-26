package gameboard;

import java.util.UUID;
import player.Player;

public class Gameboard {
	private String ID;
	private char design[][];
	
	public Gameboard()
	{
		this.ID = UUID.randomUUID().toString();
		this.design = new char[][] {
			{'x','x','x','x','x'},
			{'x','y','x','y','x'},
			{'x','x','x','x','x'},
			{'x','y','x','y','x'},
			{'x','x','x','x','x'}
		};
	}
	
	public String getID()
	{
		return ID;
	}
	
	public char[][] getDesign()
	{
		return design;
	}
	
	public boolean updateGameboard(int x, int y, Player p)
	{
		if(getDesign()[x][y] != 'y')
		{
			design[x][y] = (char)p.getBoardID();
			return true;
		}
		return false;
	}
}
