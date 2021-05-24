package game;

import fixtures.Room;

public class Player {

	Room currentRoom;
	
	public Player() {
		
	}
	
	public Player(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}

}