package network.tcp;

import java.util.Scanner;

/**
 * Created by codecadet on 25/10/2018.
 */
public class ClientMain {

    public static void main(String[] args) {

        Client afonso = new Client("GeraldoSemPavor says", 9999);
        Scanner methodDecider = new Scanner(System.in);

        while (true){

            System.out.println("Options: send");
            switch (methodDecider.next()){
                case "send":
                    System.out.println("Ready to send, enter message!");
                    afonso.sendMessage();
                    break;
                default:
                    System.out.println("At the default  ");
            }


        }
    }
}
