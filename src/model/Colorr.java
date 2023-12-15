package model;

import java.awt.Color;

public enum Colorr {
	BORDER(Color.BLACK),
    ALIVE(Color.RED),
    DEAD(Color.WHITE);

    public Color color;

    // Constructor
    Colorr(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
 
}
