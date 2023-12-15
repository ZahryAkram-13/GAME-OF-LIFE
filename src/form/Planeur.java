package form;

import java.util.Arrays;
import java.util.HashSet;

import model.Coordinate;

public class Planeur extends Form{

	public Planeur(Coordinate position) {
		super(position);
		this.form = new HashSet<>();
		int x = this.position.getX();
		int y = this.position.getY();
		
		this.form.addAll(Arrays.asList(
				new Coordinate(x-1, y),
				new Coordinate(x, y+1),
				new Coordinate(x+1, y),
				new Coordinate(x+1, y+1),
				new Coordinate(x+1, y-1)
				));
	}

}
