package room;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.sql.Date;

<<<<<<< HEAD:SERVERSIDE/src/Room/room.java
public class Room 
=======
public class Room
>>>>>>> d70ecd7645c9991c02ff64b992a38125b1f362bd:SERVERSIDE/src/room/Room.java
{
	private String ID;
	private int maxPlayers;
	private int minPlayers;
	private int currentPlayers;
	// private DateTime and name as timeCreated;
	private String roomName; 
	private String ownerID;
	private String boardID;
	private int status;
<<<<<<< HEAD:SERVERSIDE/src/Room/room.java
	private Player player[] ;
	public Room(String roomName,String ownerID,int minPlayers , int maxPlayers )
=======
	
	public Room(String roomID, String roomName,String ownerID,int minPlayers , int maxPlayers )
>>>>>>> d70ecd7645c9991c02ff64b992a38125b1f362bd:SERVERSIDE/src/room/Room.java
	{
		this.ID = roomID;
		this.roomName = roomName;
		this.ownerID = ownerID ;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		
		
	}

	
	public String getID()
	{
		return ID;
	}
	
	public void setID(String ID)
	{
		this.ID = ID;
	}
	
	public int getMaxPlayers()
	{
		return maxPlayers;
	}
	
	public void setMaxPlayers(int maxPlayers)
	{
		this.maxPlayers = maxPlayers ;
	}
	
	public int getCurrentPlayers()
	{
		return currentPlayers;
	}
	
	public void setCurrentPlayers(int currentPlayers)
	{
		this.currentPlayers = currentPlayers;
	}
	
	public String getRoomName()
	{
		return roomName ;
	}
	
	public void setRoomName (String roomName)
	{
		this.roomName = roomName ;
	}
	
	public String getOwnerID()
	{
		return ownerID ;
	}
	
	public void setOwnerID (String ownerID)
	{
		this.ownerID = ownerID ;
	}
	
	public String getBoardID()
	{
		return boardID ;
	}
	
	public void setBoardID (String boardID)
	{
		this.boardID = boardID ;
	}
	
	public int getStatus()
	{
		return status ;
	}
	
	public void setStatus (int status)
	{
		this.status = status ;
	}
	
}