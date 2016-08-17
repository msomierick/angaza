package com.katikilabs.angaza.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JFrame;

import com.katikilabs.angaza.model.DelegateDAO;

public class LoginFrame extends JFrame {

	private LoginPanel loginPanel;
	private DelegateDAO delegateDAO;
	public LoginFrame() throws SQLException{
		super("Angaza");
		loginPanel = new LoginPanel();
		delegateDAO = new DelegateDAO();
		
		add(loginPanel, BorderLayout.CENTER);
		setVisible(true);
		setMinimumSize(new Dimension(450, 200));
		setSize(480, 350);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//loginPanel.close(this);
	}
}
