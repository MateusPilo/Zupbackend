package test.java;

import static org.junit.Assert.*;

import org.junit.Test;

import zup.desafio.Plateau;
import zup.desafio.Rover;
import zup.desafio.RoverException;


public class PlateauTest {
	

	@Test
	public void plateauExplorerTest() throws RoverException{
		
			Plateau  p1 = new Plateau("5 5");
			
			// Input Challenge
			Rover r1 = new Rover("1 2 N");
			r1.setCommandsExploration("LMLMLMLMM");
			p1.addRover(r1);
			
			Rover r2 = new Rover("3 3 E");
			r2.setCommandsExploration("MMRMMRMRRM");
			p1.addRover(r2);
			//---
			
			Rover r3 = new Rover("4 3 S");
			r3.setCommandsExploration("MMRMRMRRR");
			p1.addRover(r3);
			
			Rover r4 = new Rover("4 3 S");
			r4.setCommandsExploration("RRRLLLRRR");
			p1.addRover(r4);


			
			Rover r5 = new Rover("1 1 E");
			r5.setCommandsExploration("MMMLMMMR");
			p1.addRover(r5);

			
			
			p1.explore();
			
			//Outputs Challenge
			assertEquals("1 3 N", r1.getX()+" "+r1.getY()+" "+r1.getDirection());
			assertEquals("5 1 E", r2.getX()+" "+r2.getY()+" "+r2.getDirection());
			//--
			
			assertEquals("3 2 W", r3.getX()+" "+r3.getY()+" "+r3.getDirection());
			assertEquals("4 3 E", r4.getX()+" "+r4.getY()+" "+r4.getDirection());
			assertEquals("4 4 E", r5.getX()+" "+r5.getY()+" "+r5.getDirection());
		
	}
	
	
}
