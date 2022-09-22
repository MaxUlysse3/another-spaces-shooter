package anotherspaceshooter.net.maxulysse.main.controller;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import anotherspaceshooter.net.maxulysse.main.model.ShipSprite;
import anotherspaceshooter.net.maxulysse.main.view.GameCaneva;
import anotherspaceshooter.net.maxulysse.main.view.GameWindow;

public class GameController {
	private ShipSprite ship;
	private GameWindow window;
	private GameCaneva caneva;
	private Dimension windowSize;
	private boolean gameOn;
	
	public GameController() {
		this.windowSize = new Dimension(800, 500);
		this.window = new GameWindow(this.windowSize, this::keyListener);
		this.gameOn = false;
		this.reStart();
		
	}
	
	public void reStart() {
		this.caneva = new GameCaneva(this.windowSize,null);
		this.window.setContentPane(caneva);
		this.ship = new ShipSprite(400, 400,"textures/ship.png");
		this.caneva.addToRender(ship);
		this.loop();
		
		
	}
	
	public void loop() {
		this.gameOn = true;
		while (gameOn) {
			this.ship.move();
			
			try {
				Thread.sleep(10);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	public void keyListener(boolean isPressed, KeyEvent e) {
		
		//Verifs sur ship.velocity pour annuler si deux fleches appuyees
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.ship.setVelocity(this.ship.getVelocityX() + (isPressed ? 1 : 0), 0);
		} 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			this.ship.setVelocity(this.ship.getVelocityX() + (isPressed ? -1 : 0), 0);
		}
		
	}
}
