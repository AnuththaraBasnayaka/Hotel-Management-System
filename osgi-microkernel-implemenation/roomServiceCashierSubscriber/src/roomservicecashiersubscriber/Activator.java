	package roomservicecashiersubscriber;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import roomservicemanagementproducer.CashierService;
import roomservicemanagementproducer.Room;

public class Activator implements BundleActivator {
	
	ServiceReference CashierServiceReference;
	
	private boolean exit =false;
	Scanner input = new Scanner(System.in);
	
	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============ SCAD RoomService Cashier Subscriber service started.============");
		CashierServiceReference = context.getServiceReference(CashierService.class.getName());
		@SuppressWarnings("unchecked")
		CashierService cashierService =  (CashierService)context.getService(CashierServiceReference);		//Instance of CashierService
		do {
		int selection = 4;
		do {
			System.out.println("----------------------------Welcome SCAD Hotel Room Cashier Unit------------------------------");
			
		System.out.println("Please Select an option to continue.....");
		System.out.println(" ");
		System.out.println("---------Option List---------- ");
		System.out.println("* View Room Details       - Option 01");
		System.out.println("* Generate customer bills - Option 02");
		System.out.println("* Exit                    - Option 03");
			
		System.out.println("Enter your selection...");
			selection = input.nextInt();
			
			 input.nextLine();
			 
			 if(selection == 3) { //Exits from the cashier consumer program
				 exit = true;
			 }
			 
			 if(selection !=1 && selection !=2 && selection !=3 ) {
				 System.out.println("Please enter a valid selection Number");
			 }
			}while(selection !=1 && selection !=2 && selection !=3);
			
			   String  backToHome = null;
			   String calculateFinalBill = null;
			   int itemCount = -1;
				if (selection == 1) { //Handles the viewing process of item list
					do {
						
					List<Room> listRoom =cashierService.displayRooms();//Consumes the CashierService displayItems()
					
					System.out.println("-----------------------------------SCAD Hotel Room Detail list--------------------------------------------");
					System.out.println(" ");
					System.out.println("Room ID:"+"\t" +"Room Type:"+"\t" + "Room Price:"+"\t" + " Room Discount Percentage:"+"\t" + "Room Final Price:"+"\t");
					
				for(Room tempItem: listRoom ) {
					System.out.println(tempItem.getroomId()+"\t         "+tempItem.getroomType()+"\t         "+tempItem.getroomPrice()+"\t         "+tempItem.getDiscount()+"\t                  "+tempItem.getFinalPrice()+"\t"+"\n");
					
					
					
					
				
				System.out.println("-----------------------------------------------------------------------------------------");
				
					
					}

				System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					}
					
					while(!(backToHome.equals("0")));
					

				}
				
				else if(selection == 2) {//Handles the billing process 
					do {
						do {
							
					System.out.println("---------------------Welcome to next billing --------------------");
					System.out.println("Enter the Room id");
					int id = input.nextInt();
					
					System.out.println("Enter the No.Of Rooms");
					int qty = input.nextInt();
					

					
					int result =cashierService.generateBill(id, qty);//Consumes the CashierService geenrateBill()
					if(result == -1) {
						 System.out.println("Please enter a valid Room number!!");
					}
					else {
						itemCount++;
					}
					input.nextLine();
					System.out.println("Press y to calclate the totoal bill or any other key to continue the billing....");	
					calculateFinalBill=input.nextLine();
					
					
							}while(!(calculateFinalBill.equals("y")));
						
							//Take customer Name Scanner 
							Scanner CustomerName = new Scanner(System.in);  // Create a Scanner object
							System.out.println("Enter Client Name - ");
							String ClientName = CustomerName.nextLine();  // Read user input
							System.out.println("Username is: " + ClientName);  // Output user input
							
							//Show Date 
							DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							Calendar cal = Calendar.getInstance();
						
							System.out.println("-------------------------------SCAD Hotel Room Reservation ----------------------------------------");
							System.out.println("");
							System.out.println("+++++++++Client Details+++++++++");
							System.out.println("");
							System.out.println("Client Name : " + ClientName);  // Output user input
							System.out.println("Date and Time :" + dateFormat.format(cal.getTime()));//Date and Time
							System.out.println("");
							System.out.println("------------------------------------------Receipt----------------------------------------");
							String[][] billDetails= cashierService.dispalybillDetails();//Consumes the cashierService displaybillDetails()
							
							String format = "%-20s";
							System.out.printf(format, "Room ID:");
							System.out.printf(format, "Room Type:");
							System.out.printf(format, "Room Price:");
							System.out.printf(format, "Total:");
							System.out.println("");
							for (int i=0; i<=itemCount; i++) {
								  for (int j=0; j<billDetails[i].length; j++) {
							
								System.out.printf(format,billDetails[i][j]);
								 
								  }
								  System.out.println("");
								  }
							System.out.println("                                                          ----------");
							System.out.println("Subtotal:                                                   " + cashierService.displayFinalBillAmount());//Consumes the cashierService displayFinalBillAmount()
							System.out.println("                                                          ----------");	  
							System.out.println("                                                          ----------");
							System.out.println("");
							
							System.out.println("------------------------------------Thank You!---------------------------------------------------");
							
					  
							itemCount=-1;
							
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					backToHome=input.nextLine();
					
					}
					
					while(!(backToHome.equals("0")));
				}
				else if(selection == 3) {
					return;
				}
			}while(!exit);
			
		}
		
	
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("========== SCAD RoomService Cashier Subscriber service stopped ============");
		bundleContext.ungetService(CashierServiceReference);
	}

}
