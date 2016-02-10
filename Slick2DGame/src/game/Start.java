package game;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Start {
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Scene("PacMan"));
			appgc.setDisplayMode(560, 700, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
