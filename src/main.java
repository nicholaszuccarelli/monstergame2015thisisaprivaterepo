import com.corundumstudio.socketio.AckCallback;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.VoidAckCallback;
import com.corundumstudio.socketio.demo.ChatObject;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config = new Configuration();
		config.setHostname("localhost");
		config.setPort(3000);
		
		final SocketIOServer server = new SocketIOServer(config);

		/*server.addMessageListener(new DataListener<String>() {
	        public void onData(SocketIOClient client, String message, AckRequest ackRequest) {
	            
	        }
	    });*/

	    /*server.addEventListener("someevent", SomeClass.class, new DataListener<SomeClass>() {
	        public void onData(SocketIOClient client, Object data, AckRequest ackRequest) {
	            
	        }
	    });*/

	    server.addConnectListener(new ConnectListener() {
	        public void onConnect(SocketIOClient client) {
	            System.out.println("Client connected");
	            server.getBroadcastOperations().sendEvent("newconnect");
	        }
	    });

	    server.addDisconnectListener(new DisconnectListener() {
	        public void onDisconnect(SocketIOClient client) {
	            System.out.println("Client disconnected.");
	            server.getBroadcastOperations().sendEvent("newdisconnect");
	        }
	    });

        server.addEventListener("chatevent", ChatObject.class, new DataListener<ChatObject>() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
                // broadcast messages to all clients
            	System.out.println("Message received from client");
                server.getBroadcastOperations().sendEvent("globalevent", data);
                
            }
        });
	    // Don't forget to include type field on javascript side,
	    // it named '@class' by default and should equals to full class name.
	    //
	    // TIP: you can customize type field name via Configuration.jsonTypeFieldName property.

	    /*server.addJsonObjectListener(SomeClass.class, new DataListener<SomeClass>() {
	        public void onData(SocketIOClient client, SomeClass data, AckRequest ackRequest) {

	            // send object to socket.io client
	            SampleObject obj = new SampleObject();
	            client.sendJsonObject(obj);
	        }
	    });*/
        server.start();
	    System.out.println("Started...");
	}
}
