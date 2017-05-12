package zup.desafio;

import java.util.ArrayList;

/**
 * Created by Mateus Pilo on 10/05/2017.
 * Pacote: desafio.zup.rover
 * Projeto: Rover
 * Ano: 2017
 * Version: 1.00.0
 */

public class Plateau {

    private int maxX;
    private int maxY;
    private ArrayList<Rover> rovers;

    public Plateau(String coordinates) throws RoverException{
    	
    	if(!coordinates.replace(" ", "").matches("[0-9]*"))
    		throw new RoverException("That's not a coordinate");
    	
    	String[] coords = coordinates.split("\\ ");
    	
    	if(coords.length < 2)
    		throw new RoverException("That's not a coordinate");
    	
        this.maxX = Integer.parseInt(coords[0]);
        this.maxY = Integer.parseInt(coords[1]);
         
        this.rovers = new ArrayList<>();
    }

    public void addRover(Rover rover) throws RoverException{
    	if((rover.getX() <= maxX && rover.getX() >= 0 )&&
    			(rover.getY() <= maxY && rover.getY() >= 0))
    		this.rovers.add(rover);
    	else
    		throw new RoverException("Rover invalid, coordinate grater or less than plateau");
    }


    public void explore(){
        for (Rover rover:rovers) {
        	
        	char[] commands = new char[]{};
        	
        	if(rover.getCommandsExploration() != null)
        		commands = rover.getCommandsExploration();

            for (int i = 0; i < commands.length; i++)
                move(rover, String.valueOf(commands[i]));
            
            rover.printCurrentCoordinate();
        }
    }



    private void move(Rover rover,String command){
        switch (rover.getDirection()){
            case Directions.EAST:

                if(command.equals(Commands.TURN_LEFT))
                    rover.setDirection(Directions.NORTH);
                else if(command.equals(Commands.TURN_RIGHT))
                    rover.setDirection(Directions.SOUTH);
                else if(command.equals(Commands.MOVE))
                    rover.setX(rover.getX()+1);

                break;
            case Directions.WEST:

                if(command.equals(Commands.TURN_LEFT))
                    rover.setDirection(Directions.SOUTH);
                else if(command.equals(Commands.TURN_RIGHT))
                    rover.setDirection(Directions.NORTH);
                else if(command.equals(Commands.MOVE))
                    rover.setX(rover.getX()-1);

                break;
            case Directions.NORTH:

                if(command.equals(Commands.TURN_LEFT))
                    rover.setDirection(Directions.WEST);
                else if(command.equals(Commands.TURN_RIGHT))
                    rover.setDirection(Directions.EAST);
                else if(command.equals(Commands.MOVE))
                    rover.setY(rover.getY()+1);

                break;
            case Directions.SOUTH:
                if(command.equals(Commands.TURN_LEFT))
                    rover.setDirection(Directions.EAST);
                else if(command.equals(Commands.TURN_RIGHT))
                    rover.setDirection(Directions.WEST);
                else if(command.equals(Commands.MOVE))
                    rover.setY(rover.getY()-1);
                break;
            default:
                break;
        }
    }
}
