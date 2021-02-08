import javax.imageio.ImageIO;
import java.io.File;

public class Player extends Character {

	boolean movement = false;
	boolean sprint = false;
	boolean back = false;
	boolean forward = false;
	boolean left = false;
	boolean right = false;
	boolean lookUp = false;
	boolean lookLeft = false;
	boolean lookDown = false;
	boolean lookRight = false;
	boolean spriteMove = false;

	int speed = 2;
	int count = 0;
	int noGo = 21;
	int index;
	final int penRadius = 100;
	
	public Player(String[] filenames, float startingX, float startingY) {
		
		super.x = startingX;
		super.y = startingY;
		
		
		for (index=0; index<9; index++)
		{
			
			try {
				picChar[index] = ImageIO.read(new File(filenames[index]));
			}
				catch (Exception e) { System.out.println(e);}
		}
		
		super.spriteHeight = 2 * picChar[1].getHeight();
		super.spriteWidth = 2 * picChar[1].getWidth();
	}
	
	public void notStart() {
		currentsprite = picChar[wait];
	}
	
	public void moveStatus() {
		if (!movement) {
			noGo++;
			if (noGo > 40) {
				currentsprite = picChar[wait];
			}
		}
		if (movement) {
			noGo = 0;
		}
	}
	
	private float centerDistance(float xx, float yy, int width, int height) {
		double centerSq = Math.pow((xx - width/2), 2) + Math.pow((yy - height/2), 2);
		double centerDistance = Math.sqrt(centerSq);
		return ((float) centerDistance);
	}
	
	public boolean moveIt(int width, int height) {
		
		float tempX = x;
		float tempY = y;
		
		if (lookUp) {
				tempY = tempY - speed;		
		}
		
		if (lookLeft) {
				tempX = tempX - speed;	
		}
		
		if (lookDown) {
				tempY = tempY + speed;	
		}
		
		if (lookRight) {
				tempX = tempX + speed;
		}
		
		if (centerDistance(tempX, tempY, width, height) < penRadius) {
			y = tempY;
			x = tempX;
			return(true);
		} else {
			return(false);
		}
	}
	
	
	
	
	public void spriteUp(boolean look) {
		if (look && !lookLeft && !lookRight) {
			lookUp = true;
			if (count < 9) {
				currentsprite = picChar[up1];		
			} else {
				currentsprite = picChar[up2];
			}
		} else {
			lookUp = false; 
		}
		setMove();
	}
	
	public void spriteLeft(boolean look) {
		if (look) {
			lookLeft = true;
			if (count < 9) {
				currentsprite = picChar[left1];		
			} else {
				currentsprite = picChar[left2];
			}
		} else {
			lookLeft = false;
		}
		setMove();
	}
	
	public void spriteDown(boolean look) {
		if (look && !lookLeft && !lookRight) {
			lookDown = true;
			if (count < 9) {
				currentsprite = picChar[down1];		
			} else {
				currentsprite = picChar[down2];
			}
		} else {
			lookDown = false;
		}
		setMove();
	}
	
	public void spriteRight(boolean look) {
		if (look) {
			lookRight = true;
			if (count < 9) {
				currentsprite = picChar[right1];		
			} else {
				currentsprite = picChar[right2];
			}
		} else {
			lookRight = false;
		}
		setMove();
	}
	
	

	public void sprinting(boolean travel) {
		if (travel) {
			sprint = true;
		}
		else {
			sprint = false;
		}
		speed = 1;
	}

	private void setMove () {
		movement = lookUp || lookLeft || lookDown || lookRight;
	}
	
	
	
	
	
	public void keyTime() {
		if (count == 16) {
		    count = 0;
		}	
		count++;
	}
}
