package rules;

import java.util.Arrays;
import java.util.List;

import model.Board;
import model.Cell;
import model.Coordinate;

public abstract class BasicRulefunctions{
	public Board board; 

	public BasicRulefunctions(Board board) {
		this.board = board;
	}
	
	public int getNbrVoisinAlive(Cell cell) {
		
		int nbr = 0;
		int x = cell.getCoordinate().getX();
		int y = cell.getCoordinate().getY();
		//System.out.println(cell);
		
		Boolean NORTH = this.board.getCell(new Coordinate(x-1, y)).getState();
		Boolean EAST = this.board.getCell(new Coordinate(x, y+1)).getState();
		Boolean SOUTH = this.board.getCell(new Coordinate(x+1, y)).getState();
		Boolean WEST = this.board.getCell(new Coordinate(x, y-1)).getState();
		
		Boolean NORTH_EAST = this.board.getCell(new Coordinate(x-1, y+1)).getState();
		Boolean SOUTH_EAST = this.board.getCell(new Coordinate(x+1, y+1)).getState();
		Boolean SOUTH_WEST = this.board.getCell(new Coordinate(x+1, y-1)).getState();
		Boolean NORTH_WEST = this.board.getCell(new Coordinate(x-1, y-1)).getState();
		
		List<Boolean> voisinAlive = Arrays.asList(NORTH, EAST, SOUTH, WEST, NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST);
		
		for(Boolean voisin: voisinAlive) {
			nbr = voisin ? nbr +1 : nbr;
		}
		return nbr;
	}
	
	
	
	
}
