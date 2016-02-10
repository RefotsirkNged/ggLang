package game;

public class Start {
	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new game("QuadTree Demo"));
			appgc.setDisplayMode(640, 480, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
