package rmi.timeservice;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Lars on 23.06.2015.
 */
public class Client {
    public static void main(String[] args) {
        try {
            String url = "//172.16.47.143/Time";
            TimeServerInterface server = (TimeServerInterface) Naming.lookup(url);
            System.out.println(server.getTime());
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
