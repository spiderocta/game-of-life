package dev.spiderocta.model;

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

}
