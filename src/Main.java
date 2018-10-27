import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by codecadet on 24/10/2018.
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<String> reachableSites = new ArrayList<String>();
        ArrayList<String> unreachableSites = new ArrayList<String>();

        try {

            FileReader reader = new FileReader("resources/sites.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            InetAddress tempInetAdress;

            String host="";

            while ((host=bufferedReader.readLine()) != null){
                tempInetAdress = InetAddress.getByName(host);
                System.out.println(host);
                //System.out.println(tempInetAdress.isReachable(3000));
                if (tempInetAdress.isReachable(1000)){
                    reachableSites.add(host);
                }
                else {
                    unreachableSites.add(host);
                }
            }
            System.out.println("Reachable Sites: " + reachableSites);
            System.out.println("Unreachable Sites: " + unreachableSites);

        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Unknown Host");
        }catch (IOException io){
            io.getStackTrace();
            System.out.println("IO, yo!");
        }

    }
}
