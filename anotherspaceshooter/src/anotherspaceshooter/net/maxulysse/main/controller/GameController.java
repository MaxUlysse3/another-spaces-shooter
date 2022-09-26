package anotherspaceshooter.net.maxulysse.main.controller;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

import anotherspaceshooter.net.maxulysse.main.model.MissileSprite;
import anotherspaceshooter.net.maxulysse.main.model.ShipSprite;
import anotherspaceshooter.net.maxulysse.main.view.GameCaneva;
import anotherspaceshooter.net.maxulysse.main.view.GameWindow;

public class GameController {
	private ShipSprite ship;
	private GameWindow window;
	private GameCaneva caneva;
	private Dimension windowSize;
	private LinkedList<MissileSprite> missiles;
	private boolean gameOn;
	
	public GameController() {
		this.windowSize = new Dimension(800, 500);
		this.window = new GameWindow(this.windowSize/*, this::keyListener*/);
		this.gameOn = false;
		this.reStart();
		
	}
	
	public void reStart() {
		this.caneva = new GameCaneva(this.windowSize,null);
		this.window.setContentPane(caneva);
		
		this.ship = new ShipSprite(400, 400,"textures/ship.png");
		this.missiles = new LinkedList<>();
		
		this.addRendered();
		this.loop();
		
		
	}
	
	public void addRendered() {
		this.caneva.addToRender(ship);
	}
	
	public void loop() {
		this.gameOn = true;
		Timer timer = new Timer();
		while (gameOn) {
			this.moveAll();
			this.shootAll(timer);
			
			
			timer.addToAll();
			
			try {
				Thread.sleep(5);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	public void shootAll(Timer timer) {
		this.shootShip(timer);
	}
	
	public void moveAll() {
		this.moveShip();
		this.moveMissiles();
	}
	
	public void shootShip(Timer timer) {
		System.out.println(timer.counters);
		if (timer.counters.get(Timer.SHOOT) >= 200) {
			timer.counters.set(Timer.SHOOT, 0);
			
			MissileSprite missile = new MissileSprite("textures/missile.png",this.ship.getPosX(), this.ship.getPosY());
			this.missiles.add(missile);
			this.caneva.addToRender(missile);
		}
	}
	
	public void moveShip() {
		int distance = 0;
		for(int i : this.window.getPressedKeys()) {
			if (i == KeyEvent.VK_RIGHT) {
				distance += this.ship.speed;
			}
			if (i == KeyEvent.VK_LEFT) {
				distance += -this.ship.speed;
			}
		}
		this.ship.move(distance, 0);

	}
	
	public void moveMissiles() {
		for (MissileSprite m : this.missiles) {
			m.move();
			if(m.getPosY() >= this.window.getHeight()) {
				this.caneva.removeToRender(m);
			}
		}
	}
	
	public class Timer {
		public static final int SHOOT = 0;
		
		public ArrayList<Integer> counters;
		
		public Timer() {
			this.counters = new ArrayList<>();
			this.counters.add(0);
		}
		
		public void addToAll() {
			for (int i=0;i<this.counters.size();i++) {
				this.counters.set(i, this.counters.get(i) + 1);
			}
		}
	}
		
}
