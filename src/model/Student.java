package model;

import java.io.Serializable;

public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	private String maSV;
	private String hovaten;
	private String IP;
	private int group;
	private String rmiName;
	private int rmiPort;
	
	public Student() {
		
	}
	
	public Student(String maSV, String hovaten, String IP, int group, String rmiName, int rmiPort) {
		super();
		this.maSV = maSV;
		this.hovaten = hovaten;
		this.IP = IP;
		this.group = group;
		this.rmiName = rmiName;
		this.rmiPort = rmiPort;
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHovaten() {
		return hovaten;
	}

	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getRmiName() {
		return rmiName;
	}

	public void setRmiName(String rmiName) {
		this.rmiName = rmiName;
	}

	public int getRmiPort() {
		return rmiPort;
	}

	public void setRmiPort(int rmiPort) {
		this.rmiPort = rmiPort;
	}
	
	
}
