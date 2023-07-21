package dev.spiderocta.model;

import java.util.Random;

public class World {
	private int rows;
	private int cols;
	private boolean[][] grid;

	public World(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.grid = new boolean[rows][cols];
	}

	public boolean getCell(int row, int col) {
		return grid[row][col];
	}

	public void setCell(int row, int col, boolean status) {
		grid[row][col] = status;
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public void randomize() {
		Random random = new Random();

		for (int i = 0; i < (rows * cols) / 10; i++) {
			int row = random.nextInt(rows);
			int col = random.nextInt(cols);
			setCell(row, col, true);
		}
	}

}
