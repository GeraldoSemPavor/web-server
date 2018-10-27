package network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by codecadet on 25/10/2018.
 */
public class Server {

    private int portNumber;
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private BufferedReader reader;
    private PrintWriter writer;

    public Server(int portNumber) {
        this.portNumber = portNumber;
        try {
            serverSocket = new ServerSocket(portNumber);
            socket = serverSocket.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String broadcast() {
        String inboundMessage = null;
        try {
            inboundMessage = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println(inboundMessage);
        return inboundMessage;
    }

    public void broadcast(String message) {
        String inboundMessage = null;
        inboundMessage = message;
        writer.println(inboundMessage);

    }

}
