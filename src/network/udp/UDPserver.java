package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by codecadet on 24/10/2018.
 */
public class UDPserver {

    public static void main(String[] args) {

        while (true) {

            try {


                int portNumber = 9999;

                byte[] receiver = new byte[1024];
                byte[] sender;

                /** Opens socket */
                DatagramSocket socket = new DatagramSocket(portNumber);

                /** Socket is used to receive a packet */
                DatagramPacket receivePacket = new DatagramPacket(receiver, receiver.length);
                socket.receive(receivePacket);

                /** Takes the string received, in bytes, and converts to uppercase */
                String convertor = new String(receiver, 0, receivePacket.getLength()).toUpperCase();
                sender = convertor.getBytes();

                /** Socket is used to send a packet with the sender info */
                DatagramPacket sendPacket = new DatagramPacket(sender, sender.length, receivePacket.getAddress(), receivePacket.getPort());
                DatagramPacket sendPacketTo2 = new DatagramPacket(sender, sender.length, InetAddress.getLocalHost(), 8888);
                socket.send(sendPacket);
                socket.send(sendPacketTo2);

                /** Closes socket */
                socket.close();


            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
