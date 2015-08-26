import player.*;
import room.*;
import gameboard.*;

import java.util.HashMap;
import java.util.UUID;

import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.VoidAckCallback;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

public class main {
	private static HashMap<String, Player> players = new HashMap<String, Player>();
	private static HashMap<String, Room> rooms = new HashMap<String, Room>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.setHostname("localhost");
		config.setPort(301);
		
		final SocketIOServer server = new SocketIOServer(config);

	    server.addConnectListener(new ConnectListener() {
	        public void onConnect(SocketIOClient client) {
	        	String ID = client.getSessionId().toString();
	        	players.put(ID, new Player(ID, true));
	        	
	            System.out.println("Client connected with ID "+ID);
	            
	            String RoomID = UUID.randomUUID().toString();
	            rooms.put(RoomID, new Room(RoomID, "Something", ID, 2, 4));
	            client.joinRoom(RoomID);
	            	            
	            // Sends back an event giving the user their ID
	            client.sendEvent("setup", ID);
	            server.getBroadcastOperations().sendEvent("newconnect");
	        }
	    });

	    server.addDisconnectListener(new DisconnectListener() {
	        public void onDisconnect(SocketIOClient client) {
	            System.out.println("Client disconnected.");
	            server.getBroadcastOperations().sendEvent("newdisconnect");
	        }
	    });

        /*server.addEventListener("chatevent", ChatObject.class, new DataListener<ChatObject>() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
                // broadcast messages to all clients
            	System.out.println("Message received from client");
                server.getBroadcastOperations().sendEvent("globalevent", data);
                
            }
        });*/

        server.start();
	    System.out.println("Started...");
	}
}
