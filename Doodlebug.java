package edu.ilstu.it275.assignment7.ejzumba;

import java.awt.Color;

public class Doodlebug extends Organism {
	private int breedTime;
	private int steps;
	private int round;

	public Doodlebug() {
		super();
		breedTime= 0;
		steps= 0;
		round= 0;
	}
	
	public Doodlebug(int x, int y, int gameRound){
		super(x,y, gameRound);
		breedTime= 0;
		steps= 0;
		round= gameRound+1;
	}
	
	

	/* (non-Javadoc)
	 * @see edu.ilstu.it275.assignment7.ejzumba.Organism#color()
	 */
	@Override
	public Color color() {
		return Color.RED;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ilstu.it275.assignment7.ejzumba.Organism#breed()
	 */
	
	public void breed(Organism[][] orgGrid, int gameRound) {
		
		if(breedTime== 8){
			outerloop:							//found this on stack overflow
			for(int i= 0; i<20; i++){
				for(int j= 0; j<20; j++){
					if(orgGrid[i][j]== null){
						orgGrid[i][j]= new Doodlebug(j, i, gameRound);
						breedTime= 0;
						break outerloop;
					}
				}
				
			}
		}else{
			breedTime++;
		}
		round++;
		
		
	}
	
	public void starve(Organism[][] orgGrid){
		if(steps<= 3){
			orgGrid[this.getyGrid()][this.getxGrid()]= null;
			
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.ilstu.it275.assignment7.ejzumba.Organism#typeOrganism()
	 */
	@Override
	public String typeOrganism() {
		super.typeOrganism();
		return "Doodlebug";

	}

	/**
	 * @return the round
	 */
	public int getRound() {
		return round;
	}

	public boolean eatingCheckNull(Organism x) {
		return x != null;
	}

	public boolean eatRevised(Organism[][] orgGrid) {
		boolean retVal = false;
		if(this.getyGrid()-1 <0){
			
		}else if (eatingCheckNull(orgGrid[this.getyGrid() - 1][this.getxGrid()]) == true){
			 if(orgGrid[this.getyGrid() - 1][this.getxGrid()].typeOrganism().compareToIgnoreCase("Ant") == 0) {
				orgGrid[this.getyGrid() - 1][this.getxGrid()] = null;
				this.setyGrid(this.getyGrid() - 1);
				retVal = true;
				steps= 0;
			}
		} if(this.getyGrid()+1 >19){
			
			}else if (eatingCheckNull(orgGrid[this.getyGrid() + 1][this.getxGrid()]) == true){
			 if (orgGrid[this.getyGrid() + 1][this.getxGrid()].typeOrganism().compareToIgnoreCase("Ant") == 0) {
				orgGrid[this.getyGrid() + 1][this.getxGrid()] = null;
				this.setyGrid(this.getyGrid() + 1);
				retVal = true;
				steps= 0;
			}
		} if(this.getxGrid()+1 >19){
			
		}else if (eatingCheckNull(orgGrid[this.getyGrid()][this.getxGrid() + 1]) ){
			 if(orgGrid[this.getyGrid()][this.getxGrid() + 1].typeOrganism().compareToIgnoreCase("Ant") == 0) {
				orgGrid[this.getyGrid()][this.getxGrid() + 1] = null;
				this.setxGrid(this.getxGrid() + 1);
				retVal = true;
				steps= 0;
			}
		} if(this.getxGrid()-1 <0){
			
		}else if (eatingCheckNull(orgGrid[this.getyGrid()][this.getxGrid() - 1]) ){
			if( orgGrid[this.getyGrid()][this.getxGrid() - 1].typeOrganism().compareToIgnoreCase("Ant") == 0)  {
				orgGrid[this.getyGrid()][this.getxGrid() - 1] = null;
				this.setxGrid(this.getxGrid() - 1);
				retVal = true;
				steps= 0;
			}
		}
		
		if(retVal== false){
			steps++;
		}
		return retVal;

	}

	/* (non-Javadoc)
	 * @see edu.ilstu.it275.assignment7.ejzumba.Organism#move(edu.ilstu.it275.assignment7.ejzumba.Organism[][])
	 */
	@Override
	public void move(Organism[][] orgGrid) {
		// TODO Auto-generated method stub
		super.move(orgGrid);
		
	}
	
	

}
