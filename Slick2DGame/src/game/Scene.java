package game;

import java.util.ArrayList;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Scene extends BasicGame{
	
	ArrayList<Snake> players = new ArrayList<Snake>();
	Food food ;
	int count = 0;
	int timer = 100;
	
	public Scene(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		players.add(new Snake(Input.KEY_W, Input.KEY_S, Input.KEY_A, Input.KEY_D, new Vector2D(11,11)));
		food = new Food(10, gc);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		count += delta;
		if(timer < count){	
			count = 0;
			for(int i = 0; i < players.size(); i++){
				players.get(i).ControlModul(gc);
				if(food.InterSect(players.get(i).getHead())){
					players.get(i).score += food.points;
					food.NewPosition(gc);
					players.get(i).AddPart();
				}
			}							
		}	
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		food.DrawCall(g, Color.green);
		g.setColor(Color.red);
		for(int i = 0; i < players.size(); i++){
			players.get(i).DrawCall(g, Color.white);
			g.drawString("Player " +Integer.toString(i+1)+"Points: "+ Integer.toString(players.get(i).score), 50,(i*6)*30);
			if(players.get(i).youLost){
				g.drawString("Player "+ Integer.toString(i)+" Lost", gc.getWidth()/2, gc.getHeight()/2);
			}	
		}
	}
}
