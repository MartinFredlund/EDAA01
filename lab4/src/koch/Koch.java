package koch;

import fractal.*;

public class Koch extends Fractal {
	private int length;

	/** Creates an object that handles Koch's fractal. 
	 * @param length the length of the triangle side
	 */
	public Koch(int length) {
		super();
		this.length = length;
	}

	/**
	 * Returns the title.
	 * @return the title
	 */
	public String getTitle() {
		return "Kochs triangel";
	}

	/** Draws the fractal.  
	 * @param turtle the turtle graphic object
	 */
	public void draw(TurtleGraphics turtle) {
		turtle.moveTo(turtle.getWidth() / 2.0 - length / 2.0,
				turtle.getHeight() / 2.0 + Math.sqrt(3.0) * length / 4.0);
		fractalLine(turtle, order,length,0);
		fractalLine(turtle, order,length,120);
		fractalLine(turtle, order,length,240);
	}

	/* 
	 * Recursive method: Draws a recursive line of the triangle. 
	 */
	private void fractalLine(TurtleGraphics turtle, int order, double length, int alpha) {
		//TODO
	}

}
