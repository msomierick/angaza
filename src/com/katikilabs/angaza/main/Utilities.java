package com.katikilabs.angaza.main;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Utilities {

	public Utilities() {

	}

	public static ImageIcon createIcon(String path) {
		URL url = Utilities.class.getClass().getResource(path);

		if (url == null) {
			System.out.println("Unable to load resource:" + path);
		}
		ImageIcon icon = new ImageIcon(url);
		return icon;
	}
}
