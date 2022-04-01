/*
Filename: Server.java
*/

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.RMISecurityManager;
import java.rmi.server.ObjID;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteRef;
import java.rmi.server.RemoteServer;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import javax.swing.*;

import java.awt.*;

// If you don't run the rmiregistry application from the command line
// include the following import:
import java.rmi.registry.*;

/*
Classname: Server
Purpose: The RMI server.
*/

public class Server extends UnicastRemoteObject
	implements IF {

		
	static JFrame f;

	static JTextArea serveroutput;

	static Double answer;

	static ArrayList<String> clients = new ArrayList<String>();

	static boolean clientExists;
	
	public Server() throws RemoteException {
		super();
	}

	public Double addCalculation(Double firstPart,Double secondPart) {
		System.out.println("\nInvocation to Calculation was successful!" + "\nFirst part:" + firstPart +"\nSecond part:" + secondPart +"\nOperator:+");
		serveroutput.append("\nInvocation to Calculation was successful!" + "\nFirst part:" + firstPart +"\nSecond part:" + secondPart +"\nOperator:+");
			answer = firstPart+secondPart;
		serveroutput.append("\nCalculation Answer:" + answer);
		clientExists = false;
		try{
			serveroutput.append("\nClient IP:" + RemoteServer.getClientHost());
			// serveroutput.append();
			for(int i = 0; i < clients.size(); i++){
				if(clients.get(i) == RemoteServer.getClientHost()){
					clientExists = true;
					break;
				}
			}
			if(clientExists == false){
				clients.add(RemoteServer.getClientHost());
			}
		} catch(Exception x){
			System.out.println(x);
		}
		return answer;
	}

	public Double minusCalculation(Double firstPart,Double secondPart) {
		System.out.println("\nInvocation to Calculation was successful!" + "\nFirst part:" + firstPart +"\nSecond part:" + secondPart +"\nOperator:-");
		serveroutput.append("\nInvocation to Calculation was successful!" + "\nFirst part:" + firstPart +"\nSecond part:" + secondPart +"\nOperator:-");
			answer = firstPart-secondPart;
		serveroutput.append("\nCalculation Answer:" + answer);
		clientExists = false;
		try{
			serveroutput.append("\nClient IP:" + RemoteServer.getClientHost());
			// serveroutput.append();
			for(int i = 0; i < clients.size(); i++){
				if(clients.get(i) == RemoteServer.getClientHost()){
					clientExists = true;
					break;
				}
			}
			if(clientExists == false){
				clients.add(RemoteServer.getClientHost());
			}
		} catch(Exception x){
			System.out.println(x);
		}
		return answer;
	}

	public Double multCalculation(Double firstPart,Double secondPart) {
		System.out.println("\nInvocation to Calculation was successful!" + "\nFirst part:" + firstPart +"\nSecond part:" + secondPart +"\nOperator:x");
		serveroutput.append("\nInvocation to Calculation was successful!" + "\nFirst part:" + firstPart +"\nSecond part:" + secondPart +"\nOperator:x");
			answer = firstPart*secondPart;
		serveroutput.append("\nCalculation Answer:" + answer);
		clientExists = false;
		try{
			serveroutput.append("\nClient IP:" + RemoteServer.getClientHost());
			// serveroutput.append();
			for(int i = 0; i < clients.size(); i++){
				if(clients.get(i) == RemoteServer.getClientHost()){
					clientExists = true;
					break;
				}
			}
			if(clientExists == false){
				clients.add(RemoteServer.getClientHost());
			}
		} catch(Exception x){
			System.out.println(x);
		}
		return answer;
	}

	public Double divCalculation(Double firstPart,Double secondPart) {
		System.out.println("\nInvocation to Calculation was successful!" + "\nFirst part:" + firstPart +"\nSecond part:" + secondPart +"\nOperator:/");
		serveroutput.append("\nInvocation to Calculation was successful!" + "\nFirst part:" + firstPart +"\nSecond part:" + secondPart +"\nOperator:/");
			answer = firstPart/secondPart;
		serveroutput.append("\nCalculation Answer:" + answer);
		clientExists = false;
		try{
			serveroutput.append("\nClient IP:" + RemoteServer.getClientHost());
			// serveroutput.append();
			for(int i = 0; i < clients.size(); i++){
				if(clients.get(i) == RemoteServer.getClientHost()){
					clientExists = true;
					break;
				}
			}
			if(clientExists == false){
				clients.add(RemoteServer.getClientHost());
			}
		} catch(Exception x){
			System.out.println(x);
		}
		return answer;
	}





	

	public static void main(String args[]) {
		try {

			JFrame f=new JFrame();
			JPanel p = new JPanel(new BorderLayout());
			serveroutput = new JTextArea();
			JScrollPane scrollPanel = new JScrollPane(serveroutput);
			p.add(scrollPanel);
			serveroutput.setEditable(false);
			f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			f.setVisible(true);
			f.pack();

		
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
			serveroutput.append("Calculation bound in registry");

			// add panel to frame
			f.add(p);

			f.setSize(400, 400);
			f.show();
		}
		catch (Exception e) {
			System.out.println("Server error: " + e.getMessage());
			e.printStackTrace();
		}
}
}