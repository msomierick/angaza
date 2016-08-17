package com.katikilabs.angaza.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddDelegatePanel extends JPanel {

	private JTextField fnameField;
	private JTextField snameField;
	private JTextField houseField;
	private JButton okButton;
	
	public AddDelegatePanel(){
		fnameField = new JTextField(10);
		snameField = new JTextField(10);
		houseField = new JTextField(10);
		
		okButton = new  JButton("Ok");
		
	}
}
