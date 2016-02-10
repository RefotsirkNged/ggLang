package game;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Food {
	public int points;
	private Rectangle food = new Rectangle(0,0,10,10);
	private Random rand = new Random();
	
	public Food(int point, GameContainer gc){
		points = point;
		NewPosition(gc);
	}
	
	public void NewPosition(GameContainer gc){
		int randomX = rand.nextInt(gc.getWidth())+1;
		int randomY = rand.nextInt(gc.getHeight())+1;
		food.setX(randomX - (randomX%10));
		food.setY(randomY - (randomY%10));
	}
	
	public boolean InterSect(Rectangle target){
		if(food.intersects(target)){
			return true;
		}
		return false;
	}
	
	public void DrawCall(Graphics g, Color color){
		Color currentColor = g.getColor();
		g.setColor(color);
		g.fill(food);		
		g.setColor(currentColor);
	}
}
