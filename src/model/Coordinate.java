package model;

public class Coordinate {
	
	private int x;
	private int y;
	
	public static void test() {
		Coordinate c1 = new Coordinate(1, 5);
		System.out.print(c1);
	}

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
