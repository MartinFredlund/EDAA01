package drawing;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawingArea {
	private DrawingPanel drawingPanel;
	private ArrayList<Drawable> drawables = new ArrayList<Drawable>();

	public DrawingArea(String title, int width, int heigth, Color bgColor) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawingPanel = new DrawingPanel(drawables, width, heigth, bgColor);
		frame.add(drawingPanel, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
	}
	
	public void fillCircle(Color color, int x, int y, int size) {
		synchronized (drawables) {
			drawables.add(new DrawableCircle(color, x, y, size));
		}
	}
	
	public void drawLine(Color color, int x1, int y1, int x2, int y2) {
		synchronized (drawables) {
			drawables.add(new DrawableLine(color, x1, y1, x2, y2));
		}
	}
	
	public void drawString(Color color, String text, int x, int y) {
		synchronized (drawables) {
			drawables.add(new DrawableString(color, text, x, y));
		}
	}
	
	public void erase() {
		synchronized (drawables) {
			drawables.clear();
		}
	}
	
	public void paint() {
		drawingPanel.repaint();
	}
	
}
