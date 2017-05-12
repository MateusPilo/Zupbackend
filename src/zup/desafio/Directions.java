package zup.desafio;

/**
 * Created by Mateus Pilo on 10/05/2017.
 * Pacote: desafio.zup.rover
 * Projeto: Rover
 * Ano: 2017
 * Version: 1.00.0
 */

public class Directions {
	
    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String EAST = "E";
    public static final String WEST = "W";
    
    
    
    public static boolean containsDirection(String direction){
    	switch (direction) {
		case NORTH:
			return true;
		case SOUTH:
			return true;
		case EAST:
			return true;
		case WEST:
			return true;
		default:
			return false;
			
		}
    }
    
    


}
