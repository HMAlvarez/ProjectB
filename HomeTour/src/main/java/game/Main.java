package game;

import java.util.Scanner;

import fixtures.Room;

public class Main {

	private static RoomManager roomManager = new RoomManager(4);
	private static boolean gameRunning = true;

	public static void main(String[] args) {
		roomManager.init();

		Player newPlayer = new Player();
		System.out.println("This is a program that will guide you through a House described by text.\n"
				+ "As you enter each room please type one of the options to progress forward:\n"
				+ "North\n"
				+ "South\n"
				+ "West\n"
				+ "East\n"
				+ "Quit - to end the program\n");
		newPlayer.setCurrentRoom(roomManager.getStartingRoom());
		while (gameRunning) {
			roomDesc(newPlayer);
			String[] userChoice = userInput();
			parse(userChoice, newPlayer);
		}
		if (!gameRunning) {
			System.out.println("Have a good day");

		}		
	}

	private static void roomDesc(Player newPlayer) {
		System.out.println("The current room is the: " + newPlayer.getCurrentRoom().getName()
				+ "\nThe short description is: " + newPlayer.getCurrentRoom().getShortDescription()
				+ "\nThe long description is: " + newPlayer.getCurrentRoom().getLongDescription());
	}

	private static String[] userInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] choice = input.split(" ");
		scanner.close();
		return choice;
	}

	private static void parse(String[] choice, Player newPlayer) {
		String userChoice = choice[0].toString();
		String direction = null;
		direction = userChoice;

		if (userChoice == "Quit") {
			gameRunning = false;
		} else {
			System.out.println("You are attempting to move in the " + direction + " Direction");
			Room attemptMove = newPlayer.getCurrentRoom().findExit(direction);
			newPlayer.setCurrentRoom(attemptMove);
		}

	}

}