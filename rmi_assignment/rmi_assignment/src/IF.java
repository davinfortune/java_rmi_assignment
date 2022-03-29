import java.rmi.Remote;
import java.rmi.RemoteException;

/*

Classname: IF
Comment: The remote interface.

*/

public interface IF extends Remote {
	String helloWorld() throws RemoteException;
}