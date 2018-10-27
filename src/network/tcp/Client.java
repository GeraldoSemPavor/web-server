package network.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by codecadet on 25/10/2018.
 */
public class Client {

    private String clientAlias;
    private String hostName;
    private int portNumber;
    private Socket clientSocket;
    private BufferedReader messageBuilder;
    private PrintWriter writer;
    private BufferedReader serverReader;

    public Client(String clientAlias, int portNumber) {

        this.clientAlias = clientAlias;
        hostName = "127.0.0.1";
        this.portNumber = portNumber;
        try {
            clientSocket = new Socket(InetAddress.getByName(hostName), portNumber);
            writer = new PrintWriter(clientSocket.getOutputStream(), true);
            serverReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception");
        }
        messageBuilder = new BufferedReader(new InputStreamReader(System.in));

    }

    public void sendMessage(){
        String message = null;
        try {
            message = messageBuilder.readLine();
            writer.println(message);
            String serverMessage = serverReader.readLine();
            System.out.println(clientAlias + ": " + serverMessage);
            return;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception");
        }
    }
}
