import javax.imageio.ImageIO;
import java.io.File;

public class Background extends Sprite {
	

		public boolean movement = false;
		public boolean sprint = false;
		public boolean back = false;
		public boolean forward = false;
		public boolean left = false;
		public boolean right = false;

		int speed = 2;
		int count = 0;
		int noGo = 21;
		int index = 0;
		
		
		
		public Background(String filename, float startingX, float startingY) {
			
			super.x = startingX;
			super.y = startingY;
		
			try {
				currentsprite = ImageIO.read(new File(filename));
			}
				catch (Exception e) { 
					System.out.println(e);
				}
	
			super.spriteHeight = currentsprite.getHeight();
			super.spriteWidth = currentsprite.getWidth();
		}
		
		public void notStart() {
			
		}
		
		public void moveStatus() {
			
		}
		
		public void moveIt(int width, int height) {
			
			if (back) {
				
				if (y < 0) {	
					y = y + speed;
				}
			}
			if (left) {
				if (x < 0) {
					x = x + speed;
				}
			}
			if (forward) {
				if (y > height) {	
					y = y - speed;
				} 
			}
			if (right) {
				if (x > width) {
					x = x - speed;
				}
			}	
		}
		
		public void moveUp(boolean move) {
			back = move;
		}
		
		public void moveLeft(boolean move) {
			left = move;
		}

		public void moveDown(boolean move) {
			forward = move;
		}
		
		public void moveRight(boolean move) {
			right = move;
		}

		public void sprinting(boolean travel) {
			if (travel) {
				sprint = true;
				speed = 1;
			} else {
				sprint = false;
				speed = 1;
				
			}
		}

}
