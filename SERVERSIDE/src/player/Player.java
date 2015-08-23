package player;

import java.util.UUID;


public class Player {
	
	private String name;
	private Boolean type;
	private String ID;
	private int status;
	private String roomID;
	private int score;
	private int boardID;
	private int position[];

	public Player(String name, Boolean type)
	{
		this.name = name;
		this.type = type;
		this.ID = UUID.randomUUID().toString();
		this.roomID = "";
		this.boardID = 0;
		this.position = new int[2];		
		this.score = 0;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Boolean getType()
	{
		return type;
	}
	
	public String getID()
	{
		return ID;
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	public String getRoomID()
	{
		return roomID;
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
		return boardID;
	}
	
	public void setBoardID(int boardID)
	{
		this.boardID = boardID;
	}
	
	public int[] getPosition()
	{
		return position;
	}
	
	public void setPosition(int x, int y)
	{
		this.position[0] = x;
		this.position[1] = y;
	}
}

