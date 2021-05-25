package game;

import fixtures.Room;

public class RoomManager {

	public RoomManager() {

	}

	Room startingRoom;

	Room[] rooms;

	public RoomManager(int numRooms) {
		rooms = new Room[numRooms];
	}

	public void init() {
		Room porch = new Room("Front Porch",
				"The area directly outside of the Front Door",
				"There is a front door [North] with a glass panel and bronzed handles. You are surronded by a garden. Behind you is a walkway that led from the driveway ");
		Room entryHall = new Room("Entry Hall",
				"The first hallway entering the home",
				"You enter the home. The wall on the left of you has various family photos and portraits. [North] of you is a living room area. To the [East] there is a kitchen area");
		Room livingRoom = new Room("Living Room",
				"A large room intended for everyday gathering and relaxation",
				"A large room with a couch, reclining chair, TV, and entertainment system. There is no other path besiding going [South] back to the entry hall.");
		Room kitchen = new Room("Kitchen",
				"A room to cook and eat in",
				"A large room with basic kitchen appliances like oven, stove, fridge, microwave, and a sink hugging the wall on the left. On the right there is a wooden table and chairs indended for eating meals.\n" 
				+ "To the [North] leads to the laundry room.");
		
		rooms[0] = porch;
		rooms[1] = entryHall;
		rooms[2] = livingRoom;
		rooms[3] = kitchen;

		startingRoom = porch;

		Room[] porchExits = { entryHall, null, null, null };
		porch.setExits(porchExits);
		Room[] entryHallExits = { livingRoom, porch, null, kitchen };
		entryHall.setExits(entryHallExits);
		Room[] livingRoomExits = { null, entryHall, null, null };
		livingRoom.setExits(livingRoomExits);
		Room[] kitchenExits = { null, entryHall, null, null };
		kitchen.setExits(kitchenExits);
		
	}

	public Room getRoom(int roomNumber) {
		return rooms[roomNumber];
	}

	public Room getStartingRoom() {
		return startingRoom;
	}

	public void setStartingRoom(Room startingRoom) {
		this.startingRoom = startingRoom;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

}