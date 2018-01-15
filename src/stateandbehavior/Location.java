package stateandbehavior;

public class Location {
	
	int x,y;
	
	public void up() {
		y-=1;
	}
	
	public void down() {
		y+=1;
	}
	
	public void left() {
		x-=1;
	}
	
	public void right() {
		x+=1;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "x:" + x + " " + "y: " + y;
	}
	
	public static void main(String[] args) {
		Location loc = new Location();
		System.out.println(loc);
		loc.down();
		loc.right();
		System.out.println(loc);
		loc.up();
		loc.left();
		System.out.println(loc);
		
	}
	
}
