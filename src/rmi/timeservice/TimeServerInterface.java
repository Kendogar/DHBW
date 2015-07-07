package rmi.timeservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Lars on 23.06.2015.
 */
public interface TimeServerInterface extends Remote {

    public String getTime() throws RemoteException;

}
