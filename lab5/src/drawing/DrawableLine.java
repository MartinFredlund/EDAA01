package drawing;
import java.awt.Color;
import java.awt.Graphics;

public class DrawableLine extends Drawable {
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public DrawableLine(Color color, int x1, int y1, int x2, int y2) {
		super(color);
		this.x1 = x1;	
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);
		g.setColor(Color.BLACK);
	}
}
