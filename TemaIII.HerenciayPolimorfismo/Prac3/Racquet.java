import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;
import java.awt.Color;
public class Racquet {
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;

	private MiniTennis game;
	private int x;
	private int xspd;
	public Racquet(MiniTennis game) {
		this.game = game;
	}

	public void move() {
		if (x + xspd > 0 && x + xspd < game.getWidth()- WIDTH)
			x = x + xspd;
	}

	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xspd = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xspd = -game.speed;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xspd = game.speed;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public int getY() {
		return Y;
	}
}
