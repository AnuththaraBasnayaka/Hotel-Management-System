package roomserviceproducer;

import java.util.ArrayList;

public class roomCheckImpl implements Room {

	private ArrayList<String> roomtype = new ArrayList();
	
	
	@Override
	public boolean checkroomType(String room) {
		// TODO Auto-generated method stub
		roomtype.add("Single Room");
		roomtype.add("Double Room");
		roomtype.add("Triple Room");
		roomtype.add("Quad Room");
		roomtype.add("Queen Room");
		roomtype.add("King Room");
		
		if(roomtype.contains(room)==true) {
			System.out.println("Room type available in the hotel");
		}else {
			System.out.println("Sorry..! Room type is not available");
		}
	
		return roomtype.contains(room);
		
	}
	
}
