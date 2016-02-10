package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Wall {
	public Rectangle wall;
 
	public Wall(int x, int y, int width, int height){
		 wall = new Rectangle(x,y,width,height);
	 }
	
	public void DrawCall(Graphics g, Color color){	
		g.setColor(color);
		g.fill(wall);
	}
}
