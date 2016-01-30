package models;

import java.util.ArrayList;

public class PatientModel{

	private int patientNo;
	private static int patientNumber = 1;
	private String patientName;
	private String patientAdd;
	private String patientPhone;
	
	private ArrayList<PatientModel> information = new ArrayList<PatientModel>();
	
	
	public PatientModel() {
		
	}
	
	public PatientModel(int number, String name, String address, String contact) {
		
		this.patientName = name;
		this.patientAdd = address;
		this.patientPhone = contact;
		
	}
	
	public ArrayList<PatientModel> getPatients() {
		
		return information;
	}
	
	public void print() {
		
		for(int i  = 0; i < information.size(); i++) {
			
			System.out.println(information.get(i).toString());
		}
	}
	
	
	public int getPatientNo() {
		return patientNo;
	}
	public void setPatientNo() {
		this.patientNo = patientNumber;
		patientNumber++;
	}
	
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
	public String getPatientAdd() {
		return patientAdd;
	}
	public void setPatientAdd(String patientAdd) {
		this.patientAdd = patientAdd;
	}
	
	
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	
	
	public ArrayList<PatientModel> getList() {
		return information;
	}
	public void setList(ArrayList<PatientModel> info) {
		this.information = info;
	}
	
}
