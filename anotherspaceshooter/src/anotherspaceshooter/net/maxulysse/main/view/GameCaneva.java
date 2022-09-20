package anotherspaceshooter.net.maxulysse.main.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameCaneva extends JPanel {
	private int width;
	private int height;
	
	public GameCaneva(Dimension dimensions) {
		this.width = (int)dimensions.getWidth();
		this.height = (int)dimensions.getHeight();
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
		try {
			g.drawImage(ImageIO.read(new File("textures/ship.png")), 50,50,null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
