package anotherspaceshooter.net.maxulysse.main.view;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	private GameCaneva caneva;
	private Dimension size = new Dimension(800,600);
	
	public GameWindow() {
		this.caneva = new GameCaneva(size);
		
		this.setTitle("Another Space Shooter");
		this.setSize(size);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setContentPane(caneva);
		this.setVisible(true);
		
		
	}
	
}
