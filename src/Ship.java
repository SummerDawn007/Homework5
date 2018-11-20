/**
 *Ship.java
 *
 *Class that represents a ship object
 *@author SummerDawn
 *CMPT 202
 *Fall 2018
 */
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Ship extends Polygon implements java.awt.event.KeyListener  {
	public static final int SHIP_WIDTH = 40;
	public static final int SHIP_HEIGHT = 25;
	private boolean forward = false;
	private boolean left = false;
	private boolean right = false;

	public Ship(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
	}

	// Create paint method to paint a ship
	public void paint(Graphics brush, Color color) {
		Point[] points = getPoints();
		int[] xPoints = new int[points.length];
		int[] yPoints = new int[points.length];
		int nPoints = points.length;
		for(int i = 0; i < nPoints; ++i) {
			xPoints[i] = (int) points[i].x;
			yPoints[i] = (int) points[i].y;
		}
		brush.setColor(color);
		brush.fillPolygon(xPoints, yPoints, nPoints);
	}

	public void move() {

		// we'll just demonstrate the ship moving across the x axis.
		if (forward == true) {
			position.x += 3 * Math.cos(Math.toRadians(rotation));
			position.y += 3 * Math.sin(Math.toRadians(rotation));
			/**
			 * If the ship moves off of the screen either along the
			 * x or y axis, have the ship re-appear coming from the other side.
			 */
			if(position.x > Asteroids.SCREEN_WIDTH) {
				position.x -= Asteroids.SCREEN_WIDTH;
			} else if(position.x < 0) {
				position.x += Asteroids.SCREEN_WIDTH;
			}
			if(position.y > Asteroids.SCREEN_HEIGHT) {
				position.y -= Asteroids.SCREEN_HEIGHT;
			} else if(position.y < 0) {
				position.y += Asteroids.SCREEN_HEIGHT;

			}
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {


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
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			// up arrow key
			// makes ship go forward
			forward = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		return;

	} 
}
