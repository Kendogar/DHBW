package rmi.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Lars on 23.06.2015.
 */

public interface ChatServerInterface extends Remote {
    public void register(ChatClientInterface client) throws RemoteException;
    public void unregister(ChatClientInterface client) throws RemoteException;
    public void post(String user, String message) throws RemoteException;
}