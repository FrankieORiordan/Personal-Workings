package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import models.PatientModel;
import views.Project;

public class PatientController {
	
	private Project projectView;
	private PatientModel patModel;
	
	private ArrayList<PatientModel> information = new ArrayList<PatientModel>();
	
	public PatientController(Project projectView, PatientModel patModel) {
		
		this.projectView = projectView;
		this.patModel = patModel;
		
		this.projectView.addAddPatientListener(new UpdateListener());
		this.projectView.addRemovePatientListener(new RemoveListener());
	}
	
	class UpdateListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			String name, address, phone;;
			
			name = projectView.getName();
			address = projectView.getAddress();
			phone = projectView.getContact();
			
			patModel.setPatientName(name);
			patModel.setPatientNo();
			patModel.setPatientAdd(address);
			patModel.setPatientPhone(phone);
			
			PatientModel patient = new PatientModel(patModel.getPatientNo(), patModel.getPatientName(),
					patModel.getPatientAdd(), patModel.getPatientPhone());
			
			information.add(patient);
			
			projectView.setInfo(String.valueOf(patModel.getPatientNo()), patModel.getPatientName(),
					patModel.getPatientAdd(), patModel.getPatientPhone());
			
			projectView.clearData();
		}
	}
	
	
	class RemoveListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			projectView.removeInfo();
		}
	}
	
}
