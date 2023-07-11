package roomservicemanagersubscriber;

import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import roomservicemanagementproducer.ManagerService;
import roomservicemanagementproducer.Room;

public class Activator implements BundleActivator {

	ServiceReference ManagerServiceReference;
	Scanner input = new Scanner(System.in);
	
	boolean exit = false;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("========== SCAD RoomService Manager Subscriber service started ============");
		
		ManagerServiceReference = bundleContext.getServiceReference(ManagerService.class.getName());
		@SuppressWarnings("unchecked")
		ManagerService managerService = (ManagerService) bundleContext.getService(ManagerServiceReference); //Instance of managerService
		
		

		do {
		int selection = 7;
		do {
		System.out.println("----------------------------  Welcome SCAD Hotel Room Management Unit  -------------------------------");
	
		System.out.println("Please Select your option to continue .....");
		System.out.println(" ");
		System.out.println("-------- Options List -------- ");
		System.out.println("* Add a new Room Type               - option 01");
		System.out.println("* Update an exsisiting Room Details - option 02");
		System.out.println("* Delete an exsisiting Room Details - option 03");
		System.out.println("* List Room Details                 - option 04");
		System.out.println("* Search Room Details by name       - option 05");
		System.out.println("* Exit                              - option 06");
		
		System.out.println("Enter your selection option  ...");
		selection = input.nextInt();
		
		 input.nextLine();
		 if(selection == 6) {
			 exit = true;
		 }
		 
		 if(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection!=6) {
			 System.out.println("Please enter a valid selection number ");
		 }
		}while(selection !=1 && selection !=2 && selection !=3 && selection !=4 && selection !=5 && selection!=6 );
		
	
        String  backToHome = null;
		if (selection == 1) {//Handles the adding process of new room to the list
			do {
			System.out.println("Room Type");
			String roomType = input.nextLine();

			System.out.println("Room Price");
			double roomPrice = input.nextDouble();

			System.out.println("Room discount");
			double roomDiscount = input.nextDouble();
			input.nextLine();
			
			int result =managerService.addRooms(roomType, roomPrice, roomDiscount); //Subscriber  the ManagerService addroomT()
			String msg = (result ==1) ? "Successfully added the Room Details..!" :"Sorry..! please enter a valid name";
			System.out.println(msg);
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}else if (selection == 2) {//Handles the updating process of an rooms in the list
			do {
				System.out.println("Room Type");
				String updatedRoomType = input.nextLine();

				System.out.println("Room Price");
				double updatedRoomPrice = input.nextDouble();

				System.out.println("Room discount");
				double updatedRoomDiscount = input.nextDouble();
				input.nextLine();
			
				int result =managerService.updateRooms(updatedRoomType, updatedRoomPrice, updatedRoomDiscount);//Subscriber the ManagerService updateRoom Details()
				String msg = (result ==1) ? "Successfully updated the Room Details...!" :"Sorry..! please enter a valid name";
				System.out.println(msg);
				System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
				backToHome=input.nextLine();
			
			}while(!(backToHome.equals("0")));
			
		}
		else if (selection == 3) {//Handles the removing process of an existing room in the list 
			do {
			System.out.println("Enter the Room Type:");

			String roomType = input.nextLine();
			int result =managerService.removeRooms(roomType);//Subscriber the ManagerService removeRoom()
			   String msg = (result ==1) ? "Successfully Removed the Room Details!" :" Sorry..! please enter a valid name";
			   System.out.println(msg);
               System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));


		}
		else if(selection == 4) {//Handles displaying all rooms in the list
			do {
				List<Room> listRoom =managerService.listRoom();//Consumes the ManagerService listRoom()
				System.out.println("--------------------------------- SCAD Hotel Room List --------------------------------------------");
				System.out.println(" ");
				System.out.println("Room ID:"+"\t" +"Room Type:"+"\t" + "Room Price:"+"\t" + "Room discount :"+"\t" + "Item Final Price:"+"\t");
				
			for(Room tempRoom: listRoom ) {
				System.out.println(tempRoom.getroomId()+"\t         "+tempRoom.getroomType()+"\t         "+tempRoom.getroomPrice()+"\t         "+tempRoom.getDiscount()+"\t                  "+tempRoom.getFinalPrice()+"\t"+"\n");
				
			}
			System.out.println("--------------------Thank you---------------------------");
			System.out.println("-----------------------------------------------------------------------------------------");
            System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));

		}
		else if(selection == 5) {//Handles the searching process of an existing room in the list
			do {
			
			System.out.println("Enter the Room name");
			

			String roomType = input.nextLine();
			int result =managerService.searchitems(roomType);//Consumes the ManagerService searchRooms()
			String msg = (result ==1) ? "Room Details are available!" :"Sorry..! Room Details are not available!";
			System.out.println(msg);
			
			System.out.println("Press 0 to navigate back to home or press any other key to continue....");
			
			backToHome=input.nextLine();
			
			}
			
			while(!(backToHome.equals("0")));
		}
		else if(selection == 6) {//Exits form the Manager Subscriber program
			return;
		}
	}while(!exit);
		
	}
	

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("========== SCAD RoomService Manager Subscriber service stopped ============");
		bundleContext.ungetService(ManagerServiceReference);
	}

}
