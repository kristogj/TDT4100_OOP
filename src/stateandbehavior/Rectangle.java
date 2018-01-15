package stateandbehavior;

public class Rectangle {

	
	int topLeftX,topLeftY, bottomRightX, bottomRightY;
	int width,height;
	
	public Rectangle() {
		
	}
	
	////////////////////////// Spørremetoder //////////////////////////
	
	public boolean isEmpty() {
		return this.width == 0;
	}
	
	public int getMinX() {
		if (!this.isEmpty()) {
			return this.topLeftX;
		}
		return 0;
	}
	
	public int getMinY() {
		if (!this.isEmpty()) {
			return this.topLeftY;
		}
		return 0;
	}
	
	public int getMaxX() {
		if (!this.isEmpty()) {
			return this.bottomRightX;
		}
		return 0;
	}
	
	public int getMaxY() {
		if (!this.isEmpty()) {
			return this.bottomRightY;
		}
		return 0;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public boolean contains(int x, int y) {
		return true;
	}
	
	////////////////////////// Endringsmetoder //////////////////////////
	
	public boolean add(int x, int y) {
		if (this.isEmpty()) {
			this.topLeftX = x;
			this.topLeftY = y;
			return true;
		}
		else if (!this.contains(x,y)){
			if (x < this.topLeftX || y < this.topLeftY) {
				this.topLeftX = x;
				this.topLeftY = y;
			}
			else {
				this.bottomRightX = x;
				this.bottomRightY = y;
			}
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
