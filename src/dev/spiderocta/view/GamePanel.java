package dev.spiderocta.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = -9131201032069511737L;

	public GamePanel() {}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		int width = getWidth();
		int heigh = getHeight();
		
		g2d.setColor(Color.GREEN);
		super.paintComponent(g2d);
		g2d.fillRect(0, 0, width, heigh);
	}
	
	
}
