package socket;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javafx.application.Platform;
import static socket.Socket.controller;

/**
 *
 * @author Guilherme Leonhardt
 */
public class Server implements Runnable{
    
    private int portTemp ;
    private String receivedAddress;
    private DatagramSocket socket;
    private String address;
    private String msg;
    
    public Server(String port) {
        portTemp = Integer.parseInt(port);
        try {
            socket = new DatagramSocket(portTemp);
        } catch (SocketException ex) {
            ex.printStackTrace();
        }
    }
    
     @Override 
    public void run(){
	while(true){
            Platform.runLater(new Runnable() {
		@Override public void run() {
		}
	});
                receive();   
	}
    }
    public void start(){
        Thread thread = new Thread(this);
        thread.start();
     }
    
    public void receive() {
        try{
            byte[] received = new byte[65536];

            DatagramPacket receivedPacket = new DatagramPacket(received, received.length);
            socket.receive(receivedPacket);
            msg = new String(new String(receivedPacket.getData()));
            address = receivedPacket.getAddress().toString();
           controller.log("Received: \""+ msg + "\"  From: "+address);
           
            
            
        }catch(IOException e){
            System.out.println("deu ruim na funcao receive ");
        }
    }
    
    
}
