package rules;

import model.Board;
import model.Cell;
import model.CellType;

public class Rule101 extends BasicRulefunctions implements Rule{
	

	public Rule101(Board board) {
		super(board);
	}


	@Override
	public Boolean executeRule(Cell cell) {
		if(cell.getType() != CellType.BORDER) {
			Boolean isAlive = Cell.attributeState(CellType.DEAD);
			int nbr = this.getNbrVoisinAlive(cell);
			
			isAlive = cell.getState() && (nbr == 3 || nbr == 2) ? 
						isAlive = Cell.attributeState(CellType.ALIVE) : 
						isAlive;
			isAlive = nbr == 3 && !cell.getState() ? 
					isAlive = Cell.attributeState(CellType.ALIVE) : 
					isAlive;
			
			return isAlive;	
		}
		return Cell.attributeState(CellType.DEAD);
			
	}
	

}
