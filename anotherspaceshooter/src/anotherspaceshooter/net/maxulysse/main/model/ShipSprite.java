package anotherspaceshooter.net.maxulysse.main.model;

import java.util.ArrayList;

import anotherspaceshooter.net.maxulysse.main.observer.Observable;
import anotherspaceshooter.net.maxulysse.main.observer.Observer;

public class ShipSprite extends Renderable implements Observable {
	
	public ShipSprite(int posX, int posY) {
		this.obsList = new ArrayList<Observer>();
		
		this.location = "textures/ship.png";
		
		this.posX = posX;
		this.posY = posY;
	}
	
	public void move(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.notifyObservers();
	}



	
}
