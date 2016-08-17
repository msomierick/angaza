package com.katikilabs.angaza.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sound.midi.Patch;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.border.Border;

import com.katikilabs.angaza.model.Delegate;
import com.katikilabs.angaza.model.DelegateDAO;
import com.katikilabs.angaza.model.Giving;
import com.katikilabs.angaza.model.GivingDAO;
import com.katikilabs.angaza.model.Partner;
import com.katikilabs.angaza.model.PartnerDAO;

public class AddGivingPanel extends JPanel {

	private JTextField amountField;
	private JTextField dateField;
	private JComboBox delegateCombo;
	private JComboBox partnerCombo;
	private JLabel errorLabel;
	private JButton okButton;
	private DelegateDAO delDAO;
	private PartnerDAO patDAO;
	private GivingDAO givDAO;
	private JComboBox monthsCombo;
	private JSpinner spinner;
	private SpinnerListModel listModel;
	private SpinnerDateModel dateModel;

	public AddGivingPanel() throws SQLException {

		amountField = new JTextField(15);
		dateField = new JTextField(8);
		delegateCombo = new JComboBox();
		partnerCombo = new JComboBox();
		errorLabel = new JLabel();
		okButton = new JButton("Ok");
		monthsCombo = new JComboBox();
		listModel = new SpinnerListModel(Months.values());
		dateModel = new SpinnerDateModel(new Date(), null, null,
				Calendar.DAY_OF_MONTH);
		spinner = new JSpinner(dateModel);

		delDAO = new DelegateDAO();
		patDAO = new PartnerDAO();
		givDAO = new GivingDAO();

		errorLabel.setForeground(Color.RED);
		delegateCombo.setPreferredSize(amountField.getPreferredSize());
		partnerCombo.setPreferredSize(amountField.getPreferredSize());
		spinner.setPreferredSize(amountField.getPreferredSize());
		monthsCombo.setPreferredSize(amountField.getPreferredSize());

		dateField.setToolTipText("Format: Eg Feb 21, 2015");
		dateField.setText("");

		DefaultComboBoxModel delegateComboModel = new DefaultComboBoxModel();
		DefaultComboBoxModel partnersComboModel = new DefaultComboBoxModel();
		DefaultComboBoxModel monthsComboModel = new DefaultComboBoxModel();

		for (String name : getDelegateNamesList()) {
			delegateComboModel.addElement(name);
		}
		for (String patName : getPartnersNamesList(delegateCombo.getSelectedIndex()+1)) {
			partnersComboModel.addElement(patName);
		}
		for (Months month : Months.values()) {
			monthsComboModel.addElement(month);
		}

		delegateCombo.setModel(delegateComboModel);
		partnerCombo.setModel(partnersComboModel);
		monthsCombo.setModel(monthsComboModel);

		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (amountField.getText().equals("")
						|| dateField.getText().equals("")) {
					errorLabel.setText("Kindly enter all required data.");

				} else if (!(dateField.getText()
						.matches("\\d{1,2}/\\d{1,2}/\\d{4}"))) {
					JOptionPane
							.showMessageDialog(null,
									"Accepted date format is DD/MM/YYYY\n eg 07/02/2015");
				} else {
					int amount = Integer.parseInt(amountField.getText());
					try {
						givDAO.addGiving(new Giving(partnerCombo
								.getSelectedIndex() + 1, delegateCombo
								.getSelectedIndex() + 1, amount, dateField
								.getText()));
						JOptionPane.showMessageDialog(null,
								"Data entered successfully");
						amountField.setText("");
						dateField.setText("");
						errorLabel.setText("");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Border innerBorder = BorderFactory.createTitledBorder("Enter Details");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

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
		add(new JLabel("Support For: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(delegateCombo, gc);

		// ///////next Row/////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("From: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(partnerCombo, gc);

		// ///////next Row/////////////////
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(new JLabel("Amount: "), gc);

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
		add(new JLabel("Date: "), gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		// add(monthsCombo, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(dateField, gc);

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

	public List<String> getDelegateNamesList() throws SQLException {
		List<String> delegateNamesList = new ArrayList<String>();
		for (Delegate delegate : delDAO.getDelegates()) {
			delegateNamesList.add(String.format("%s %s",
					delegate.getFirstName(), delegate.getSecondName()));
		}
		return delegateNamesList;
	}

	public List<String> getPartnersNamesList(int id) throws SQLException {
		List<String> partnerNamesList = new ArrayList<String>();
		for (Partner partner : patDAO.getPartnerPerDelegate(id)) {
			partnerNamesList.add(String.format("%s %s", partner.getFirstName(),
					partner.getSecondName()));
		}
		return partnerNamesList;
	}

	public enum Months {
		January, February, March, April, May, June, July, August, October, November, December
	}
}
