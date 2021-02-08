import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Sprite {
	
	public BufferedImage currentsprite;
	
	float x;
	float y;
	float xspeed = 0;
	float yspeed = 0;
	int spriteHeight;
	int spriteWidth;
	
	public Sprite() {
		
	}
	
	public void paintSprite(Graphics2D g) {
		g.drawImage(currentsprite, (int)x, (int)y, spriteWidth, spriteHeight, null);
		
	}
	
	public void move(int width, int height) {
		x = x + xspeed;
		y = y + yspeed;
			
		if (x + xspeed < 0)
			xspeed = -xspeed;
		if (x + xspeed > width - 15)
			xspeed = -xspeed;
		if (y + yspeed < 0)
			yspeed = -yspeed;
		if (y + yspeed > height - 21)
			yspeed = -yspeed;
		}
	}

