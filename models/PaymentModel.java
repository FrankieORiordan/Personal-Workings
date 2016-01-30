package models;

import java.util.ArrayList;


public class PaymentModel{
	
	private ArrayList<String> patientDetails;
	
	public void PaymentModel() {
		
	}

	
	public ArrayList<String> getPatients() {
		return patientDetails;
	}
	public void setPatients(String patients, String[] procedures, int[] cost) {
		this.patientDetails.add(patients + procedures + cost);
	}
}
