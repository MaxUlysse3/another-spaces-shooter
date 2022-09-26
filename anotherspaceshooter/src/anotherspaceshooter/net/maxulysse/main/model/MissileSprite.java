package anotherspaceshooter.net.maxulysse.main.model;

public class MissileSprite extends Renderable {
	
	private int speed;
	public MissileSprite(String path, int posX, int posY) {
		super(path);
		this.sizeX = 20;
		this.sizeY = 20;
		this.speed = 4;
		
		this.posX = posX;
		this.posY = posY;
	}
	
	public void move() {
		this.posY -= this.speed;
		this.notifyObservers();
	}
	
}
