package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import models.PatientModel;
import models.PaymentModel;
import models.ProcedureModel;
import views.Project;

public class PaymentController {

	private Project projectView;
	private PatientModel patModel;
	private ProcedureModel proModel;
	private PaymentModel payModel;
	
	public PaymentController (Project projectView, PatientModel patModel, ProcedureModel proModel, PaymentModel payModel){
		
		this.projectView = projectView;
		this.patModel = patModel;
		this.proModel = proModel;
		this.payModel = payModel;
		
		this.projectView.addAddPatientListener(new AddPatientListener());
		this.projectView.addRemovePatientListener(new RemovePatientListener());
		
		this.projectView.addSetProcedureListener(new SetProcedureListener());
	}
	
	
	class AddPatientListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String name, address;
			
			name = projectView.getName();
			address = projectView.getAddress();
			
			patModel.setPatientName(name);
			patModel.setPatientAdd(address);
			
			projectView.addPatientListToComboBox(name, address);
		}
	}
	
	class RemovePatientListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			projectView.removePatientListFromComboBox();
		}
	}
	
	
	class SetProcedureListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			List procedures = projectView.getProcedures().getSelectedValuesList();
			
			projectView.addProcedureToPatient(procedures);
		}
	}
	
}
