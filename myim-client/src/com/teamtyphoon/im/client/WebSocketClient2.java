//package com.teamtyphoon.im.client;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.nio.ByteBuffer;
//
//import javax.websocket.ClientEndpoint;
//import javax.websocket.CloseReason;
//import javax.websocket.DeploymentException;
//import javax.websocket.OnClose;
//import javax.websocket.OnError;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.RemoteEndpoint.Basic;
//import javax.websocket.Session;
//
//import org.apache.tomcat.websocket.WsWebSocketContainer;
//
//import com.google.protobuf.InvalidProtocolBufferException;
//import com.sinolife.im.backend.protobuf.MessageProtocol.ContentType;
//import com.sinolife.im.backend.protobuf.MessageProtocol.Message;
//import com.sinolife.im.backend.protobuf.MessageProtocol.MessageType;
//import com.sinolife.im.backend.protobuf.MessageProtocol.ReceiverType;
//
//
//
//
//
//@ClientEndpoint
//public class WebSocketClient2  {
//
//
//	@OnOpen
//	public void onOpen(Session session ) {
//		System.out.println( "opened connection" );
//		session.setMaxBinaryMessageBufferSize(1024*512);
//		// if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
//	}
//
//	@OnMessage
//	public void onTextMessage(String message ) {
//		System.out.println( "received: " + message );
//
//	}
//
//	@OnMessage
//	public void onBinaryMessage(byte[] message ) {
//		Message.Builder messageBuilder;
//		try {
//			messageBuilder = Message.newBuilder().mergeFrom(message);
//			Message msg = messageBuilder.build();
//
//			System.out.println( "received  from : "+msg.getSenderId()+" msg: " + msg.getTextMessageContent() );
//		} catch (InvalidProtocolBufferException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//
//	}
//
//
//	@OnClose
//	public void onClose(CloseReason cr  ) {
//		// The codecodes are documented in class org.java_websocket.framing.CloseFrame
//		System.out.println( "Connection closed " +cr.getReasonPhrase()+ "   "+cr.getCloseCode() );
//	}
//
//	 @OnError
//	 public void onError(Throwable t) throws Throwable{
//		 t.printStackTrace();
//		// if the error is fatal then onClose will be called additionally
//	}
//
//	public static void main( String[] args ) throws URISyntaxException {
//		try{//192.168.8.153:18080
//			String url="ws://192.168.8.153:29080/im-message-server/im/connector?token=19";
//			//url="ws://localhost:9080/im-message-server/im/connector?token=19";
//			URI uri = new  URI( url ); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
//			WsWebSocketContainer wssc=new WsWebSocketContainer();
//			WebSocketClient2 client = new WebSocketClient2();
//			final Session session=wssc.connectToServer(client, uri);
//			BufferedReader is = new BufferedReader ( new InputStreamReader(System.in));
//			long i=0;
//			while(true){
//				String line = is.readLine();
//				 Basic asyncRemote = session.getBasicRemote();
//				//asyncRemote.setSendTimeout(1);
//				 Message.Builder messageBuilder =Message.newBuilder();
//					messageBuilder.setMessageType(MessageType.INSTANT_MESSAGE);
//					messageBuilder.setContentType(ContentType.TEXT_MESSAGE);
//					messageBuilder.setTextMessageContent(line);
//					messageBuilder.setMessageId(i++);
//					messageBuilder.setReceiverType(ReceiverType.PERSON);
//					messageBuilder.setReceiverId(1l);
//					Message msg= messageBuilder.build();
//					asyncRemote.sendBinary(ByteBuffer.wrap(msg.toByteArray()));
//			}
//		}catch(IOException e){
//			e.printStackTrace();
//		} catch (DeploymentException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//}