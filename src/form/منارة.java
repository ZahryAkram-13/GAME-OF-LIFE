package form;

import java.util.Arrays;
import java.util.HashSet;

import model.Coordinate;

public class منارة extends Form {

	/**
	 * المنارة عبارة عن حاجزين يقترب احدهما من الاخر
	 * 
	 * @param الموضع
	 */
	public منارة(Coordinate الموضع) {
		super(الموضع);
		this.form = new HashSet<>();
		int x = this.position.getX();
		int y = this.position.getY();
		Block حاجز1 = new Block(الموضع);
		Block حاجز2 = new Block(new Coordinate(الموضع.getX() + 2, الموضع.getY() + 2));

		this.form.addAll(حاجز1.getForm());
		this.form.addAll(حاجز2.getForm());

	}

}
