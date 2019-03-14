/**
 * @author NAthan Paolella pd 7
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class WalkingMan extends JComponent implements Updatable{
	
	private Ellipse2D.Double head;
	private Rectangle body, arm, leftLeg, rightLeg;
	
	private int dx, dy;
	
	public WalkingMan (int x, int y) {
		setLocation(x,y);
		setSize(51,51);
		dx = 0;
		dy = 0;
		head = new Ellipse2D.Double(15,0,20,15);
		body = new Rectangle(20,15,10,20);
		arm = new Rectangle(0,15,50,7);
		leftLeg = new Rectangle(10,35,10,15);
		rightLeg = new Rectangle (30,35,10,15);
	}
	
	public void setDY(int dy) {
		this.dy=dy;
	}
	
	public void setDX(int dx) {
		this.dx=dx;
	}
	
	public void update() {
		setLocation(getX()+dx,getY()+dy);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(head);
		g2.fill(body);
		g2.fill(arm);
		g2.fill(leftLeg);
		g2.fill(rightLeg);
	}

}
