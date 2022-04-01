/*
Filename: Server.java
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.UnicastRemoteObject;

// If you don't run the rmiregistry application from the command line
// include the following import:
import java.rmi.registry.*;

/*
Classname: Server
Purpose: The RMI server.
*/

public class Server extends UnicastRemoteObject
	implements IF {
	
	public Server() throws RemoteException {
		super();
	}

	public Double calculation(Double firstPart,Double secondPart, String operator) {
		System.out.println("Invocation to Calculation was succesful!" + "\nFirstpart:" + firstPart +"\nSecondpart:" + secondPart +"\nOperator:" + operator);
		return 0.0;
	}

	public static void main(String args[]) {
		try {

			// Create an object of the CalculationServer class.
		
			Server obj = new Server();
			
			// Bind this object instance to the name "HelloServer".
			// Include the following line if rmiregistry was not started on the command line
            Registry registry;
            try {
                registry = LocateRegistry.createRegistry( 6060 );
            } catch (RemoteException e) {
                registry = LocateRegistry.getRegistry( 6060 );
            }
			 
			// and replace the Naming.rebind() with the next line
			registry.rebind( "Calculation", obj );
		
			// Naming.rebind("Calculation", obj);
			System.out.println("Calculation bound in registry");
		}
		catch (Exception e) {
			System.out.println("Server error: " + e.getMessage());
			e.printStackTrace();
		}
}
}