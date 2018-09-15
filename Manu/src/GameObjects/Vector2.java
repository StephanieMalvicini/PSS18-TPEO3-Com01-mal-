package GameObjects;

public class Vector2 {
	private int x;
	private int y;

    public static Vector2 Origin() {
    	return new Vector2(0,0);
    }

	public static Vector2 DOWN() {
    	return new Vector2(0,1);
	}
	public static Vector2 UP() {
    	return new Vector2(0,-1);
	}
	public static Vector2 LEFT() {
    	return new Vector2(-1,0);
	}
	public static Vector2 RIGHT() {
    	return new Vector2(1,0);
	}


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
	
	public void setDirec(Vector2 v) {
		this.x = x;
		this.y = y;
		//versorizar();
	}

	public Vector2 sum(Vector2 other)
	{
		return new Vector2(x+other.getX(), y+other.getY());
	}
	

}
