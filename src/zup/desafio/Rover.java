package zup.desafio;

/**
 * Created by Mateus Pilo on 10/05/2017.
 * Pacote: desafio.zup.rover
 * Projeto: Rover
 * Ano: 2017
 * Version: 1.00.0
 */

public class Rover {
    private int x;
    private int y;
    private String direction;
    private char[] commandsExploration;

    public Rover(String roverPositon) throws RoverException{
    	
    	String[] positons = roverPositon.split("\\ ");
    	
    	if(positons.length < 3)
    		throw new RoverException("Rover's position invalid.");
    	
    	if(!positons[0].matches("[0-9]*") || !positons[1].matches("[0-9]*"))
    		throw new RoverException("Rover's coordinate is not one number");
    	
    	if(!Directions.containsDirection(positons[2].toUpperCase()))
			throw new RoverException("Rover's direction is not valid");
    	
        this.x = Integer.parseInt(positons[0]);
        this.y = Integer.parseInt(positons[1]);
        this.direction = positons[2].toUpperCase();
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public char[] getCommandsExploration() {
        return commandsExploration;
    }

    public void setCommandsExploration(String commandsExploration) {
        this.commandsExploration = commandsExploration.toUpperCase().toCharArray();
    }

    public void printCurrentCoordinate(){
        System.out.println(String.valueOf(this.x)+" "+String.valueOf(this.y)+" "+this.direction);
    }
}
