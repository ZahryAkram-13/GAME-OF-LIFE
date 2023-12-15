package model;

import java.awt.Color;

import observer.abstactListenableModel;

public class Cell extends abstactListenableModel{
	
	public static final int CELL_SIZE = 50;
	
	
	private Coordinate coordinate;
	private Boolean state;
	private CellType type;
	private Colorr color;
	
	
	
	public Cell(Coordinate coordinate, CellType type) {
		//this.addListener(new CellView(this));
		this.coordinate = coordinate;
		this.type = type;
		this.state = Cell.attributeState(type);
		this.color = Cell.attributeColor(type);
	}

	
	public static Boolean attributeState(CellType type) {
		switch(type) {
		case ALIVE : return true;
		default : return false;
		}
	}
	
	public static Colorr attributeColor(CellType type) {
		switch(type) {
		case ALIVE : return Colorr.ALIVE;
		case DEAD : return Colorr.DEAD;
		case BORDER : return Colorr.BORDER;
		default : return Colorr.DEAD;
		}
	}
	
	public void changeCellType(CellType type) {
		if(this.type != CellType.BORDER) {
			this.type = type;
			this.state = Cell.attributeState(type);
			this.color = Cell.attributeColor(type);
		}
		System.out.print("cant change a border ");
		
	}

	@Override
	public String toString() {
		if(this.type == CellType.BORDER) return "B";
		return this.state ? "@" : " ";
	}

	public Colorr getColor() {
		return color;
	}


	public void setColor(Colorr color) {
		this.color = color;
	}


	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	
	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
		this.notifyListeners();
	}

	public CellType getType() {
		return type;
	}

	public void setType(CellType type) {
		this.type = type;
	}

}
