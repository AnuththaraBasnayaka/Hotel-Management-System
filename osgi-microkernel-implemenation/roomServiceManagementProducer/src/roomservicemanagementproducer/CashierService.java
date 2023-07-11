package roomservicemanagementproducer;

import java.util.List;

//Service methods which will provide to the cashier consumers
public interface CashierService {
	public List<Room> displayRooms();//return the item list with room details
	public int generateBill(int id,int qty);//calculates the on going bill continuously as user wish 
	public double displayFinalBillAmount();//displays the final room bill amount
	public String[][] dispalybillDetails();//returns the purchased room list with details
}
