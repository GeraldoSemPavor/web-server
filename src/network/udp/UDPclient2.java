package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by codecadet on 24/10/2018.
 */
public class UDPclient2 {

    public static void main(String[] args) {

        System.out.println("Enter words to be sent and received (in all CAPS).\nType exit to terminate the program and socket.");
        Scanner scanner = new Scanner(System.in);
        String exit = "exit";
        String yes = "yes";

        while (true) {
            try {

                int portNumber = 19999;
                int serverPort = 9999;
                byte[] receiver = new byte[1024];
                byte[] sender;


                /** Opening socket */
                DatagramSocket socket = new DatagramSocket(8888);

                /** Receives back the packet and displays the new message to the user */
                DatagramPacket receivePacket = new DatagramPacket(receiver, receiver.length);
                socket.receive(receivePacket);
                String s1 = new String(receiver, 0, receivePacket.getLength());
                System.out.println(s1);

                /** Getting input from user*/
                String toSend = scanner.next();

                /** Exit conditions */
                if (toSend.equals(exit)){
                    System.out.println("Are you sure you wanna quit? (yes) will terminate the programm");
                    if (scanner.next().equals(yes)){
                        return;

                    }
                    System.out.println("Aborting");
                    continue;
                }

                /** Gets the value of the string input to bytes and uses the socket to send packet */
                sender = toSend.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sender, sender.length, InetAddress.getLocalHost(), serverPort);
                socket.send(sendPacket);


                /** Closes socket */
                socket.close();


            } catch (UnknownHostException e) {
                e.getStackTrace();
                System.out.println("unknown host");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("io exception");
            }
        }

    }
}
