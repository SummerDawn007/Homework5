/**
 *Ship.java
 *
 *Class that represents a ship object
 *@author SummerDawn
 *CMPT 202
 *Fall 2018
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;


public class Ship extends Polygon implements java.awt.event.KeyListener {

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
			position.x += 3 * Math.cos(Math.toRadians(rotation));
			position.y += 3 * Math.sin(Math.toRadians(rotation));
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		boolean forward = false;
		boolean left = false;
		boolean right = false;

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			// up arrow key
			// makes ship go forward
			forward = true;
		}
		else {
			forward = false;
		}

		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			// left arrow key
			// rotates ship left
			rotate(-10);
			left = true;
		}

		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			// right arrow key
			// rotates ship right
			rotate(10);
			right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		return;

	}
}
