package anotherspaceshooter.net.maxulysse.main.controller;

import java.awt.Dimension;

import anotherspaceshooter.net.maxulysse.main.model.ShipSprite;
import anotherspaceshooter.net.maxulysse.main.view.GameCaneva;
import anotherspaceshooter.net.maxulysse.main.view.GameWindow;

public class GameController {
	private ShipSprite ship;
	private GameWindow window;
	private GameCaneva caneva;
	private Dimension windowSize;
	
	public GameController() {
		this.windowSize = new Dimension(800, 500);
		this.window = new GameWindow(this.windowSize);
		this.reStart();
		
	}
	
	public void reStart() {
		this.caneva = new GameCaneva(this.windowSize,null);
		this.window.setContentPane(caneva);
		this.ship = new ShipSprite(0, 0);
		this.caneva.addToRender(ship);
		for (int i=0;i<300;i++) {
			this.ship.move(this.ship.getPosX()+1, this.ship.getPosY()+1);
			try {
				Thread.sleep(20);
				System.out.println(i);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
