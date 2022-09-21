package anotherspaceshooter.net.maxulysse.main.view;

import java.awt.Dimension;

import javax.swing.JFrame;

import anotherspaceshooter.net.maxulysse.main.model.ShipSprite;

public class GameWindow extends JFrame {
	
	private Dimension size;
	
	public GameWindow(Dimension size) {
		this.size = size;
		this.setTitle("Another Space Shooter");
		this.setSize(size);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	
}
