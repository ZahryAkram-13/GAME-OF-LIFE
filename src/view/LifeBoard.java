package view;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import model.Board;
import model.Cell;
import model.Colorr;
import model.Coordinate;
import observer.ModelListener;

public class LifeBoard extends JPanel implements ModelListener {

	
	private Board board;

	public LifeBoard(Board board) {
		super();
		this.board = board;
		this.board.addListener(this);
	}
	
	public static void test() {
		
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int cellSize = Math.floorDiv(this.getWidth(), Board.LIFE+1);
		

		for (int i = 0; i <= Board.LIFE+1; i++) {
			for (int j = 0; j <= Board.LIFE+1; j++) {
				Cell cell = this.board.getCell(new Coordinate(i, j));
				Colorr color = cell.getColor();
				int x = j * cellSize;
				int y = i * cellSize;
				g.setColor(color.getColor());
				g.fillRect(x, y, cellSize, cellSize);

				g.setColor(Colorr.BORDER.getColor());
				g.drawRect(x, y, cellSize, cellSize);

			}
		}
		

	}

	@Override
	public void update(Object source) {
		if (source instanceof Board) {
			this.board = (Board) source;
			this.repaint();
		}

	}

}
