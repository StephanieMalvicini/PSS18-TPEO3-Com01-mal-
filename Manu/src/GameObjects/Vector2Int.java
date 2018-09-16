package GameObjects;



public class Vector2Int {
	private int x;
	private int y;

    public static Vector2Int Origin() {
    	return new Vector2Int(0,0);
    }

	public static Vector2Int DOWN() {
    	return new Vector2Int(0,1);
	}
	public static Vector2Int UP() {
    	return new Vector2Int(0,-1);
	}
	public static Vector2Int LEFT() {
    	return new Vector2Int(-1,0);
	}
	public static Vector2Int RIGHT() {
    	return new Vector2Int(1,0);
	}

	public static Vector2Int Implicit(Vector2 vec)
	{
		int x = Math.round(vec.getX());
		int y = Math.round(vec.getY());
		return new Vector2Int(x,y);
	}


	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Vector2Int(int x, int y) {
		this.x = x;
		this.y = y;
		versorizar();
	}

	private void versorizar() {
		double norma = Math.sqrt((x*x) + (y*y));
		x /= norma;
		y /= norma;
		
	}
	
	public void setDirec(Vector2Int v) {
		this.x = x;
		this.y = y;
		//versorizar();
	}

	public Vector2Int sum(Vector2Int other)
	{
		return new Vector2Int(x+other.getX(), y+other.getY());
	}

	public String toString()
	{
		return "("+x+","+y+")";
	}

}
