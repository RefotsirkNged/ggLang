package game;

import java.util.ArrayList;

public class Convert {
	public static ArrayList<Wall> ConvertArrayWalls(int[][] walls){
		ArrayList<Wall> myWalls = new ArrayList<Wall>();
		for(int i = 0; i < walls.length; i++){
			for(int j = 0; j < walls[0].length; j++){
				if(walls[i][j] == 1){	
					int countY = 1;
					for(int z = j+1; z < walls.length; z++){
						if(walls[i][z] == 1)
							countY++;
						if(walls[i][z] != 1)
							break;
					}
					myWalls.add(new Wall(20*i, 80+20*j,20,20*countY));
					j+=countY-1;
				}
			}
		}			
		return myWalls;
	}
	public static ArrayList<Points> ConvertArrayPoints(int[][] walls){
		ArrayList<Points> myWalls = new ArrayList<Points>();
		for(int i = 0; i < walls.length; i++){
			for(int j = 0; j < walls[0].length; j++){
				if(walls[i][j] == 2){	
					myWalls.add(new Points(20*i, 80+20*j));
				}
			}
		}			
		return myWalls;
	}
}
