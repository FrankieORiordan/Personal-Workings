package views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;


public class Project {

	public JFrame frame;
	
	// Menu Items
	private JMenuItem save = new JMenuItem("Save");
	private JMenuItem load = new JMenuItem("Load");
	private JMenuItem exit = new JMenuItem("Exit");
	
	
	// Patient GUI
	private JTextArea textName = new JTextArea();
	private	JTextArea textAddress = new JTextArea();
	private JTextArea textContact = new JTextArea();
	DefaultListModel patientInfoModel = new DefaultListModel();
	private	JList patientInfo = new JList(patientInfoModel);
	private JButton addPatient = new JButton("Add");
	private JButton removePatient = new JButton("Remove");
	
	
	// Procedure GUI
	DefaultComboBoxModel patientListModel = new DefaultComboBoxModel();
	private	JComboBox patientList = new JComboBox(patientListModel);
	private JButton setProcedure = new JButton("Set Procedure");
	private JButton removeProcedure = new JButton("Remove Procedure");
	DefaultListModel procedureListModel = new DefaultListModel();
	private JList procedureList = new JList(procedureListModel);
	private JButton addProcedure = new JButton("Add Procedure");
	private JButton deleteProcedure = new JButton("Delete Procedure");
	
	
	// Payment GUI
	DefaultComboBoxModel listOfPatientsModel = new DefaultComboBoxModel();
	private JComboBox listOfPatients = new JComboBox(listOfPatientsModel);
	private JTextArea listOfProcedures = new JTextArea();
	private	JButton pay = new JButton("Pay");
	private	JButton dontPay = new JButton("Don't Pay");
	
	ArrayList<String> patientsAndProcedures = new ArrayList<String>();
	ArrayList<String> patients = new ArrayList<String>();
	ArrayList<String> procedures = new ArrayList<String>();
	
	/**
	 * Create the application.
	 */
	public Project() {
		
		Frame();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void Frame() {
		
		frame = new JFrame("Dentist App");
		frame.setBounds(100, 100, 810, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu file = new JMenu("File");
		menuBar.add(file);
		
		// Saving
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileOutputStream f;
				try {
					f = new FileOutputStream("Dentist.bin");
					ObjectOutputStream ostream = new ObjectOutputStream(f);
					Object object = frame;
					ostream.writeObject(object);
					ostream.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		file.add(save);
		
		// Loading
		load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File file = new File("Dentist.bin");
				ObjectInputStream in;
				
				try {
					
					in = new ObjectInputStream(new FileInputStream(file));
					JFrame object = (JFrame) in.readObject();
					in.close();
					
				} catch (ClassNotFoundException | IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		file.add(load);
		
		file.add(exit);
		frame.getContentPane().setLayout(null);
		
		
		//Patient Tabbing
		JTabbedPane patients = new JTabbedPane(JTabbedPane.TOP);
		patients.setBounds(10, 11, 387, 619);
		frame.getContentPane().add(patients);
		
		JPanel patientPanel = new JPanel();
		patients.addTab("Patients", null, patientPanel, null);
		patientPanel.setLayout(null);
		
		JLabel name = new JLabel("Name:");
		name.setBounds(30, 36, 63, 14);
		patientPanel.add(name);
		
		textName.setBounds(130, 31, 236, 22);
		patientPanel.add(textName);
		
		JLabel address = new JLabel("Address:");
		address.setBounds(30, 69, 63, 14);
		patientPanel.add(address);
		
		textAddress.setBounds(130, 64, 236, 22);
		patientPanel.add(textAddress);
		
		JLabel contact = new JLabel("Contact:");
		contact.setBounds(30, 102, 63, 14);
		patientPanel.add(contact);
		
		textContact.setBounds(130, 97, 236, 22);
		patientPanel.add(textContact);
		
		addPatient.setBounds(45, 146, 89, 23);
		patientPanel.add(addPatient);
		
		removePatient.setBounds(248, 146, 89, 23);
		patientPanel.add(removePatient);
		
		patientInfo.setBounds(30, 180, 316, 348);
		patientPanel.add(patientInfo);
		
		
		//Procedure Tabbing
		JTabbedPane proceduresAndPayments = new JTabbedPane(JTabbedPane.TOP);
		proceduresAndPayments.setBounds(407, 11, 377, 619);
		frame.getContentPane().add(proceduresAndPayments);
		
		JPanel procedurePanel = new JPanel();
		proceduresAndPayments.addTab("Procedures", null, procedurePanel, null);
		procedurePanel.setLayout(null);
		
		patientList.setBounds(40, 41, 297, 20);
		procedurePanel.add(patientList);
		
		setProcedure.setBounds(24, 99, 149, 23);
		procedurePanel.add(setProcedure);
		
		removeProcedure.setBounds(204, 99, 149, 23);
		procedurePanel.add(removeProcedure);
		
		procedureList.setBounds(59, 156, 267, 297);
		procedureList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		procedurePanel.add(procedureList);
		
		addProcedure.setBounds(40, 507, 133, 23);
		procedurePanel.add(addProcedure);
		
		deleteProcedure.setBounds(204, 507, 133, 23);
		procedurePanel.add(deleteProcedure);
		
		
		//Payment Tabbing
		JPanel paymentPanel = new JPanel();
		proceduresAndPayments.addTab("Payment", null, paymentPanel, null);
		paymentPanel.setLayout(null);
		
		listOfPatients.setBounds(40, 41, 297, 20);
		paymentPanel.add(listOfPatients);
		
		listOfProcedures.setBounds(50, 103, 261, 375);
		paymentPanel.add(listOfProcedures);
		
		pay.setBounds(50, 515, 89, 23);
		paymentPanel.add(pay);
		
		dontPay.setBounds(232, 515, 89, 23);
		paymentPanel.add(dontPay);
	}
	
	// Patient ActionListeners & Events
	public void addAddPatientListener(ActionListener listenForUpdate) {
		addPatient.addActionListener(listenForUpdate);
	}
	public void addRemovePatientListener(ActionListener listenForUpdate) {
		removePatient.addActionListener(listenForUpdate);
	}
	
	
	public String getName() {
		return textName.getText();
	}
	
	public String getAddress() {
		return textAddress.getText();
	}
	
	public String getContact() {
		return textContact.getText();
	}
	
	public JList getInfo() {
		return patientInfo;
	}
	public void setInfo(String number, String name, String address, String contact) {
		patientInfoModel.addElement(number + "  " + name + "  " + address + "  " + contact);
	}
	public void removeInfo() {
		
		if(patientInfo.getSelectedIndex() >= 0) {
			patientInfoModel.remove(patientInfo.getSelectedIndex());
		}
	}
	
	public void clearData() {
		
		textName.setText(null);
		textAddress.setText(null);
		textContact.setText(null);
	}
	
	
	// Procedure ActionListeners & Events
	public void addNewProcedureListener(ActionListener listenForUpdate) {
		addProcedure.addActionListener(listenForUpdate);
	}
	public void addRemoveProcedureListener(ActionListener listenForUpdate) {
		deleteProcedure.addActionListener(listenForUpdate);
	}
	
	
	public JComboBox setPatientsInComboBox() {
		return patientList;
	}
	public void addPatientsToComboBox(String name, String address) {
		patientListModel.addElement(name + ", " + address);
	}
	public void removePatientFromComboBox() {
		patientListModel.removeElementAt(patientInfo.getSelectedIndex());
	}
	
	
	public JList getProcedures() {
		return procedureList;
	}
	public void setProcedures(String name, String cost) {
		procedureListModel.addElement(name + "  " + cost);
	}
	public void removeProcedure() {
		
		if(procedureList.getSelectedIndex() >= 0) {
			procedureListModel.remove(procedureList.getSelectedIndex());
		}
	}
	
	
	// Payment ActionListeners & Events
	public void addSetProcedureListener(ActionListener listenForUpdate) {
		setProcedure.addActionListener(listenForUpdate);
	}
	
	
	public JComboBox getPatientListInComboBox() {
		return listOfPatients;
	}
	public void addPatientListToComboBox(String name, String address) {
		listOfPatientsModel.addElement(name + ", " + address);
	}
	public void removePatientListFromComboBox() {
		listOfPatientsModel.removeElementAt(patientInfo.getSelectedIndex());
	}
	
	
	public JTextArea getProcedureToPatient() {
		return listOfProcedures;
	}
	public void addProcedureToPatient(List procedures2) {
		
		for(int x = listOfPatients.getSelectedIndex(); x <= listOfPatients.getSelectedIndex(); x++) {
			
			System.out.println(listOfPatients.getItemAt(x));
			
			for(int i = 0; i < procedures2.size(); i++) {
				
				System.out.println(procedures2.get(i));
			}
		}
	}
	
	
	// Saving & Loading
	public void addSaveListener(ActionListener listenForUpdate) {
		
	}
	public void addLoadListener(ActionListener listenForupdate) {
		
	}
}
