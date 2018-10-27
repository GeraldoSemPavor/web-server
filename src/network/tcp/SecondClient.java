package network.tcp;

import java.util.Scanner;

/**
 * Created by codecadet on 25/10/2018.
 */
public class SecondClient {

    public static void main(String[] args) {

        Client sara = new Client("CodeNazi says", 8888);
        Scanner methodDecider = new Scanner(System.in);

        while (true){

            switch (methodDecider.next()){
                case "send":
                    System.out.println("Ready to send, enter message!");
                    sara.sendMessage();
                    break;
                default:
                    System.out.println("At the default  ");
            }


        }
    }
}
