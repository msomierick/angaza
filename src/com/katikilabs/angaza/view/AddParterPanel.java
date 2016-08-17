package com.katikilabs.angaza.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.katikilabs.angaza.model.Delegate;
import com.katikilabs.angaza.model.DelegateDAO;
import com.katikilabs.angaza.model.Partner;
import com.katikilabs.angaza.model.PartnerDAO;

public class AddParterPanel extends JPanel {

	private JTextField fnameField;
	private JTextField snameField;
	private JComboBox pledgeCombo;
	private JTextField modeField;
	private JTextField amountField;
	private JComboBox delegateCombo;
	private JLabel errorLabel;
	private JButton okButton;

	private AddPartnerEventListener formListener;
	private PartnerDAO patDAO;
	private DelegateDAO delDAO;

	private String modearray[] = { "MONTHLY", "RANDOM", "ONCE", "BIMONTHLY",
			"QUARTERLY" };

	public AddParterPanel() throws SQLException {

		patDAO = new PartnerDAO();
		fnameField = new JTextField(15);
		snameField = new JTextField(15);
		pledgeCombo = new JComboBox();
		modeField = new JTextField(15);
		okButton = new JButton("OK");
		amountField = new JTextField(15);
		delegateCombo = new JComboBox();
		delDAO = new DelegateDAO();
		errorLabel = new JLabel();

		errorLabel.setForeground(Color.RED);
		DefaultComboBoxModel listModel = new DefaultComboBoxModel();

		for (String mode : modearray) {
			listModel.addElement(mode);
		}

		pledgeCombo.setModel(listModel);
		pledgeCombo.setEditable(false);
		pledgeCombo.setSelectedIndex(0);
		pledgeCombo.setPreferredSize(fnameField.getPreferredSize());

		DefaultComboBoxModel delegatesModel = new DefaultComboBoxModel();
		for (String name : getDelegateNamesList()) {
			delegatesModel.addElement(name);
		}

		delegateCombo.setModel(delegatesModel);
		delegateCombo.setEditable(false);
		delegateCombo.setSelectedIndex(0);
		delegateCombo.setPreferredSize(fnameField.getPreferredSize());

		Border innerBorder = BorderFactory
				.createTitledBorder("Enter Partner Details");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (fnameField.getText().equals("")
						|| snameField.getText().equals("") || amountField.getText().equals("")){
		errorLabel.setText("Kindly enter all required data.");	
					
				}else{
					
				int amount = Integer.parseInt(amountField.getText());
				try {
					patDAO.addPartner(new Partner(fnameField.getText(),
							snameField.getText(), amount, modeField.getText(),
							delegateCombo.getSelectedIndex() + 1));
					JOptionPane.showMessageDialog(null,
							"Data entered successfully");
					fnameField.setText(null);
					snameField.setText(null);
					modeField.setText(null);
					amountField.setText(null);
					errorLabel.setText(null);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}
			}
		});
		
		fnameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				errorLabel.setText(null);
			}
		});
		snameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				errorLabel.setText(null);
			}
		});
		amountField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				errorLabel.setText(null);
			}
		});
		layComponents();
	}

	public void layComponents() {
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("First Name: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(fnameField, gc);

		// ///////next Row/////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Second Name: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(snameField, gc);

		// ///////next Row/////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Pledge Amount: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(amountField, gc);

		// ///////next Row/////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Mode: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(pledgeCombo, gc);
		// ///////next Row/////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.2;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Partner For: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(delegateCombo, gc);

		// ///////Next Row/////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(errorLabel, gc);

		// ///////Next Row/////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(okButton, gc);
	}

	public void setAddPartnerFormListener(AddPartnerEventListener listener) {
		this.formListener = listener;
	}

	public List<String> getDelegateNamesList() throws SQLException {
		List<String> delegateNamesList = new ArrayList<String>();
		for (Delegate delegate : delDAO.getDelegates()) {
			delegateNamesList.add(String.format("%s %s",
					delegate.getFirstName(), delegate.getSecondName()));
		}
		return delegateNamesList;
	}

}
