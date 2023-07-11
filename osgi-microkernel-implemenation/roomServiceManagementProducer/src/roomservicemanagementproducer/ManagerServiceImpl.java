package roomservicemanagementproducer;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
	
	//Implementation of add the Rooms from the list
	@Override
	public synchronized int  addRooms(String roomType,double roomPrice,double roomDiscount) {

		Room newRoom = new Room(DataStore.roomsList.size() + 1, roomType, roomPrice, roomDiscount);
		DataStore.roomsList.add(newRoom);

	return 1;
	}
	
	//Implementation of Update the Rooms from the list
	@Override
	public  synchronized int updateRooms(String updatedRoomType,double updatedRoomPrice,double updatedRoomDiscount) {
		Room RoomToBeUpdated = null;
		boolean invalid = true;
		int count = -1;
		for (Room tempRoom : DataStore.roomsList) {
			count++;
			if (tempRoom.getroomType().equalsIgnoreCase(updatedRoomType)) {

				RoomToBeUpdated = tempRoom;
				invalid = false;
				break;

			}
			
		}
		if (!invalid) {
			RoomToBeUpdated.setroomType(updatedRoomType);
			RoomToBeUpdated.setroomPrice(updatedRoomPrice);
			RoomToBeUpdated.setDiscount(updatedRoomDiscount);
			RoomToBeUpdated.calculateFinalPrice();

			DataStore.roomsList.set(count, RoomToBeUpdated);
			return 1;

		} else {
			return -1;
		}
	}
	
	//Implementation of removes the Rooms from the list
	@Override
	public  synchronized int removeRooms(String roomType) {

		boolean invalid = true;
		int count = -1;
		for (Room tempRoom :DataStore.roomsList) {
			count++;
			if (tempRoom.getroomType().equalsIgnoreCase(roomType)) {

			
				invalid = false;
				break;

			}

		}
		if (!invalid) {

			DataStore.roomsList.remove(count);
			return 1;

		} else {
			return -1;
		}
	}
	
	//Implementation of Searches and item by name
	@Override
	public int searchitems(String roomType) {
		boolean valid = false;
	
		for (Room tempItem : DataStore.roomsList) {
		
			if (tempItem.getroomType().equalsIgnoreCase(roomType)) {
				valid = true;
				break;

			}
		}
		if(valid) {
			return 1;	
		}
		else {
			return -1;
		}
	}
	
	//Implementation of Returns the Room list
	@Override
	public List<Room> listRoom() {

		return DataStore.roomsList;
	}
		
}
