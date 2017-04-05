package edu.ilstu.it275.assignment7.ejzumba;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SampleBugPanel extends JPanel {
	
	private int x= 0;
	private int y= 0;
	private int width= 20;
	private int height= 20;
	private static final int PANEL_HEIGHT = 400;
	private static final int PANEL_WIDTH = 400;
	private static Organism [][] orgGrid;
	private int gameRound;
	//private static List l;
	private static MouseStuff click;

	public SampleBugPanel() {
		orgGrid= new Organism[20][20];
		gameRound= 0;
		//l= new List();
		click= new MouseStuff();
		
		setPreferredSize(new Dimension(PANEL_HEIGHT, PANEL_WIDTH));
		setBackground(Color.WHITE);
		
	}

	public void paintComponent(Graphics g) {
		
		y= 0;
		super.paintComponent(g);
		for(int yAxis= 0; yAxis<20; yAxis++){
			x= 0;
			for(int xAxis= 0; xAxis<20; xAxis++){
				g.drawRect(x, y, width, height);
				x+= 20;
			}
			y+= 20;		
		}
		int panelValues []= new int[2];
		for(int i= 0; i<20; i++){
			for(int j= 0; j<20; j++){
				if( orgGrid[i][j]== null){
					g.setColor(Color.WHITE);
				}else{
					g.getColor();
					g.setColor(orgGrid[i][j].color());
					panelValues= orgGrid[i][j].panelLocation();
					g.fillRect(panelValues[0], panelValues[1], width, height);
				}
				
				
				/*else{
					if( orgGrid[i][j].typeOrganism().compareTo("Ant")== 0){
						g.getColor();
						g.setColor(Color.BLUE);
					}else if( orgGrid[i][j].typeOrganism().compareTo("Doodlebug")== 0){
						g.getColor();
						g.setColor(Color.RED);
					}
					int panelValues []= new int[2];
					panelValues= orgGrid[i][j].panelLocation();
					g.fillRect(panelValues[0], panelValues[1], width, height); 			//panelValues[0] is X
				}*/					
			}
		}
		
		
		/*
		while(l.getOrganism(i)!= null){
			int panelValues []= new int[2];
			Organism organism= l.getOrganism(i);
			if(organism.typeOrganism().compareTo("Ant")== 0){
				g.getColor();
				g.setColor(Color.BLUE);
			}else if(organism.typeOrganism().compareTo("Doodlebug")== 0){
				g.getColor();
				g.setColor(Color.RED);
			}
			panelValues= organism.panelLocation();			
			g.fillRect(panelValues[0], panelValues[1], width, height); 			//gridValues[0] is X
			i++;
		}
		*/
	}

	/**
	 * @param layout
	 */
	public SampleBugPanel(LayoutManager layout) {
		super(layout);
	}

	/**
	 * @param isDoubleBuffered
	 */
	public SampleBugPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public SampleBugPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Bug game");
		SampleBugPanel panel = new SampleBugPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.addMouseListener(click);
		
		generateAnts();
		generateDoodlebugs();
		//System.out.println(orgGrid[1][2].toString());
		
		
		
	}
	
	public static void generateAnts(){
		int i= 0;
		while(i< 100){
			Ant a= new Ant();
			while(orgGrid[a.getyGrid()][a.getxGrid()]!= null){
				a.reAdjustPosition(orgGrid);
			}
			orgGrid[a.getyGrid()][a.getxGrid()]= a;
			i++;
		}		
	}
	
	public static void generateDoodlebugs(){
		int i= 0;
		while(i< 5){
			Doodlebug d= new Doodlebug();
			while(orgGrid[d.getyGrid()][d.getxGrid()]!= null){
				d.reAdjustPosition(orgGrid);
			}
			orgGrid[d.getyGrid()][d.getxGrid()]= d;
			i++;
		}		
	}
	
	public void organismsMove(){
		for(int i= 0; i<20; i++){
			for(int j= 0; j<20; j++){
				if( orgGrid[i][j]== null ){
					
				}else if( orgGrid[i][j].typeOrganism().compareTo("Doodlebug")== 0 ){
					Doodlebug bug= (Doodlebug) orgGrid[i][j];
					if(gameRound== bug.getRound()){
						if(bug.eatRevised(orgGrid)== true){
							bug.breed(orgGrid, gameRound);
						
						}else{
							Doodlebug d= (Doodlebug) orgGrid[i][j];
							d.move(orgGrid);
							d.breed(orgGrid, gameRound);
							d.starve(orgGrid);
						
						}
						System.out.println("doodle round: " +bug.getRound());
					}
				}else if(orgGrid[i][j].typeOrganism().compareTo("Ant")==0){
					 Ant a= (Ant) orgGrid[i][j];
					 if(a.getRound()== gameRound){
						 a.move(orgGrid);
						 a.breed(orgGrid, gameRound);
					 }
					 System.out.println("ant round: "+ a.getRound());
				}
				
			}
		}
		System.out.println("GameRound: "+ gameRound);
		gameRound++;
		System.out.println("GameRound: "+ gameRound);

	}
	
	
	private class MouseStuff implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			organismsMove();
			repaint();
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
		
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
				
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
		

	}

	

}

