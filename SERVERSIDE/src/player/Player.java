package player;

import java.util.UUID;


public class Player {
	
	private String name;
	private boolean type;
	private String ID;
	private int status;
	private String roomID;
	private int score;
	private int boardID;
	private int position[];
	private boolean isInit = false;

	public Player(String ID, boolean type)
	{
		this.name = "";
		this.type = type;
		this.ID = ID;
		this.roomID = "";
		this.boardID = 0;
		this.position = new int[2];		
		this.score = 0;
	}
	
	public boolean checkInit()
	{
		if(isInit)
		{
			return true;
		}
		return false;
	}
	
	public void setInit()
	{
		if(!isInit)
		{
			this.isInit = true;
		}
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String str)
	{
		this.name = str;
	}
	
	public boolean getType()
	{
		return this.type;
	}
	
	public String getID()
	{
		return this.ID;
	}
	
	public int getStatus()
	{
		return this.status;
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public String getRoomID()
	{
		return this.roomID;
	}
	
	public void setRoomID(String roomID)
	{
		this.roomID = roomID;
	}
	
	public void setScore(int score)
	{
		this.score = score;
	}
	
	public int getBoardID()
	{
		return this.boardID;
	}
	
	public void setBoardID(int boardID)
	{
		this.boardID = boardID;
	}
	
	public int[] getPosition()
	{
		return this.position;
	}
	
	public void setPosition(int x, int y)
	{
		this.position[0] = x;
		this.position[1] = y;
	}
}

