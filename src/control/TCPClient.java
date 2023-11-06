package control;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Student;

public class TCPClient {
	private Socket socket;
	private String serverAddress = "10.23.95.238";
	private int port = 11001;
	private DataInputStream dataInputStream;
	private DataOutputStream dataOutputStream;
	private ObjectInputStream objectInputStream;
	private ObjectOutputStream objectOutputStream;
	
	public void sendRequest(Student student) {
		try {
			socket = new Socket(serverAddress, port);
			
			dataOutputStream = new DataOutputStream(socket.getOutputStream());
			dataInputStream = new DataInputStream(socket.getInputStream());
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			
			dataOutputStream.writeUTF(student.getMaSV());
			dataOutputStream.writeUTF(student.getHovaten());
			dataOutputStream.writeUTF(student.getIP());
			dataOutputStream.writeInt(student.getGroup());
			dataOutputStream.writeUTF(student.getRmiName());
			dataOutputStream.writeInt(student.getRmiPort());
			
			System.out.println(student.getRmiName() + " " + student.getRmiPort());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
