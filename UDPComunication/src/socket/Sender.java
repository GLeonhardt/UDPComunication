package socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Guilherme Leonhardt
 */
public class Sender{
    private int UDPport;
    private byte[] msgTemp;
    
   public void send(String message, String hostStr, String port) throws SocketException, IOException{
        InetAddress host = InetAddress.getByName(hostStr);
        UDPport = Integer.parseInt(port);
        msgTemp = message.getBytes();
        try (DatagramSocket serverSocket = new DatagramSocket()) {
            DatagramPacket sendPacket =new DatagramPacket(msgTemp, msgTemp.length, host, UDPport);
            serverSocket.send(sendPacket);
        }
   }
}
