package fixtures;

public class Room extends Fixture {

	private Room[] exits = new Room[4];

	public Room() {

	}

	public Room(String roomName, String shortDesciption, String longDescription) {
		super(roomName, shortDesciption, longDescription);
	}

	public Room[] getExits() {
		return exits;
	}

	public void setExits(Room[] exits) {
		this.exits = exits;
	}

	public void setExits(Room exit, int exitChoice) {
		this.exits[exitChoice] = exit;
	}

	public Room findExit(String userChoice) {
		int exitChoice = 0;
		switch (userChoice) {
		case "North":
			exitChoice = 0;
			break;
		case "South":
			exitChoice = 1;
			break;
		case "West":
			exitChoice = 2;
			break;
		case "East":
			exitChoice = 3;
			break;
		default:
			System.out.println("Please type a valid direction as follows\n"
					+ "[North] [South] [West] [East]\n");
			break;
		}

		if (exits[exitChoice] == null || exitChoice > exits.length) {
			System.out.println("\nThere is no path in that direction!" +
		"\nPlease choose a different direction.\n");
			return this;
		}

		return exits[exitChoice];
	}

}
