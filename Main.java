/**
 * @author NAthan Paolella pd 7
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener {
	
	int speed = 5;
	WalkingMan guy = new WalkingMan(100,100);
	ArrayList<Ball> arr = new ArrayList<Ball>();
	
	public Main() {
		setBounds(100,100,500,500);
		setResizable(true);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setLayout(null);
		add(guy);
		addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode() == KeyEvent.VK_W ) guy.setDY(-speed);
				else if (k.getKeyCode() == KeyEvent.VK_S ) guy.setDY(speed);
				else if (k.getKeyCode() == KeyEvent.VK_A ) guy.setDX(-speed);
				else if (k.getKeyCode() == KeyEvent.VK_D ) guy.setDX(speed);
				else if (k.getKeyCode() == KeyEvent.VK_SPACE) {
					if (arr.size()<6) {
						Ball b = new Ball(guy.getX()+51,guy.getY()+12);
						arr.add(b);
						add(b);
					}
				}
			}
			public void keyReleased(KeyEvent k) {
				if (k.getKeyCode() == KeyEvent.VK_W ) guy.setDY(0);
				else if (k.getKeyCode() == KeyEvent.VK_S ) guy.setDY(0);
				else if (k.getKeyCode() == KeyEvent.VK_A ) guy.setDX(0);
				else if (k.getKeyCode() == KeyEvent.VK_D ) guy.setDX(0);
			}
			public void keyTyped(KeyEvent arg0) {}
		});
		
		setVisible(true);
		
		Timer t = new Timer(1000/60,this);
		t.start();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		guy.update();
		if (guy.getX()<0)guy.setLocation(0, guy.getY());
		if (guy.getX()>this.getWidth()-64)guy.setLocation(this.getWidth()-64, guy.getY());
		if (guy.getY()<0)guy.setLocation(guy.getX(),0);
		if (guy.getY()>this.getHeight()-88)guy.setLocation(guy.getX(),this.getHeight()-88);
		for (Ball b: arr) {
			b.update();
		}
		if (arr.size()>0 && arr.get(0).getX()>=getWidth()) {
			remove(arr.get(0));
			arr.remove(0);
		}
		repaint();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
