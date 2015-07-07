package rmi.timeservice;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 * Created by Lars on 23.06.2015.
 */
public class TimeServer extends UnicastRemoteObject implements TimeServerInterface {


    TimeServer() throws RemoteException {
        super();
    }

    @Override
    public String getTime() throws RemoteException {
        return "Time is: " + new Date().toString();
    }

    public static void main(String[] args) throws RemoteException {
        System.setProperty("java.rmi.server.hostname", "172.16.48.100");
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Naming.rebind("Time", new TimeServer());
            System.out.println("TimeServer als Server registriert!");
        } catch (MalformedURLException | RemoteException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
