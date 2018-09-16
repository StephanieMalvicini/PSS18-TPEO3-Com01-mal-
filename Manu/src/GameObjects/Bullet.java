package GameObjects;

import GUI.Window;
import Map.Map;

public abstract class Bullet extends Ship{
	protected int daño;
	
	public abstract int getDaño();
	
	public void update(Map map)
	{
		map.onUpdate(this);
		if(getY()<4 || getY()>670)
			destroy();
		super.update(map);
	}





	public void destroy()
	{
		Map.getInstance().destroy(this);
	}
	
	
	
	
}
