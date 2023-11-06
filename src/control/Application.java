package control;

import java.rmi.RemoteException;

import model.Student;

public class Application {
	public static void main(String[] args) {
		
		RMIServer rmiServer;
		
		try {
			rmiServer = new RMIServer();
			
			Student student = new Student();
			student.setMaSV("B20DCVT259");
			student.setHovaten("Hoang Van Nam");
			student.setIP("10.23.98.89");
			student.setGroup(4);
			student.setRmiName(rmiServer.getRMIServerName());
			student.setRmiPort(rmiServer.getPort());
			
			rmiServer.setStudent(student);
			
			TCPClient tcpClient = new TCPClient();
			tcpClient.sendRequest(student);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
			
	}
}
