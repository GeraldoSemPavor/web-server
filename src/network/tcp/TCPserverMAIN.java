package network.tcp;

/**
 * Created by codecadet on 25/10/2018.
 */
public class TCPserverMAIN {

    public static void main(String[] args) {

        Server server9999 = new Server(9999);
        Server server8888 = new Server(8888);

        while (true){

            server9999.broadcast();
            server8888.broadcast("hi");
        }
    }
}
