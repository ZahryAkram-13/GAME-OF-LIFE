package view;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JFrame;

import form.Blinker;
import form.Frog;
import form.Horloge;
import form.Planeur;
import form.منارة;
import model.Board;
import model.Cell;
import model.Coordinate;
import rules.Rule101;

public class Window extends JFrame{
	
	public static final int WINDOW_SIZE = 1000;
	public static final int SPEED = 300;
	
	public static final int QUARTER1 = (Board.LIFE)/4;
	public static final int QUARTER4 = (3*Board.LIFE)/4;
	
	public Window() {
		this.setTitle("Life");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Board b = new Board();
		b.setRule(new Rule101(b));
		//b.setFormOnGrid(new Blinker(new Coordinate(9, 9)));
		b.setFormOnGrid(new Planeur(new Coordinate(QUARTER1, QUARTER1)));
		//b.setFormOnGrid(new Frog(new Coordinate(15, 15)));
		b.setFormOnGrid(new منارة(new Coordinate(Board.LIFE-3, 9)));
		b.setFormOnGrid(new Horloge(new Coordinate(QUARTER4, QUARTER4)));
		LifeBoard life = new LifeBoard(b);
		this.add(life);
		
        
		
        this.setSize(WINDOW_SIZE, WINDOW_SIZE+80);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        try {
			b.throwGameOfLife();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	

		
	

		
		
		
		
	
	public static void test() {
		Window win = new Window();
		
	}
}
