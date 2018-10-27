package network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codecadet on 24/10/2018.
 */
public class TCPserver {

    public static void main(String[] args) {

        String newMessage;
        int port = 9999;
        ServerSocket server = null;
        Socket socket = null;

        ServerSocket server2 = null;
        Socket socket2 = null;
        try {
            server = new ServerSocket(port);
            socket = server.accept();

            server2 = new ServerSocket(8888);
            socket2 = server2.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            try {

                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                PrintWriter writer2 = new PrintWriter(socket2.getOutputStream(), true);

                /**FIRST MESSAGE */
                /** Receive from server, alter message and send it back */
                newMessage = reader.readLine();
                newMessage = newMessage.toUpperCase();
                writer.println(newMessage);
                System.out.println("Sent to afonso");
                writer2.println(newMessage);
                System.out.println("sent to sara");

                /** SECOND MESSAGE */
                newMessage = reader.readLine();
                newMessage = newMessage.toUpperCase();
                writer.println(newMessage);

                /** THIRD MESSAGE */
                newMessage = reader.readLine();
                newMessage = newMessage.concat(" What do you mean " + newMessage);
                writer.println(newMessage);






            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
