import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent implements Updatable {
	
	private Ellipse2D.Double ball;
	private int dx = 18;
	
	public Ball(int x, int y) {
		setBounds(x,y,11,11);
		ball = new Ellipse2D.Double(0,0,10,10);
	}
	
	public void update() {
		setLocation(getX()+dx,getY());
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(ball);
	}
	

}
