package edu.ilstu.it275.assignment7.ejzumba;

import java.awt.Color;

public class Ant extends Organism {
	private int breedTime;
	private int round;
	
	
	public Ant(){
		super();	
		breedTime= 0;
		round= 0;
		
	}
	public Ant(int x, int y, int gameRound){
		super(x, y, gameRound);	
		round= gameRound+1;
	}

	
	
	/* (non-Javadoc)
	 * @see edu.ilstu.it275.assignment7.ejzumba.Organism#color()
	 */
	@Override
	public Color color() {
		return Color.BLUE;
	}
	
	/* (non-Javadoc)
	 * @see edu.ilstu.it275.assignment7.ejzumba.Organism#breed()
	 */
	public void breed(Organism[][] orgGrid, int gameRound) {
		if(breedTime== 3){
			outerloop:							//found this on stack overflow username jon skeet
			for(int i= 0; i<20; i++){
				for(int j= 0; j<20; j++){
					if(orgGrid[i][j]== null){
						//System.out.println(breedTime);
						orgGrid[i][j]= new Ant(j, i, gameRound);
						breedTime= 0;
						break outerloop;
					}
				}
				
			}
		}else{
			breedTime++;
		}
	}
	
	
	/* (non-Javadoc)
	 * @see edu.ilstu.it275.assignment7.ejzumba.Organism#typeOrganism()
	 */
	@Override
	public String typeOrganism() {
		super.typeOrganism();
		String retVal= "Ant";
		return retVal;
		
	}

	/* (non-Javadoc)
	 * @see edu.ilstu.it275.assignment7.ejzumba.Organism#breed()
	 
	@Override
	public void breed() {
		super.breed();
		int x= this.getxGrid();
		int y= this.getyGrid();
		if(this.getTime()== 3){
			this.setTime(0);
			
		}
		
	}
	*/

	public boolean dead(){
		boolean retVal= true;
		
		return retVal;
	}
	/**
	 * @return the round
	 */
	public int getRound() {
		return round;
	}
	/* (non-Javadoc)
	 * @see edu.ilstu.it275.assignment7.ejzumba.Organism#move(edu.ilstu.it275.assignment7.ejzumba.Organism[][])
	 */
	@Override
	public void move(Organism[][] orgGrid) {
		// TODO Auto-generated method stub
		super.move(orgGrid);
		round++;
	}
	
	
	
}
