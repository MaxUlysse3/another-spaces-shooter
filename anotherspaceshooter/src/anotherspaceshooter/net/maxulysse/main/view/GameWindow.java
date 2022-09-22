package anotherspaceshooter.net.maxulysse.main.view;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
	
	private Dimension size;
	BiConsumer<Boolean, KeyEvent> keyCallback;
	KeyEventListener listener;
	
	
	public GameWindow(Dimension size, BiConsumer<Boolean, KeyEvent> keyCallback) {
		this.keyCallback = keyCallback;
		this.listener = new KeyEventListener();
		this.addKeyListener(listener);
		
		
		this.size = size;
		this.setTitle("Another Space Shooter");
		this.setSize(size);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	private class KeyEventListener implements KeyListener {
		
		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyPressed(KeyEvent e) {
			keyCallback.accept(true, e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			keyCallback.accept(false, e);
			
		}
		
	}
	
	
	
	
}
