package model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import form.Blinker;
import form.Block;
import form.Form;
import form.Horloge;
import form.Planeur;
import observer.abstactListenableModel;

import java.util.List;

import rules.Rule;
import rules.Rule101;
import view.Window;

public class Board extends abstactListenableModel{
	
	public static final int LIFE = 50;
	private List<List<Cell>> board;
	private Rule rule;
	
	private Set<Coordinate> aliveCells;
	
	public static void test() {
		Board b = new Board();
		b.setRule(new Rule101(b));
		b.setFormOnGrid(new Planeur(new Coordinate(5, 5)));
		b.setFormOnGrid(new Horloge(new Coordinate(5, 5)));
		b.setFormOnGrid(new Blinker(new Coordinate(3, 3)));
		b.setFormOnGrid(new Block(new Coordinate(7, 7)));
		System.out.println(b);
		try {
			b.throwGameOfLife();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public Board() {
		this.aliveCells = new HashSet<Coordinate>();
		this.populateBoardDeadCells();
		
	}
	
	public Cell getCell(Coordinate coordinate) {
		return this.board.get(coordinate.getX()).get(coordinate.getY());
	}
	
	public void giveLifeToCells(Set<Coordinate> cells) {
		cells.forEach(coordinate ->{
			this.makeDeadOrAlive(coordinate, false);
		});
		
	}
	
	public void setFormOnGrid(Form form) {
		Boolean canWe = form.canWePutIt();
		if(canWe) {
			form.getForm().forEach(coordinate ->{
				this.makeDeadOrAlive(coordinate, false);
			});
			this.notifyListeners();
		}
	
		
	}
	
	public Boolean isAllDead() {
		return this.aliveCells.isEmpty();
	}
	
	public void makeDeadOrAlive(Coordinate coordinate, Boolean kill) {
		Cell cell = this.getCell(coordinate);
		if(!kill) {
			cell.changeCellType(CellType.ALIVE);
			this.aliveCells.add(coordinate);
		}
		else {
			cell.changeCellType(CellType.DEAD);
		}
		this.notifyListeners();
	}
	
	
	
	public void throwGameOfLife() throws InterruptedException {
		int stop = 0;
		while(true) {
			Boolean isAllDead = this.isAllDead();
			if(isAllDead) break;
			System.out.println(this);
			this.executeRule();
			this.setNextGenaration();
			
			stop += 1;
			Thread.sleep(Window.SPEED);
		}
	}
	
	public void setNextGenaration() {
		this.populateBoardDeadCells();
		this.aliveCells.forEach(coordinate ->{
			this.makeDeadOrAlive(coordinate, false);
		});
	}
	
	

	
	public void executeRule() {
		Set<Coordinate> newGen = new HashSet<>();
		for(int i = 1; i <= LIFE; i++) {
			for(int j = 1; j <= LIFE; j++) {
				Cell cell = this.getCell(new Coordinate(i, j));
				Boolean isAlive = this.rule.executeRule(cell);
				if(isAlive) newGen.add(new Coordinate(i, j));
				
			}
		}
		this.aliveCells = newGen;
	}
	
	
	public void populateBoardDeadCells() {
		this.board = new ArrayList<>();
		for(int i = 0; i < LIFE+2; i++) {
			List<Cell> row = new ArrayList<>();
			for(int j = 0; j < LIFE+2; j++) {
				Boolean isBorder = (i == 0 || j == 0 || i == LIFE+1 || j == LIFE+1);
				Cell cell = isBorder ? 
							new Cell(new Coordinate(i, j), CellType.BORDER) :
							new Cell(new Coordinate(i, j), CellType.DEAD);
				
				row.add(cell);
				
			}
			this.board.add(row);
		}
		this.notifyListeners();
	}

	@Override
	public String toString() {
		String board = "";
		for(int i = 0; i <= LIFE+1; i++) {
			for(int j = 0; j <= LIFE+1; j++) {
				Cell cell = this.getCell(new Coordinate(i, j));
				board += cell.toString();
				board += "  ";
			}
			board += "\n\n";
		}
		//board += this.aliveCells;
		return board;
	}

	public List<List<Cell>> getBoard() {
		return board;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public Set<Coordinate> getAliveCells() {
		return aliveCells;
	}


	public void setBoard(List<List<Cell>> board) {
		this.board = board;
	}

	
	

}
