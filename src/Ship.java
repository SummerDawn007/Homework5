/**
 *@author SummerDawn
 *CMPT 202
 *Fall 2018
 */
import java.awt.Color;
import java.awt.Graphics;

public class Ship extends Polygon {

	public Ship(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
	}

	@Override
	public void paint(Graphics brush, Color color) {
		Point[] pts = getPoints();
		int[] xpts = new int[pts.length];
		int[] ypts = new int[pts.length];
		int npts = pts.length;

		for (int i = 0; i < npts; i++) {
			xpts[i] = (int)pts[i].x;
			ypts[i] = (int)pts[i].y;
		}

		brush.setColor(color);
		brush.fillPolygon(xpts, ypts, npts);
		
	}

	@Override
	public void move() {
		position.x += 1;
		if(position.x > Asteroids.SCREEN_WIDTH) {
			position.x -= Asteroids.SCREEN_WIDTH;
		}
	}
}
