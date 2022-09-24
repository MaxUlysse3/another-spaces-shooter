package anotherspaceshooter.net.maxulysse.main.model;

public class MissileSprite extends Renderable {
	
	private int speed;
	// /!\ missile not rendering !!
	public MissileSprite(String path, int posX, int posY) {
		super(path);
		this.sizeX = 10;
		this.sizeY = 10;
		this.speed = 4;
		
		this.posX = posX;
		this.posY = posY;
	}
	
}
