package dev.spiderocta.view;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1729233823098776690L;
	private GamePanel gamePanel = new GamePanel();

	public MainFrame() {
		super("Conway's Game of Life");
		setLayout(new BorderLayout());
		add(gamePanel, BorderLayout.CENTER);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				
				switch(code) {
				case 32: //spacebar
					break;
				case 8: //backspace
					gamePanel.clear();
					break;
				case 10://enter
					gamePanel.randomize();
					break;
				}
			}
		});
		
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}