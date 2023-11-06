package control;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import model.Student;

public class RMIServer extends UnicastRemoteObject implements IRemoteClient{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String RMIServerName = "RMIServer_Student";
	private int port = 1412;
	private Student student;
	private Registry registry;	
	public RMIServer() throws RemoteException{
		try {
			registry = LocateRegistry.createRegistry(this.port);
			Naming.bind("rmi://10.23.98.89:" + this.port + "/" + this.RMIServerName, this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@Override
	public Student getStudent() throws RemoteException {
		
		return this.student;
	}

	@Override
	public int getMax(int a, int b) throws RemoteException {
		if(a > b) return a;
		return b;
	}

	@Override
	public int getUSCLN(int a, int b) throws RemoteException {
		int r = 0;
		while(b != 0) {
			r = b;
			b = a % b;
			a = r;
		}
		return a;
	}

	@Override
	public int getBSCNN(int a, int b) throws RemoteException {
		return (a * b) / getUSCLN(a, b);
	}

	@Override
	public String getReverse(String str) throws RemoteException {
		String result = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i); 
		}
		return result;
	}

	@Override
	public String getNormalization(String str) throws RemoteException {
		String[] temp = str.split(" ");
		str = "";
		for(int i = 0; i < temp.length; i++) {
			temp[i] = temp[i].substring(0,1).toUpperCase() + temp[i].substring(1).toLowerCase();
			if(i != temp.length - 1) str += temp[i] + " ";
			else str += temp[i];
		}
		return str;
		
	}

	public String getRMIServerName() {
		return RMIServerName;
	}

	public void setRMIServerName(String rMIServerName) {
		RMIServerName = rMIServerName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	

}
