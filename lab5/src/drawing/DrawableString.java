package drawing;
import java.awt.Color;
import java.awt.Graphics;

public class DrawableString extends Drawable {
	private String text;
	private int x;
	private int y;

	public DrawableString(Color color, String text, int x, int y) {
		super(color);
		this.text = text;
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.drawString(text, x, y);
		g.setColor(Color.BLACK);
	}
}
