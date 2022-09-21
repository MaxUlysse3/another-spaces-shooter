package anotherspaceshooter.net.maxulysse.main.observer;

import java.util.ArrayList;

public interface Observable {
	
	public  void notifyObservers();
	
	
	public void addObserver(Observer obs);
	
	public void removeObserver(Observer obs);
	
	
}
