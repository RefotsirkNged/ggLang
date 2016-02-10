package game;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Snake {
	Vector2D vel = new Vector2D(0,0);
	ArrayList<Rectangle> snake = new  ArrayList<Rectangle>();
	private int keyUp, keyDown, keyLeft, keyRight; 
	int score;
	boolean youLost;
	public Snake(int keyUp, int keyDown, int keyLeft, int keyRight, Vector2D startPostion){
		snake.add(new Rectangle(startPostion.x, startPostion.y,8,8));	
		this.keyUp = keyUp;
		this.keyDown = keyDown;
		this.keyLeft = keyLeft;
		this.keyRight = keyRight;
	}
	
	public void ControlModul(GameContainer gc){
		AppGameContainer appgc = (AppGameContainer) gc;
		if(gc.getInput().isKeyDown(keyDown) && vel.y != -10){
			vel.SetVec(0, 10);
		}
		else if(gc.getInput().isKeyDown(keyUp)&& vel.y != 10){
			vel.SetVec(0, -10);
		}
		else if(gc.getInput().isKeyDown(keyLeft)&& vel.x != 10){
			vel.SetVec(-10, 0);
		}
		else if(gc.getInput().isKeyDown(keyRight)&& vel.x != -10){				
			vel.SetVec(10, 0);
		}
		
		for(int i = snake.size()-1; i > 0; i--){
			snake.get(i).setY(snake.get(i-1).getY());
			snake.get(i).setX(snake.get(i-1).getX());
		}
		
		snake.get(0).setX(snake.get(0).getX()+vel.x);
		snake.get(0).setY(snake.get(0).getY()+vel.y);
		
		for(int i = 1; i < snake.size(); i++){
			if(snake.get(0).intersects(snake.get(i))){
				youLost = true;
			}
		}
		if(snake.get(0).getX() < 0 || snake.get(0).getY() < 0 ){
			youLost = true;
		}
		else if(snake.get(0).getX() > appgc.getWidth() || snake.get(0).getY() > appgc.getHeight() ){
			youLost = true;
		}
	}
	
	public void AddPart(){
		snake.add(new Rectangle(-10,-10,8,8));
	}
	
	public Rectangle getHead(){
		return snake.get(0);
	}
	
	public void DrawCall(Graphics g, Color color){
		Color currentColor = g.getColor();
		g.setColor(color);
		for(int i = 0; i < snake.size(); i++){
			g.fill(snake.get(i));
		}
		g.setColor(currentColor);
	}
}
