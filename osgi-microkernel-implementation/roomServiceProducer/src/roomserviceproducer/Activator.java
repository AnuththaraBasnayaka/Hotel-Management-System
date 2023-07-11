package roomserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegistration;
	
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("========== Producer service started ============");
		
		Room roomService = new roomCheckImpl();
		serviceRegistration = bundleContext.registerService(Room.class.getName(),roomService, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("========== Producer service stopped ============");
		serviceRegistration.unregister();
	}

}
