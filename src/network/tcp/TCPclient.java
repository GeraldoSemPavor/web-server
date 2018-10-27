package network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by codecadet on 24/10/2018.
 */
public class TCPclient {

    public static void  main(String[] args) {

            int port = 9999;
            String hostName = "127.0.0.1";

        try {

            /** Creating socket */
            Socket socket = new Socket(InetAddress.getByName(hostName), port);

            /** Message builder, writer and reader */
            BufferedReader messageBuilder = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            /**FIRST MESSAGE */
            /** Write message and send to server */
            String message = messageBuilder.readLine();
            writer.println(message);
            /** Receive from server and print to client*/
            String serverMessage = serverReader.readLine();
            System.out.println("Server said: " + serverMessage);


            /** SECOND MESSAGE */
            String secondMessage = messageBuilder.readLine();
            writer.println(secondMessage);
            secondMessage = serverReader.readLine();
            System.out.println("Returned Message is: " + secondMessage);


            /** THIRD MESSAGE */
            String thirdMessage = messageBuilder.readLine();
            writer.println(thirdMessage);
            thirdMessage = serverReader.readLine();
            System.out.println("Server now said: " + thirdMessage);







        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
