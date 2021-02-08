import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

//import java.awt.Color;
//import java.awt.Font;



public class Attack extends JPanel {
	
	public static final String [] lewispics = {"lewiswait.png","lewisright1.png","lewisright2.png","lewisleft1.png","lewisleft2.png","lewisdown1.png","lewisdown2.png","lewisup1.png","lewisup2.png"};
//	public static String [] clarkpics = {"clarkwait.png","clarkright1.png","clarkright2.png","clarkleft1.png","clarkleft2.png","clarkdown1.png","clarkdown2.png","clarkup1.png","clarkup2.png"};
	
	final Player Lewis = new Player(lewispics, 384f, 384f);
	final Background land = new Background("LakeBgrnd.png", 0, 0);
/*	Player Clark = new Player(clarkpics, 700f, 700f);
	Bear bear1 = new Bear(0f, 700f, 1.99f);
	Bear bear2 = new Bear(700f, 0f, 1.99f);    */
	
	static boolean started = false;
	static final boolean Gameover = false;
	//boolean clarkWin = false;
	//boolean lewisWin = false;
	boolean Up = false;
	boolean Down = false;
	boolean Left = false;
	boolean Right = false;
	
	static BufferedImage background;
	
	public Attack() {
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		setFocusable(true);
		
	}
	
	public class MyKeyListener implements KeyListener {
		
		public void keyTyped(KeyEvent e) {
			
		}
		
		public void keyPressed(KeyEvent e) {
			
			started = true;
			
			if (e.getKeyChar() == 'w' || e.getKeyChar() == 'a' || e.getKeyChar() == 's' || e.getKeyChar() == 'd')	{
				Lewis.keyTime();
			}
			
			if (e.getKeyChar() == 'w') {
				Up = true;
				Lewis.spriteUp(true);	
			}	
			if (e.getKeyChar() == 'a') {
				Left = true;
				Lewis.spriteLeft(true);
			}
			if (e.getKeyChar() == 's') {
				Down = true;
				Lewis.spriteDown(true);
			}
			if (e.getKeyChar() == 'd') {
				Right = true;
				Lewis.spriteRight(true);
			}
		}
		
		public void keyReleased(KeyEvent e) {
			
			if (e.getKeyChar() == 'w') {
				Up = false;
				Lewis.spriteUp(false);
			}
			if (e.getKeyChar() == 'a') {
				Left = false;
				Lewis.spriteLeft(false);
			}
			if (e.getKeyChar() == 's') {
				Down = false;
				Lewis.spriteDown(false);
			}
			if (e.getKeyChar() == 'd') {
				Right = false;
				Lewis.spriteRight(false);
			}
		}
	}
	
	
	
	public void moveSprites() {
		if (Up || Down || Left || Right) {
			Lewis.lookUp = Up;
			Lewis.lookLeft = Left;
			Lewis.lookDown = Down;
			Lewis.lookRight = Right;
			
			
			
			if (!Lewis.moveIt(getWidth(), getHeight())) {
				land.back = Up;
				land.left = Left;
				land.forward = Down;
				land.right = Right;
				land.moveIt(-land.spriteWidth + getWidth(), -land.spriteHeight + getHeight());
			}
		}
	}
	
	public void collision() {
/*		if (Lewis.x - 14 < bear1.x && bear1.x < Lewis.x + 14 && Lewis.y -14 < bear1.y && bear1.y < Lewis.y + 14) {
			clarkWin = true;
			Gameover = true;
		} 
		if (Lewis.x - 14 < bear2.x && bear2.x < Lewis.x + 14 && Lewis.y -14 < bear2.y && bear2.y < Lewis.y + 14) {
			clarkWin = true;
			Gameover = true;
		}
		if (Clark.x - 14 < bear1.x && bear1.x < Clark.x + 14 && Clark.y -14 < bear1.y && bear1.y < Clark.y + 14) {
			lewisWin = true;
			Gameover = true;
		}
		if (Clark.x - 14 < bear2.x && bear2.x < Clark.x + 14 && Clark.y -14 < bear2.y && bear2.y < Clark.y + 14) {
			lewisWin = true;
			Gameover = true;
		}       */
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);	
		
		if (!Gameover) {
			land.paintSprite(g2d);
			Lewis.paintSprite(g2d);
	/*		Clark.paintSprite(g2d);
			bear1.paintSprite(g2d);
			bear2.paintSprite(g2d);     
		} else if (Gameover && clarkWin) {
			Attack.drawBackground(g2d);
			Clark.paintSprite(g2d);
			bear1.paintSprite(g2d);
			bear2.paintSprite(g2d);
			g.setFont(new Font("TimeRoman", Font.PLAIN, 20));
			g.setColor(Color.YELLOW);
			g.drawString("Game Over! Clark Wins!", 350, 400);
		} else {
			Attack.drawBackground(g2d);
			Lewis.paintSprite(g2d);
			bear1.paintSprite(g2d);
			bear2.paintSprite(g2d);
			g.setFont(new Font("TimeRoman", Font.PLAIN, 20));
			g.setColor(Color.ORANGE);
			g.drawString("Game Over! Lewis Wins!", 350, 400); */
		}
		
		if (!started) {
			Lewis.notStart();
/*			Clark.notStart();
			bear1.notStart(); 
			bear2.notStart();
			g.setFont(new Font("TimeRoman", Font.PLAIN, 12));
			g.setColor(Color.ORANGE);
			g.drawString("Use Keys W, A, S, and D to Control Lewis", 35, 20);
			g.setColor(Color.YELLOW);
			g.drawString("Use the Left, Right, Up, and Down Arrows to Control Clark", 390, 750);
			g.setFont(new Font("TimeRoman", Font.PLAIN, 20));
			g.setColor(Color.WHITE);
			g.drawString("Press Any Key to Start", 350, 400);  */
		} 
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Bear Attack!");
		Attack Attack = new Attack();
		frame.add(Attack);
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (!started) {
			Attack.repaint();
		}
		
		while (!Gameover) {
	/*		Attack.bear1.bearLook();
			Attack.bear2.bearLook(); */
			Attack.Lewis.moveStatus();
//			Attack.Clark.moveStatus();
			Attack.moveSprites();
			Attack.collision();
			Attack.repaint();
			Thread.sleep(10);
		} 
		//Attack.repaint();
	}
}
