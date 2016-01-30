package controllers;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.PatientModel;
import models.ProcedureModel;
import views.Project;

public class ProcedureController {

	private Project projectView;
	private PatientModel patModel;
	private ProcedureModel proModel;
	
	public ProcedureController(Project projectView, PatientModel patModel, ProcedureModel proModel) {

		this.projectView = projectView;
		this.patModel = patModel;
		this.proModel = proModel;
		
		this.projectView.addAddPatientListener(new AddPatientListener());
		this.projectView.addRemovePatientListener(new RemovePatientListener());
		
		this.projectView.addNewProcedureListener(new NewProcedureListener());
		this.projectView.addRemoveProcedureListener(new RemoveProcedure());
	}
	
	class AddPatientListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String name, address;
			
			name = projectView.getName();
			address = projectView.getAddress();
			
			patModel.setPatientName(name);
			patModel.setPatientAdd(address);
			
			projectView.addPatientsToComboBox(name, address);
		}
	}
	
	class RemovePatientListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			projectView.removePatientFromComboBox();
		}
	}
	
	
	class NewProcedureListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			JTextField procName = new JTextField(10);
			JTextField procCost = new JTextField(5);
			
			JPanel option = new JPanel();
			option.add(new Label("Procedure Name"));
			option.add(procName);
			
			option.add(Box.createHorizontalStrut(15));
			
			option.add(new Label("Procedure Cost"));
			option.add(procCost);
			
			int result = JOptionPane.showConfirmDialog(null, option, "New Procedure", JOptionPane.OK_CANCEL_OPTION);
			
			if(result == JOptionPane.OK_OPTION) {
				
				projectView.setProcedures(procName.getText(), procCost.getText());
			}
		}
	}
	
	
	class RemoveProcedure implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			projectView.removeProcedure();
		}
	}

}
