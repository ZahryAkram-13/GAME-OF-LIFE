package form;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import model.Coordinate;

public class Horloge extends Form {
	private static final int HORLOG_ZISE = 6;
	
	public Horloge(Coordinate position) {
		super(position);
		this.form = new HashSet<>();
		this.size = 7;

		int x = this.position.getX();
		int y = this.position.getY();
		
		this.form.addAll(this.putWatchHands(position));
		this.form.addAll(putWatchBlocks(position));

		for (int i = 0; i < HORLOG_ZISE; i++) {
			for (int j = 0; j < HORLOG_ZISE; j++) {
				Boolean c1 = this.removeSquareCornersCondition(new Coordinate(i, j));
				Boolean c2 = this.removeSquareHeartCondition(new Coordinate(i, j));

				if (c1 && c2) {
					this.form.add(new Coordinate(x + i, y + j));

				}
			}
		}

	}
	
	public Set<Coordinate> putWatchBlocks(Coordinate coordinate){
		int x = coordinate.getX();
		int y = coordinate.getY();
		Set<Coordinate> blocks = new HashSet<>();
		
		Block north = new Block(new Coordinate(x-3, y+3));
		Block east = new Block(new Coordinate(x+3, y+7));
		Block south = new Block(new Coordinate(x+7, y+1));
		Block west = new Block(new Coordinate(x+1, y-3));
		
		blocks.addAll(north.getForm());
		blocks.addAll(east.getForm());
		blocks.addAll(south.getForm());
		blocks.addAll(west.getForm());

		return blocks;
	}
	
	
	public Set<Coordinate> putWatchHands(Coordinate coordinate) {
		int x = coordinate.getX();
		int y = coordinate.getY();
		
		Set<Coordinate> hands = new HashSet<>();
		hands.addAll(Arrays.asList(
				new Coordinate(x+2, y+2),
				new Coordinate(x+2, y+3),
				new Coordinate(x+3, y+4)
				));
		return hands;
		
	}

	public Boolean removeSquareHeartCondition(Coordinate coordinate) {
		int i = coordinate.getX();
		int j = coordinate.getY();
		Boolean ci = i == 0 || i == HORLOG_ZISE-1;
		Boolean cj = j == 0 || j == HORLOG_ZISE-1;
		return ci || cj;
	}

	public Boolean removeSquareCornersCondition(Coordinate coordinate) {
		int i = coordinate.getX();
		int j = coordinate.getY();
		Boolean c1 = i == 0 && j == 0;
		Boolean c2 = i == 0 && j == HORLOG_ZISE-1;
		Boolean c3 = i == HORLOG_ZISE-1&& j == 0;
		Boolean c4 = i == HORLOG_ZISE-1&& j == HORLOG_ZISE-1;
		return !c1 && !c2 && !c3 && !c4;
	}
}
