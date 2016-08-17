package com.katikilabs.angaza.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.katikilabs.angaza.main.Utilities;
import com.katikilabs.angaza.model.Delegate;
import com.katikilabs.angaza.model.DelegateDAO;

public class LoginPanel extends JPanel {

	private JLabel iconLabel;
	private JPasswordField passField;
	private JTextField usernameField;
	private JButton cancelButton;
	private JButton loginButton;

	private LoginListener loginListener;
	private Connection con = null;
	ResultSet rs = null;

	public LoginPanel() throws SQLException {

		passField = new javax.swing.JPasswordField(15);
		usernameField = new javax.swing.JTextField(15);

		cancelButton = new javax.swing.JButton("Cancel.");

		loginButton = new javax.swing.JButton("Login.");

		usernameField.setToolTipText("Please enter your Username.");
		usernameField.setFont(new Font("Serif", Font.PLAIN, 15));

		passField.setEchoChar('*');
		passField.setToolTipText("Please enter your Password.");
		
		this.setBackground(Color.WHITE);

		layoutComponents();

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String password = new String(passField.getPassword());
				String name = usernameField.getText();

				fireLoginEvent(new LoginFormEvent(name, password));
				try {
					validateUser();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		});

		cancelButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	public JPasswordField getPassField() {
		return passField;
	}

	public JTextField getUsernameField() {
		return usernameField;
	}

	public void layoutComponents() {

		JPanel controlsPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JPanel topPanel = new JPanel();

		// //////////////////borders for the three panels///////////////
		int space = 17;
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space,
				space, space);
		Border lineBorder = BorderFactory.createLineBorder(new Color(232, 148,
				240), 2, true);
		Border titledBorder = BorderFactory.createTitledBorder(lineBorder,
				"Login");
		controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder,
				titledBorder));

		Border spaceInnerBorder = BorderFactory.createEmptyBorder(space, space,
				space, 0);
		Border spaceOuterBorder = BorderFactory.createEmptyBorder();

		// /////////////////borders settings
		// end///////////////////////////////////

		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 13, 10));

		controlsPanel.setBackground(Color.WHITE);
		controlsPanel.setLayout(new GridBagLayout());
		//controlsPanel.setBackground(new Color(255, 204, 204));

		GridBagConstraints gc = new GridBagConstraints();
		Insets rightPadding = new Insets(0, 0, 0, 5);
		Insets noPadding = new Insets(0, 0, 0, 0);

		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.insets = rightPadding;
		gc.anchor = GridBagConstraints.EAST;
		controlsPanel.add(new JLabel("Username: "), gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(usernameField, gc);

		// ///////////////Next Row//////////////
		gc.gridx = 0;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = rightPadding;
		controlsPanel.add(new JLabel("Password: "), gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets = noPadding;
		controlsPanel.add(passField, gc);

		// ///////////////topPanel///////////////
		// topPanel.setBackground(new Color(232,148,240));
		JLabel bannerLabel = new JLabel(Utilities.createIcon("/resources/Angaza.png"));
		topPanel.add(bannerLabel);

		// ///////////////ButtonsPanel///////////////
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		buttonsPanel.add(loginButton);
		buttonsPanel.add(cancelButton);
		buttonsPanel.setBackground(Color.WHITE);

		Dimension btnSize = cancelButton.getPreferredSize();
		loginButton.setPreferredSize(btnSize);

		// /////////////iconPanel/////////////////
		iconLabel = new JLabel();

		// ////////////Add Panels to Frame///////////
		add(topPanel, BorderLayout.NORTH);
		add(controlsPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}

	public void setLoginListener(LoginListener loginListener) {
		this.loginListener = loginListener;
	}

	public void fireLoginEvent(LoginFormEvent event) {
		if (loginListener != null) {
			loginListener.loginPerformed(event);
		}
	}

	public void validateUser() throws SQLException {
		DelegateDAO delDAO = new DelegateDAO();
		Delegate delegate = delDAO.getUser(1);
		String username = delegate.getUsername();
		String password = delegate.getPassword();

		if (username.equals(usernameField.getText())
				&& password.equals(passField.getText())) {
			JOptionPane.showMessageDialog(null,
					"Username and Password Correct.\n \t Welcome");
			new MainView();
		} else {
			JOptionPane.showMessageDialog(null,
					"Username or Password not correct. \n \t Try Again");
			usernameField.setText(null);
			passField.setText(null);
		}
	}
	public void close(LoginFrame loginFrame) throws SQLException {
		WindowEvent winClosingEvent = new WindowEvent(loginFrame,
				WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue()
				.postEvent(winClosingEvent);
		
	}
}
