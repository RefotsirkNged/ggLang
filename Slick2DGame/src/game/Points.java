package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Points {
	Rectangle point;
	
	public Points(int x, int y){
		point = new Rectangle(x+6,y+6,8,8);
	}
	
	public void DrawCall(Graphics g, Color color){	
		g.setColor(color);
		g.fill(point);
	}
}
