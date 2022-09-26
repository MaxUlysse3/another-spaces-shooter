package anotherspaceshooter.net.maxulysse.main.view;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.function.BiConsumer;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	private Dimension size;
	BiConsumer<Boolean, KeyEvent> keyCallback;
	KeyEventListener listener;
	private LinkedHashSet<Integer> pressedKeys;
	
	
	public GameWindow(Dimension size/*, BiConsumer<Boolean, KeyEvent> keyCallback*/) {
		
		this.pressedKeys = new LinkedHashSet<Integer>();
		this.listener = new KeyEventListener();
		this.addKeyListener(listener);
		
		
		this.size = size;
		this.setTitle("Another Space Shooter");
		this.setSize(this.size);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	}
	
	public LinkedHashSet<Integer> getPressedKeys() {
		return this.pressedKeys;
	}
	
	private class KeyEventListener implements KeyListener {
		
		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {
			pressedKeys.add(e.getKeyCode());
			
			//keyCallback.accept(true, e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			pressedKeys.remove(e.getKeyCode());
			
			//keyCallback.accept(false, e);
			
		}
		
	}
	
	
	
	
}
