import java.rmi.Remote;
import java.rmi.RemoteException;

/*

Classname: IF
Comment: The remote interface.

*/

public interface IF extends Remote {
	Double addCalculation(Double firstPart,Double secondPart) throws RemoteException;
	Double minusCalculation(Double firstPart,Double secondPart) throws RemoteException;
	Double multCalculation(Double firstPart,Double secondPart) throws RemoteException;
	Double divCalculation(Double firstPart,Double secondPart) throws RemoteException;
}