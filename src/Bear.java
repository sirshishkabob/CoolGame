import java.io.File;

import javax.imageio.ImageIO;

public class Bear extends Character {

	int counter = 0;
	
	public static final String [] filenames = {"bearwait.png","bearright1.png","bearright2.png","bearleft1.png","bearleft2.png","beardown1.png","beardown2.png","bearup1.png","bearup2.png"};
	final float speed;
	
	public Bear(float startingX, float startingY, float mySpeed) {
		int index;

		for (index=0; index<9; index++)
		{
			
			try {
				picChar[index] = ImageIO.read(new File(filenames[index]));
			}
				catch (Exception e) { System.out.println(e);}
		}
		
		super.x = startingX;
		super.y = startingY;
		speed = mySpeed;
	}
	
	public void notStart() {
		currentsprite = picChar[wait];
	}
	
	public void move(int width, int height, float lewisX, float lewisY, float clarkX, float clarkY) {
		
		double lewishypotenuse = Math.sqrt(Math.pow((lewisY - super.y), 2) + Math.pow((lewisX - super.x), 2));
		double clarkhypotenuse = Math.sqrt(Math.pow((clarkY - super.y), 2) + Math.pow((clarkX - super.x), 2));
		if (lewishypotenuse < clarkhypotenuse) {
			xspeed = (lewisX - super.x) / (float)lewishypotenuse * speed;
			yspeed = (lewisY - super.y) / (float)lewishypotenuse * speed;
		} else if (clarkhypotenuse < lewishypotenuse) {
			xspeed = (clarkX - super.x) / (float)clarkhypotenuse * speed;
			yspeed = (clarkY - super.y) / (float)clarkhypotenuse * speed;
		}
		
		
		super.move(width, height);
	}
	
	public void bearLook() {
		
		if (xspeed > yspeed && xspeed > 0) {
			if (counter < 11) {
				currentsprite = picChar[right1];
			} else 
				currentsprite = picChar[right2];
		}
		
		if (xspeed < yspeed && yspeed < 0) {
			if (counter < 11) {
				currentsprite = picChar[left1];
			} else {
				currentsprite = picChar[left2];
			}
		}
		
		if (xspeed < yspeed && yspeed > 0) {
			if (counter < 11) {
				currentsprite = picChar[down1];
			} else {
				currentsprite = picChar[down2];
			}
		}
		
		if (xspeed > yspeed && xspeed < 0) {
			if (counter < 11) {
				currentsprite = picChar[up1];
			} else {
				currentsprite = picChar[up2];
			}
		}
		
		counter++;
		
		if (counter == 20) {
			counter = 0;
		}
	}
}
