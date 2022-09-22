package anotherspaceshooter.net.maxulysse.main.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import anotherspaceshooter.net.maxulysse.main.observer.Observable;
import anotherspaceshooter.net.maxulysse.main.observer.Observer;

public class ShipSprite extends Renderable implements Observable {

	
	private int velocityX;
	private int velocityY;
	
	public ShipSprite(int posX, int posY, String path) {
		super(path);
		this.velocityX = 0;
		this.velocityY = 0;
		this.obsList = new ArrayList<Observer>();
		
		this.location = path;
		
		
		this.posX = posX;
		this.posY = posY;
		
		
	}
	
	public void move() {
		this.posX += this.velocityX;
		this.posY += this.velocityY;
		this.notifyObservers();
	}
	
	public void setVelocity(int x, int y) {
		this.velocityX = x;
		this.velocityY = y;
	}
	
	public int getVelocityX() {
		return this.velocityX;
	}
	
	public int getVelocityY() {
		return this.velocityY;
	}
	
	public void accelerate(int accX, int accY) {
		this.velocityX += accX;
		this.velocityY += accY;
	}



	
}
