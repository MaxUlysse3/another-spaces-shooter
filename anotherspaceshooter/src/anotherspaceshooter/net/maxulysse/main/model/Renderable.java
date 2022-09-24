package anotherspaceshooter.net.maxulysse.main.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import anotherspaceshooter.net.maxulysse.main.observer.Observable;
import anotherspaceshooter.net.maxulysse.main.observer.Observer;

public abstract class Renderable implements Observable {
	
	protected int sizeX;
	protected int sizeY;
	
	protected int posX;
	protected int posY;
	protected String location;
	protected ArrayList<Observer> obsList = new ArrayList<Observer>();
	
	public Renderable(String path) {
		this.location = path;
		
		try {
			this.sizeX = ImageIO.read(new File(this.location)).getWidth();
			this.sizeY = ImageIO.read(new File(this.location)).getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public int getSizeX() {
		return this.sizeX;
	}
	
	public int getSizeY() {
		return this.sizeY;
	}
	@Override
	public void notifyObservers() {
		for (Observer obs : this.obsList) {
			obs.update(this);
		}
		//System.out.println("Depuis Renderable");
	}

	@Override
	public void addObserver(Observer obs) {
		this.obsList.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		this.obsList.remove(obsList.indexOf(obs));
		
	}
}
