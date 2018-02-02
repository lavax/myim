package com.teamtyphoon.im.client;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;

import org.apache.tomcat.websocket.WsWebSocketContainer;



@ClientEndpoint
public class WebSocketClient1  {

	
	@OnOpen
	public void onOpen(Session session ) {
		System.out.println( "opened connection" );
		// if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
	}

	@OnMessage
	public void onTextMessage(String message ) {
		System.out.println( "received: " + message );
		
	}
	
	@OnMessage
	public void onBinaryMessage(byte[] message ) {
//		Message.Builder messageBuilder;
//		try {
//			messageBuilder = Message.newBuilder().mergeFrom(message);
//			Message msg = messageBuilder.build();
//
//			System.out.println( "received: " +msg.getTextMessageContent());
//		} catch (InvalidProtocolBufferException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}

	
	@OnClose
	public void onClose(CloseReason cr  ) {
		// The codecodes are documented in class org.java_websocket.framing.CloseFrame
		System.out.println( "Connection closed " +cr.getReasonPhrase()+ "   "+cr.getCloseCode() );
	}

	 @OnError
	 public void onError(Throwable t) throws Throwable{
		 t.printStackTrace();
		// if the error is fatal then onClose will be called additionally
	}

	public static void main( String[] args ) throws URISyntaxException {
		try{//192.168.8.153:18080
			String url="ws://localhost:8080/myim-server/websocket";
			//url="ws://localhost:9080/im-message-server/im/connector?token=20";
			URI uri = new  URI( url ); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
			WsWebSocketContainer wssc=new WsWebSocketContainer();
			WebSocketClient1 client = new WebSocketClient1();
			final Session session=wssc.connectToServer(client, uri);
			//BufferedReader is = new BufferedReader ( new InputStreamReader(System.in));
			long i=0;
			//while(true){
				//String line = is.readLine();
			String line = "";
			for(int n=0;n<1;n++){
				line = String.valueOf(n)+"看到你了";
			    Basic asyncRemote = session.getBasicRemote();
				//asyncRemote.setSendTimeout(1);			  
//				Message.Builder messageBuilder =Message.newBuilder();
//				messageBuilder.setMessageType(MessageType.INSTANT_MESSAGE);
//				messageBuilder.setContentType(ContentType.TEXT_MESSAGE);
//				messageBuilder.setTextMessageContent(line);
//				messageBuilder.setMessageId(i++);
//				messageBuilder.setReceiverType(ReceiverType.GROUP);
//				messageBuilder.setReceiverId(15);
//				Message msg= messageBuilder.build();
				asyncRemote.sendBinary(ByteBuffer.wrap("hello".getBytes()));
			}			
			Thread.sleep(1000);
			session.close();
		}catch(IOException e){
			e.printStackTrace();
		} catch (DeploymentException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}