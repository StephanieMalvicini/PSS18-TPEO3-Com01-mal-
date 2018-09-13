package Map;



import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SpriteList {
	private String[] list;
	
	 //singletonizar esto si se queda
	public SpriteList() {
		list = new String[20];
		
		list[1] ="C:/Users/Manu/Desktop/project/1.png";
		list[2] ="C:/Users/Manu/Desktop/project/2.png";
		list[3] ="C:/Users/Manu/Desktop/project/3.png";
		list[4] ="C:/Users/Manu/Desktop/project/4.png";
	}
	
	
	
	public  String getSprite(int i) {
		return list[i];
	}
}
