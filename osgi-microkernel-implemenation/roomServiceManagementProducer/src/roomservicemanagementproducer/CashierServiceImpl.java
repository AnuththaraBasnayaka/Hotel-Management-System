package roomservicemanagementproducer;

import java.util.List;

public class CashierServiceImpl implements CashierService{
	
	private List<Room> itemList = DataStore.roomsList;//Room list details in the SCAD Hotel  
	private double bill;//to store the bill value
	private String[][] billdetails = new String[1000][4]; //To store the purchased rooms's details , Assumption:only 1000 different items are allowed for an order
	private int count = -1; //to store the Room count [starts from 0]

	

	@Override
	public List<Room> displayRooms() {
		return DataStore.roomsList;
		
	}
	public int generateBill(int id,int qty) {
		

		boolean valid = false;
		Room currentRoom = null;
		for (Room tempRoom : itemList) {
			if(id == tempRoom.getroomId()) {
				currentRoom = tempRoom;
				valid = true;
				count++;
				break;
			}
		}
		if(valid) {
			
		this.bill = this.bill + (currentRoom.getFinalPrice() * qty); 
	
		
		billdetails[count][0]= Integer.toString(id);
		billdetails[count][1]= currentRoom.getroomType();
		
		billdetails[count][2]= Integer.toString(qty);
		billdetails[count][3]= Double.toString((currentRoom.getFinalPrice() * qty));
		
	
		return 1;
		}
		else {
			return -1;
		}
	}
	public double displayFinalBillAmount() {
		double finalBill = this.bill;
		newBill();
		
		return finalBill;
		
	}
	public String[][] dispalybillDetails(){
		
		return billdetails;
	}
	public void newBill() {//To reset all relevant fields to default values 
		this.bill = 0;
		this.count=-1;
		
	}
}
