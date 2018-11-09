package mountain;

import fractal.*;

public class mount extends Fractal {
	private Point d;
	private Point e;
	private Point f;
	private double dev;
	private int random = 0;
	public mount(Point a, Point b, Point c, double dev) {
		this.d = a;
		this.e = b;
		this.f = c;
		this.dev = dev;
	}

	@Override
	public String getTitle() {

		return "Mountain";
	}

	@Override
	public void draw(TurtleGraphics turtle) {
		fractalLine(turtle, order, d, e, f);
	}

	private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c) {
		dev = dev/2;
		if (order == 0) {
			turtle.moveTo(a.getX(), a.getY());
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
		} else {
			
			random = (int)RandomUtilities.randFunc(dev);
			fractalLine(turtle, order - 1, a, NewPoint(a,  b), NewPoint(a, c));
			fractalLine(turtle, order - 1, NewPoint(a, b), b, NewPoint(b, c));
			fractalLine(turtle, order - 1, NewPoint(a, c), NewPoint(b, c), c);
			fractalLine(turtle, order -1, NewPoint(b,c), NewPoint(a,c), NewPoint(a,b));
		}
	}

	private Point NewPoint(Point a, Point b) {
		
		Point a_ = new Point(a.getX() + (b.getX() - a.getX()) / 2, (int) ((a.getY() + (b.getY() - a.getY()) / 2)-random));
		return (a_);
	}
}
