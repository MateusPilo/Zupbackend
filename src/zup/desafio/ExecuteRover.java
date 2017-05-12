package zup.desafio;

import java.util.Scanner;

public class ExecuteRover {

	public static void main(String[] args) {
		boolean isAddRover = true;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Coordinates of Plateau:");
		String plateauCoodinates = sc.nextLine();
		
		Plateau plateau = null;
		try {
			plateau = new Plateau(plateauCoodinates);
		} catch (RoverException e) {
			System.out.println(e.getMessage());
			System.exit(0);
			
		}
		
		while (isAddRover) {
			try {
				
				System.out.println("Rover's Position: ");
				String postion = sc.nextLine();
				
				System.out.println("Rover's Instruction: ");
				String instruction = sc.nextLine();
				
				
				Rover rover = new Rover(postion);
				rover.setCommandsExploration(instruction);
				plateau.addRover(rover);
				
				
				System.out.println("Do you want add to one more Rover (Y - Yes)?");
				String confirm = sc.nextLine();
				if(!confirm.toUpperCase().equals("Y"))
					isAddRover = false;
				
				
			} catch (RoverException e) {
				System.out.println(e.getMessage());
				
			}			
		}
		
		plateau.explore();
		
		sc.close();
		

	}


}
