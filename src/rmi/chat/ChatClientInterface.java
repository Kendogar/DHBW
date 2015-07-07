package rmi.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Lars on 23.06.2015.
 */
public interface ChatClientInterface extends Remote {
    public void message(String message) throws RemoteException;
    public void message(String user, String message) throws RemoteException;
    public String getUser() throws RemoteException;
}