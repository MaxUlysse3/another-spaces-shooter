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

	public int speed;
	public int shootSpeed;
	

	public ShipSprite(int posX, int posY, String path) {
		super(path);
		this.speed = 2;
		this.shootSpeed = 200;
		this.obsList = new ArrayList<Observer>();
		
		this.location = path;
		
		
		this.posX = posX;
		this.posY = posY;
		
		
	}
	
	public void move(int x, int y) {
		this.posX += x;
		this.posY += y;
		this.notifyObservers();
	}
	
	
	
}
