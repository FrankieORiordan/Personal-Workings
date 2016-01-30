package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFrame;

import views.Project;

public class SavingAndLoading {

	private Project projectView;
	private ComponentSerializer serial;
	
	public SavingAndLoading(Project projectView, ComponentSerializer serial) {
		
		this.projectView = projectView;
		this.serial = serial;
		
		this.projectView.addSaveListener(new SaveListener());
		//this.projectView.addLoadListener(new LoadListener());
	}
	
	
	public class SaveListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			OutputStream output;
			
			try {
				
				output = new FileOutputStream("Dentist.bin");
				ComponentSerializer serializer = new ComponentSerializer();
				
				serializer.write(projectView.frame, output);
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	/*public class LoadListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			try {
				InputStream in = new FileInputStream("Dentist.bin");
				
				ComponentSerializer serializer = new ComponentSerializer();
				serializer.read(in);
				
				JFrame myFrame = (JFrame) serializer.read(in);
				myFrame.setVisible(true);
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}*/
}
