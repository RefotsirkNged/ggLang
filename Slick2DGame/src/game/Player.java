package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Player {
	int score = 0;
	Rectangle sprite;
	int keyUp, keyDown, keyLeft, keyRight;
	float velX, velY, speed = 0.5f;
	
	
	public Player(int x, int y, int keyUp, int keyDown, int keyLeft, int keyRight){
		sprite = new Rectangle(x+2,y+2,16,16);
		this.keyUp = keyUp;
		this.keyDown = keyDown;
		this.keyLeft = keyLeft;
		this.keyRight = keyRight;
	}
	
	public void MovementModul(GameContainer gc){
		if(gc.getInput().isKeyPressed(keyLeft)){
			velX = -speed;
			velY = 0;
		}
		else if(gc.getInput().isKeyPressed(keyRight)){
			velX = speed;
			velY = 0;
		}
		else if(gc.getInput().isKeyPressed(keyDown)){
			velY = speed;
			velX = 0;
		}
		else if(gc.getInput().isKeyPressed(keyUp)){
			velY = -speed;
			velX = 0;
		}
	}
	
	public void UpdatePosition(){
		sprite.setX(sprite.getX()+velX);
		sprite.setY(sprite.getY()+velY);
	}
	
	public void DrawCall(Graphics g, Color color){	
		g.setColor(color);
		g.fill(sprite);
	}
	
	public boolean CheckDirCollision(Rectangle collision){
		return true;
	}
}
