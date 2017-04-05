package edu.ilstu.it275.assignment7.ejzumba;

import java.awt.Color;
import java.util.Random;

public class Organism {
	private int xGrid;
	private int yGrid;
	private int oldX;
	private int oldY;
	private Random rand;
	

	public Organism() {
		rand = new Random();
		xGrid = rand.nextInt(20);
		yGrid = rand.nextInt(20);
		oldX= xGrid;
		oldY= yGrid;
		
		
	}
	
	public Organism(int x, int y, int gameRound) {
		rand = new Random();
		xGrid = x;
		yGrid = y;
		oldX= xGrid;
		oldY= yGrid;

	}

	public int[] panelLocation() {
		int retVal[] = new int[2];
		retVal[0] = (xGrid * 20);
		retVal[1] = (yGrid * 20);

		return retVal;
	}
	
	public Color color(){
		Color retVal= new Color (255, 255, 255);
		
		return retVal;
	}

	public void move(Organism[][] orgGrid) {
		int x = rand.nextInt(1000) % 4;
		oldX= xGrid;
		oldY= yGrid;
		
		if (x == 0) {
			if (xGrid == 0) {
				if(orgGrid[yGrid][xGrid+ 1]== null){
					xGrid += 1;
					
				}//else{ x=1;}
			} else {
				if(orgGrid[yGrid][xGrid- 1]== null){
					xGrid -= 1;
				}
			}
		} else if (x == 1) {
			if (xGrid == 19) {
				if(orgGrid[yGrid][xGrid- 1]== null){
					xGrid -= 1;
				}
			} else {
				if(orgGrid[yGrid][xGrid+ 1]== null){
					xGrid += 1;
				}
			}
		} else if (x == 2) {
			if (yGrid == 0) {
				if(orgGrid[yGrid+ 1][xGrid]== null){
					yGrid += 1;
				}
			} else {
				if(orgGrid[yGrid- 1][xGrid]== null){
					yGrid -= 1;
				}
			}
		} else if (x == 3) {
			if (yGrid == 19) {
				if (orgGrid[yGrid- 1][xGrid]== null){
					yGrid -= 1;
				}
			} else {
				if(orgGrid[yGrid+ 1][xGrid]== null){
					yGrid += 1;
				}
			}
		}
		orgGrid[yGrid][xGrid]= this;
		orgGrid[oldY][oldX]= null;
		
		
	}
	
	public void reAdjustPosition(Organism[][] orgGrid){
		this.move(orgGrid);
		
	}

	public void breed(Organism[][] orgGrid) {
		
	}

	/**
	 * @return the xGrid
	 */
	public int getxGrid() {
		return xGrid;
	}

	/**
	 * @return the yGrid
	 */
	public int getyGrid() {
		return yGrid;
	}

	/**
	 * @param xGrid the xGrid to set
	 */
	public void setxGrid(int xGrid) {
		this.xGrid = xGrid;
	}

	/**
	 * @param yGrid the yGrid to set
	 */
	public void setyGrid(int yGrid) {
		this.yGrid = yGrid;
	}

	public String typeOrganism() {
		String retVal = "Organism";

		return retVal;
	}
	
	

}
