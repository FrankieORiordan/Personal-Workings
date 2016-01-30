package application;

import java.util.Scanner;

import models.PatientModel;
import models.PaymentModel;
import models.ProcedureModel;
import views.Project;
import controllers.ComponentSerializer;
import controllers.PatientController;
import controllers.PaymentController;
import controllers.ProcedureController;
import controllers.SavingAndLoading;

public class Driver {

	static Scanner kb = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Project project = new Project();
		
		PatientModel patModel = new PatientModel();
		new PatientController(project, patModel);
		
		ProcedureModel proModel = new ProcedureModel();
		new ProcedureController(project, patModel, proModel);
		
		PaymentModel payModel = new PaymentModel();
		new PaymentController(project, patModel, proModel, payModel);
		
		ComponentSerializer serial = new ComponentSerializer();
		new SavingAndLoading(project, serial);
		
		project.frame.setVisible(true);
	}

}
