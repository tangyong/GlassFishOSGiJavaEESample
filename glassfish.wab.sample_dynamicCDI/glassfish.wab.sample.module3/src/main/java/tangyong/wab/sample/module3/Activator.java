package tangyong.wab.sample.module3;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import tangyong.wab.sample.core.Module;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		 context.registerService(Module.class.getName(), new Module3(context), null);
	     System.out.println("Module3 started");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		 System.out.println("Module3 stopped");
	}

}
