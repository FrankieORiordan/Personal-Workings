package models;

import java.util.ArrayList;

public class ProcedureModel {

	private static int procNumber = 1;
	private int procNo;
	
	ArrayList<String> procedures = new ArrayList<String>();
	ArrayList<String> procedureCost = new ArrayList<String>();
	
	private String pName;
	
	private PatientModel model = new PatientModel();
	
	private ArrayList<PatientModel> patients = new ArrayList<PatientModel>();
	
	
	public ProcedureModel()	{
		
	}
	
	
	public int getProcNumber() {
		return procNo;
	}
	public void setProcNumber() {
		this.procNo = procNumber;
		procNumber++;
	}
	
	
	public ArrayList<String> getProcName() {
		return procedures;
	}
	public void setProcName(String procName) {
		
		int length = procedures.size();
		
		procedures.add(procName);
	}
	
	
	public ArrayList<String> getProcCost() {
		return procedureCost;
	}
	public void setProcCost(String cost) {

		int length = procedureCost.size();
		
		procedureCost.add(cost);
	}
	
	
	public String getPatientName() {
		return pName;
	}
	public void setPatientName() {
		pName = model.getPatientName();
	}
	
	
	public ArrayList<PatientModel> getPatients() {
		return patients;
	}
	public void setPatients() {
		patients = model.getPatients();
	}
	
	
}
