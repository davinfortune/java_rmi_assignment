import java.rmi.Remote;
import java.rmi.RemoteException;

/*

Classname: IF
Comment: The remote interface.

*/

public interface IF extends Remote {
	Double calculation(Double firstPart,Double secondPart, String operator) throws RemoteException;
}