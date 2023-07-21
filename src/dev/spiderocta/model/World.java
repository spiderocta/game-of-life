package dev.spiderocta.model;

import java.util.Random;

public class World {
	private int rows;
	private int cols;
	private boolean[][] grid;
	private boolean[][] buffer;

	public World(int rows, int cols) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.grid = new boolean[rows][cols];
		this.buffer = new boolean[rows][cols];
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

	public void clear() {
		for(int row =0; row < rows; row++) {
			for(int col =0; col < cols; col++) {
				setCell(row, col, false);
			}
		}
	}
	
	// utility function to count neighbors
	private int countNeighbors(int row, int col) {
		
		int neighbors = 0;
		
		for(int rowOffset = -1; rowOffset <=1; rowOffset++) {
			for(int colOffset = -1; colOffset <=1; colOffset++) {
				
				if(rowOffset ==0 || colOffset ==0) {
					continue;
				}
				
				int gridRow = row + rowOffset;
				int gridCol = col  + colOffset;
				
				if(gridRow < 0) {
					continue;
				}
				else if(gridRow == rows) {
					continue;
				}
				
				if(gridCol <0) {
					continue;
				}
				else if(gridCol ==cols) {
					continue;
				}
				
				// check if cell is active or not
				boolean status =  getCell(gridRow, gridCol);
				
				if(status) {
					neighbors++;
				}
			}
		}
		
		return neighbors;
	}
	
	public void next() {
		for(int row =0; row < rows; row++) {
			for(int col =0; col < cols; col++) {
				int neighbors = countNeighbors(row, col);
				
				/* Conway's Rules
				 * if neighboring cell count < 2, deactivate cells
				 * if neighboring cell count > 3, deactivate cells
				 * if neighboring cell count == 3, activate cells
				 * if neighboring cell count == 2, let her alone 
				 */
				
				boolean status = false;
				
				if(neighbors < 2) {
					status = false;
				}
				else if(neighbors > 3) {
					status = false;
				}
				else if(neighbors == 3) {
					status = true;
				}
				else if(neighbors == 2) {
					status = getCell(row, col);
				}
				
				buffer[row][col] = status;
				
			}
		}
		
		for(int row =0; row < rows; row++) {
			for(int col =0; col < cols; col++) {
				grid[row][col] = buffer[row][col];
			}	
		}
	}

}
