package form;

import java.util.Arrays;
import java.util.HashSet;

import model.Coordinate;

public class Frog extends Form{

	public Frog(Coordinate position) {
		super(position);
		this.form = new HashSet<>();
		int x = this.position.getX();
		int y = this.position.getY();
		
		
		this.form.addAll(Arrays.asList(
				new Coordinate(x, y),
				new Coordinate(x+1, y),
				new Coordinate(x+2, y+1),
				
				new Coordinate(x, y+3),
				new Coordinate(x+1, y+3),
				new Coordinate(x-1, y+2)
				
				));
	}

}
