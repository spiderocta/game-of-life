package dev.spiderocta.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = -9131201032069511737L;

	// size of a single cell in the grid
	private final static int CELLSIZE = 50;

	// main colors
	private final static Color BACKGROUND_COLOR = Color.BLACK;
	private final static Color FOREROUND_COLOR = Color.GREEN;
	private final static Color GRID_COLOR = Color.GRAY;

	// margins
	private int topBottomMargin;
	private int leftRightMargin;

	public GamePanel() {
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		int width = getWidth();
		int height = getHeight();

		topBottomMargin = ((height % CELLSIZE) + CELLSIZE) / 2;
		leftRightMargin = ((width % CELLSIZE) + CELLSIZE) / 2;

		g2d.setColor(BACKGROUND_COLOR);
		super.paintComponent(g2d);
		g2d.fillRect(0, 0, width, height);

		drawGrid(g2d, width, height);
		fillCell(g2d, 2, 4, true);
		fillCell(g2d, 2, 4, false);
		fillCell(g2d, 3, 5, true);
	}

	// method to draw the grid
	private void drawGrid(Graphics g, int width, int height) {
		g.setColor(GRID_COLOR);

		// drawing the horizontal lines (X axis )
		for (int x = leftRightMargin; x <= width - leftRightMargin; x += CELLSIZE) {
			g.drawLine(x, topBottomMargin, x, height - topBottomMargin);
		}

		// drawing the crossing vertical lines (Y axis )
		for (int y = topBottomMargin; y <= width - topBottomMargin; y += CELLSIZE) {
			g.drawLine(leftRightMargin, y, width - leftRightMargin, y);
		}

	}
	
	// method to fill cells
	private void fillCell(Graphics2D g, int row, int col, boolean status) {
		Color color = status ? FOREROUND_COLOR : BACKGROUND_COLOR;
		g.setColor(color);
		
		int x = leftRightMargin + col * CELLSIZE;
		int y = topBottomMargin + row * CELLSIZE;
		
		g.fillRect(x + 2, y + 2, CELLSIZE - 2, CELLSIZE - 2);
	}
	
	
}
