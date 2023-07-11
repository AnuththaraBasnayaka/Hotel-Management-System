package roomservicemanagementproducer;

import java.util.List;

public interface ManagerService {
	public   int addRooms(String roomType,double roomPrice,double roomDiscount);//Adds the new Rooms to the item list
	public   int updateRooms(String updatedRoomType,double updatedRoomPrice,double updatedRoomDiscount);//Updates the Rooms details
	public   int removeRooms(String roomType);//Removes the Rooms from the list
	public   int searchitems(String roomType);//Searches and Room by name
	public   List<Room> listRoom();//Returns the Room list
}