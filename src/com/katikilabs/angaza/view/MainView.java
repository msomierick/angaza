package com.katikilabs.angaza.view;

import javax.swing.JMenuBar;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

public class MainView extends JFrame {

	private TablePanel tablePanel;
	private AddParterPanel addPartnerPanel;
	private AddGivingPanel addGivingPanel;
	private JTabbedPane tabbedPane;
	public MainView() throws SQLException{
		super("Angaza");
		
		tablePanel = new TablePanel();
		addPartnerPanel = new AddParterPanel();
		addGivingPanel = new AddGivingPanel();
		tabbedPane = new JTabbedPane();
		
		tabbedPane.add("View Partners", tablePanel);
		tabbedPane.add("Add Partner", addPartnerPanel);
		tabbedPane.add("Add Giving", addGivingPanel);

		
		add(tabbedPane, BorderLayout.CENTER);
		//add(tablePanel, BorderLayout.SOUTH);
		//add(addPartnerPanel, BorderLayout.CENTER);
		//add(addGivingPanel, BorderLayout.CENTER);
		
		setJMenuBar(createMenuBar());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setSize(700, 500);
		
		addPartnerPanel.setAddPartnerFormListener(new AddPartnerEventListener() {
			
			@Override
			public void addPartnerEventocurred(AddPartnerFormEvent event) {
				
				
			}
		});
			
	}
	
	public JMenuBar createMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu aboutMenu  = new JMenu("About");
		
		JMenuItem partnerItem = new JMenuItem("Add New Partner");
		JMenuItem delegateItem = new JMenuItem("Add new Delegate");
		
		fileMenu.add(partnerItem);
		fileMenu.add(delegateItem);
		
		JMenuItem helpItem = new JMenuItem("Help Contents..");
		JMenuItem aboutItem = new JMenuItem(" About");

		aboutMenu.add(helpItem);
		aboutMenu.add(aboutItem);
		
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		return menuBar ;
	}
}
