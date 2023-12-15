package form;

import java.util.Set;

import model.Board;
import model.Coordinate;

public class Form {
	
	protected int size;

	protected Set<Coordinate> form;
	protected Coordinate position;

	public Form(Coordinate position) {
		this.position = position;
	}
	
	public Boolean canWePutIt() {
		int x = this.position.getX();
		int y = this.position.getY();
		return x + this.size < Board.LIFE-1 || y + this.size < Board.LIFE-1;
	}

	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(Coordinate position) {
		this.position = position;
	}

	public Set<Coordinate> getForm() {
		return form;
	}

	public void setForm(Set<Coordinate> form) {
		this.form = form;
	}

}
