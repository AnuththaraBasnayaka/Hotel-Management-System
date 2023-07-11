package roomservicemanagementproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	ServiceRegistration serviceRegistere;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("============ SCAD RoomService Producer service started. ============");
		CashierService cashierSer = new CashierServiceImpl();
		serviceRegistere = bundleContext.registerService(CashierService.class.getName().toString(), cashierSer, null);//registering the cashierService
		ManagerService managerSer = new ManagerServiceImpl();
		serviceRegistere = bundleContext.registerService(ManagerService.class.getName(), managerSer, null); //registering the managerService
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("============== SCAD RoomService Producer service stopped.=============");
		serviceRegistere.unregister();
	}

}
