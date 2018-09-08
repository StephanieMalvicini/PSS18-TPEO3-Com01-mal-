package GameObjects;

public class Vector2 {
	private int x,y;
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
		versorizar();
	}

	private void versorizar() {
		double norma = Math.sqrt((x*x) + (y*y));
		x /= norma;
		y /= norma;
		
	}
	
	public void setDirec(int x, int y) {
		this.x = x;
		this.y = y;
		versorizar();
	}
	

}
