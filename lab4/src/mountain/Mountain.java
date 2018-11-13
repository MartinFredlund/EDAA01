package mountain;

import fractal.*;
import java.util.*;

public class Mountain extends Fractal {
	private Point d;
	private Point e;
	private Point f;
	private double dev;
	private int random = 0;
	HashMap<Side, Point> sideMap= new HashMap<>(); 
	public Mountain(Point a, Point b, Point c, double dev) {
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
		fractalTriangle(turtle, order, d, e, f, dev);
	}

	private void fractalTriangle(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev) {
		
		if (order == 0) {
			turtle.moveTo(a.getX(), a.getY());
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
		} else {
			
			random = (int)RandomUtilities.randFunc(dev);
			Point ab = NewPoint(a,b);
			Point ac = NewPoint(a,c);
			Point bc = NewPoint(b,c);
			fractalTriangle(turtle, order - 1, a, ab, ac, dev/2);
			fractalTriangle(turtle, order - 1, ab, b, bc, dev/2);
			fractalTriangle(turtle, order - 1, ac, bc, c, dev/2);
			fractalTriangle(turtle, order -1, bc, ac, ab, dev/2);
		}
	}

	private Point NewPoint(Point a, Point b) {
		Side newSide = new Side(a,b);
		if(sideMap.containsKey(newSide)) {
			Point pt = sideMap.get(newSide);
			sideMap.remove(newSide);
			return pt;
		}
		else {
			int x = a.getX() + (b.getX() - a.getX()) / 2;
			int y = (int) ((a.getY() + (b.getY() - a.getY()) / 2) + random);
			Point newPoint = new Point(x,y);
			sideMap.put(newSide, newPoint);
			
			return (newPoint);
		}
	}
}
