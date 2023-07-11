package roomservicesubscriber;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import roomserviceproducer.Room;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("========== Subscriber service started ============");
		
		serviceReference =bundleContext.getServiceReference(Room.class.getName());
		Room roomservice = (Room)bundleContext.getService(serviceReference);
		
		System.out.println("");
		System.out.println("===== Welcome to the SCAD Hotel =====");
		Scanner roomtypeinput = new Scanner(System.in);
		Scanner serviceNeed = new Scanner(System.in);
		
		String  serviceNeed1 =null;
		String  serviceNeed2 =null;
	    
	    do{
	        System.out.print("Do you need to check room availablity");
	        serviceNeed1=serviceNeed.next();
	        if(serviceNeed1.equalsIgnoreCase("Yes")) 
	        break;
	       
	    }while(serviceNeed2.equalsIgnoreCase("Yes"));
	    

			System.out.println("Enter Room Type - ");
			System.out.println(roomservice.checkroomType(roomtypeinput.nextLine()));
			System.out.print("Do you need to check room availablity");
	        serviceNeed2=serviceNeed.next();
	       }
	
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("========== Subscriber service stopped ============");
		bundleContext.ungetService(serviceReference);
	}
}
