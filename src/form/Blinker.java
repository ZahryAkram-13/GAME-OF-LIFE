package form;

import java.util.Arrays;
import java.util.HashSet;

import model.Coordinate;

public class Blinker extends Form{
	
	public Blinker(Coordinate position) {
		super(position);
		this.size = 1;
		this.form = new HashSet<>();
		int x = this.position.getX();
		int y = this.position.getY();
		
		
		this.form.addAll(Arrays.asList(
				new Coordinate(x, y),
				new Coordinate(x, y+1),
				new Coordinate(x, y-1)
				
				));
	} 
}
