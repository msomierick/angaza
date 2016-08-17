package com.katikilabs.angaza.main;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.katikilabs.angaza.view.LoginFrame;
import com.katikilabs.angaza.view.MainView;

public class Angaza {

	static Statement stmt= null;
	
	public static void main(String[] args) throws SQLException{
		
		new LoginFrame();
		setUIManager();
	}
	
	public static void setUIManager(){
		new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	}

}
