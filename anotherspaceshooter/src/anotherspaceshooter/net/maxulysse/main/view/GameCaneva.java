package anotherspaceshooter.net.maxulysse.main.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import anotherspaceshooter.net.maxulysse.main.model.Renderable;
import anotherspaceshooter.net.maxulysse.main.model.ShipSprite;
import anotherspaceshooter.net.maxulysse.main.observer.Observable;
import anotherspaceshooter.net.maxulysse.main.observer.Observer;

public class GameCaneva extends JPanel implements Observer {
	private int width;
	private int height;
	private ArrayList<Renderable> toRender;
	
	public GameCaneva(Dimension dimensions, ShipSprite ship) {
		this.toRender = new ArrayList<Renderable>();
		this.width = (int)dimensions.getWidth();
		this.height = (int)dimensions.getHeight();
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, this.width, this.height);
		this.paintToRender(g);
	}
	
	public void paintToRender(Graphics g) {
		try {
			for (Renderable r : this.toRender) {
				BufferedImage image = ImageIO.read(new File(r.getLocation()));
				g.drawImage(image, r.getPosX(), r.getPosY(), null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addToRender(Renderable sprite) {
		this.toRender.add(sprite);
		sprite.addObserver(this);
		this.repaint();
	}
	
	public void removeToRender(Renderable sprite) {
		if (this.toRender.contains(sprite)) {
			sprite.removeObserver(this);
			this.toRender.remove(this.toRender.indexOf(sprite));
			this.repaint();
		}
		
		
		
	}
	
	public void update(Observable obs) {
		this.repaint();
	}
	
	
	
	
}
