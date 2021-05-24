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
				+ "As you enter each room please type one of the four cardinal directions to progress forward:\n"
				+ "[North] [South] [West] [East]\n\n"
				+ "or \n\n"
				+ "[Quit] - to end the program\n");
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
		System.out.println("The current room: " + newPlayer.getCurrentRoom().getName()
				+ "\nA short description: " + newPlayer.getCurrentRoom().getShortDescription()
				+ "\nA long description: " + newPlayer.getCurrentRoom().getLongDescription());
	}

	private static String[] userInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String[] choice = input.split(" ");
		return choice;
	}

	private static void parse(String[] choice, Player newPlayer) {
		String userChoice = choice[0].toString();
		String direction = null;
		direction = userChoice;

		if (userChoice == "Quit") {
			gameRunning = false;
		} else {
			System.out.println("You have selected to go [" + direction + "]");
			Room attemptMove = newPlayer.getCurrentRoom().findExit(direction);
			newPlayer.setCurrentRoom(attemptMove);
		}

	}

}