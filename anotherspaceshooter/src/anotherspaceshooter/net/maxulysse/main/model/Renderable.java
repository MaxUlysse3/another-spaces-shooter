package anotherspaceshooter.net.maxulysse.main.model;

import java.util.ArrayList;

import anotherspaceshooter.net.maxulysse.main.observer.Observable;
import anotherspaceshooter.net.maxulysse.main.observer.Observer;

public abstract class Renderable implements Observable {
	protected int posX;
	protected int posY;
	protected String location;
	protected ArrayList<Observer> obsList = new ArrayList<Observer>();
	
	
	public int getPosX() {
		return this.posX;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public String getLocation() {
		return this.location;
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
